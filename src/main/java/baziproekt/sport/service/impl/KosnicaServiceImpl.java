package baziproekt.sport.service.impl;

import baziproekt.sport.model.*;
import baziproekt.sport.repository.*;

import baziproekt.sport.service.KosnicaService;
import baziproekt.sport.service.MagacinService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KosnicaServiceImpl implements KosnicaService {
    private final KosnicaRepository kosnicaRepository;
    private final KorisnikRepository korisnikRepository;
    private final KosnicaProduktMagacinRepository kosnicaProduktMagacinRepository;
    private final ProductRepository productRepository;
    private final MagacinProduktReposiotry magacinProduktRepository;
    private final  WishlistRepository wishlistRepository;
    private final MagacinRepository magacinRepository;
    @Override
    public Kosnica addNew(Integer kId, Integer koId) {
        Korisnik korisnik = korisnikRepository.findById(kId).orElseThrow(() -> new RuntimeException("nema takov korisnik"));
        Kosnica kosnica = new Kosnica(korisnik, koId);
        kosnicaRepository.save(kosnica);
        return kosnica;
    }

    @Override
    public List<Kosnica> getAllCartsOfId(Integer id) {
        return kosnicaRepository.findAllByKorisnik_KorisnikId(id);
    }

    @Override
    public Kosnica deleteCart(Integer userId, Integer kId) {
        return kosnicaRepository.deleteByKorisnik_KorisnikIdAndKosnicaId(userId, kId);
    }

    @Override
    public List<KosnicaProduktMagacin> oneCart(Integer userId, Integer kId) {
        Optional<Korisnik> userOpt = korisnikRepository.findById(userId);

        List<Kosnica> kosniciNaKorisnik = kosnicaRepository.findAllByKorisnik_KorisnikId(userId);
        Korisnik user = userOpt.orElseThrow(() -> new RuntimeException("Nema korisnik so id = " + userId));

        Kosnica kosnica;
        if (kosniciNaKorisnik.isEmpty()) {
            //NEMA niedna kosnica. Kreirame nova kosnica
            kosnica = new Kosnica();
            kosnica.setKorisnik(user);
            kosnica = kosnicaRepository.save(kosnica);
        } else {
            //TODO zemi ja kosnicata sto ne e procesirana
            kosnica = kosniciNaKorisnik.get(kosniciNaKorisnik.size() - 1);
        }

        return kosnicaProduktMagacinRepository.findAllByKosnica_KosnicaId(kosnica.getKosnicaId());


        // return  kosnicaRepository.findByKorisnik_KorisnikIdAndKosnicaId(userId,kId);
    }

    @Override
    public void addProductToKosnica(Integer userId, Integer productId, Integer kolicina) {
        Optional<Korisnik> userOpt = korisnikRepository.findById(userId);
        Produkt product = productRepository.findByProduktId(productId);
        if(magacinProduktRepository.findByProdukt_ProduktId(productId)==null)
        {
           ProduktMagacin produktMagacin=new ProduktMagacin();
            produktMagacin.setMagacin(magacinRepository.findAll().get(0));
            produktMagacin.setKolicina(30);
            produktMagacin.setProdukt(product);
            magacinProduktRepository.save(produktMagacin);
        }
        //Najdi vo koj magacin se naogja produktot. Zemi eden magacin od kaj so se naogja;
        //Mora da postoi vo baza
        ProduktMagacin produktMagacin = magacinProduktRepository.findAllByProdukt_ProduktId(productId).get(0);
        Magacin magacin = produktMagacin.getMagacin();
        System.out.println(magacin);
        int brojac = 0;
        Korisnik user = userOpt.orElseThrow(() -> new RuntimeException("Nema korisnik so id = " + userId));
        List<Kosnica> kosniciNaKorisnik = kosnicaRepository.findAllByKorisnik_KorisnikId(userId);
        Kosnica kosnica;
        if (kosniciNaKorisnik.isEmpty()) {
            //NEMA niedna kosnica. Kreirame nova kosnica
            kosnica = new Kosnica();
            kosnica.setKorisnik(user);
            kosnica = kosnicaRepository.save(kosnica);
        } else {
            //TODO zemi ja kosnicata sto ne e procesirana
            kosnica = kosniciNaKorisnik.get(kosniciNaKorisnik.size() - 1);
        }
        System.out.println(kosnica);

        KosnicaProduktMagacin kosnicaProduktMagacin = new KosnicaProduktMagacin();
        //vidi posle
        kosnicaProduktMagacin.setKolicina(kolicina);
        kosnicaProduktMagacin.setKosnica(kosnica);
        kosnicaProduktMagacin.setMagacin(magacin);
        kosnicaProduktMagacin.setProdukt(product);

        ProduktMagacin prodMag=magacinProduktRepository.getByProdukt_ProduktIdAndAndMagacin_MagacinId(productId,magacin.getMagacinId());
        int kolku=prodMag.getKolicina();
        prodMag.setKolicina(kolku-kolicina);
        magacinProduktRepository.save(prodMag);
        System.out.println(kosnicaProduktMagacin);
        kosnicaProduktMagacinRepository.save(kosnicaProduktMagacin);
    }

    @Override
    public List<Produkt> getAllProductInKosica(Integer userId) {


        List<Kosnica> kosniciNaKorisnik = kosnicaRepository.findAllByKorisnik_KorisnikId(userId);
        if (kosniciNaKorisnik.isEmpty()) {
            throw new RuntimeException("nema niedna kosnica");
        }

        Kosnica kosnica = kosniciNaKorisnik.get(kosniciNaKorisnik.size() - 1);
        List<KosnicaProduktMagacin> kosnicaProduktMagacins = kosnicaProduktMagacinRepository.findAllBykosnicaId(kosnica.getKosnicaId());
        List<Produkt> produkts = kosnicaProduktMagacins.stream().map(KosnicaProduktMagacin::getProdukt).collect(Collectors.toList());
        return produkts;
    }
//
//    @Override
//    public List<Produkt> getAllProductsFromWishlist(Integer userId) {
//
//        List<Produkt> produkts=wishlistRepository.findAllByKorisnik_KorisnikId(userId);
//        return produkts;
//    }

    @Override
    @Transactional
    public void deleteProductFromCart(deleteProductBody key) {
       // Optional<KosnicaProduktMagacin> kpm=kosnicaProduktMagacinRepository.findById(key);
        ProduktMagacin prodMag=magacinProduktRepository.getByProdukt_ProduktIdAndAndMagacin_MagacinId(key.getProdukt(),key.getMagacin());
        int kolku=prodMag.getKolicina();
        prodMag.setKolicina(kolku+key.getKolicina());
        magacinProduktRepository.save(prodMag);
        kosnicaProduktMagacinRepository.deleteByKosnica_KosnicaIdAndMagacin_MagacinIdAndProdukt_ProduktId(key.getKosnica(),key.getMagacin(),key.getProdukt());


         //  return  kpm;
    }

    @Override
    public void addProductToWishList(Integer userId, Integer productId,boolean popust) {

        Korisnik kor = korisnikRepository.findById(userId).orElseThrow(()->new RuntimeException("nema takov"));
        Produkt prod = productRepository.findByProduktId(productId);
        Wishlist wishlist=new Wishlist();
        wishlist.setKorisnik(kor);
        wishlist.setProdukt(prod);
        wishlist.setPopust(popust);
        wishlistRepository.save(wishlist);

    }

    @Override
    @Transactional
    public void deleteProductFromWishlist(WishlistCompositeKey key) {
        wishlistRepository.deleteByKorisnik_KorisnikIdAndProdukt_ProduktId(key.getKorisnik(),key.getProdukt());
    }

}
