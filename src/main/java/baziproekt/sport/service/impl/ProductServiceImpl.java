package baziproekt.sport.service.impl;

import baziproekt.sport.config.JwtTokenUtil;
import baziproekt.sport.model.*;
import baziproekt.sport.repository.*;
import baziproekt.sport.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private  final  PatikiRepository patikiRepository;
    private final ProductRepository productRepository;
    private  final KorisnikRepository korisnikRepository;
    private final WishlistRepository wishlistRepository;
    private  final ProizvoditelRepository proizvoditelRepository;
    private final NajprodavanProduktViewRepository najprodavanProduktViewRepository;
    private  final KriticniProduktiViewRepository kriticniProduktiViewRepository;
    private  final  PotrosuvackaPoMesecPatikiViewRepository potrosuvackaPoMesecPatikiViewRepository;
    private final PotrosuvackaPoMesecOblekaViewRepository potrosuvackaPoMesecOblekaViewRepository;
    private final PotrosuvackaPoMesecAksesoariViewRepository potrosuvackaPoMesecAksesoariViewRepository;
    private final MagacinRepository magacinRepository;
    private  final OblekaRepository oblekaRepository;
    private final AccessoriesRepository accessoriesRepository;
    private final MagacinProduktReposiotry magacinProduktReposiotry;
    @Override
    public List<Produkt> getAllProductsFromBase() {
        return  productRepository.findAll();
    }
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public Produkt addProduct(ProductBody body) {
        Proizvoditel proizvoditel=proizvoditelRepository.findById(body.getProizvoditelId()).orElseThrow(()->new RuntimeException("nema takov"));
        Magacin magacin=magacinRepository.findById(body.getMagacinId()).orElseThrow(()-> new RuntimeException("nema magacin"));
        Patiki patiki=new Patiki();
        patiki.setBrend(body.getBrend());
        patiki.setCena(body.getCena());
        patiki.setPol(body.getPol());
        patiki.setPopust(body.getPopust());
        patiki.setModel(body.getModel());
        patiki.setProizvoditel(proizvoditel);
        patiki.setSlika(body.getSlika());
        patiki.setVelicina(body.getVelicina());
        patikiRepository.save(patiki);
//        Produkt produkt=new Produkt();
//        produkt.setBrend(body.getBrend());
//        produkt.setCena(body.getCena());
//        produkt.setPol(body.getPol());
//        produkt.setPopust(body.getPopust());
//        produkt.setModel(body.getModel());
//        produkt.setProizvoditel(proizvoditel);
//        produkt.setSlika(body.getSlika());
        Produkt produkt=productRepository.findByModel(patiki.getModel());
        ProduktMagacin pm=new ProduktMagacin();
        pm.setProdukt(produkt);
        pm.setKolicina(body.getKolicina());
        pm.setMagacin(magacin);
        magacinProduktReposiotry.save(pm);
        return patiki;
        //pm.setMagacin(magacinRepository.findAll().get(0));
       //  return productRepository.save(produkt);
    }

    @Override
    public Produkt getProductWithId(Integer id) {
        Produkt produkt=this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("nema takov produkt"));
        return produkt;
    }

    @Override
    public Produkt deleteProduct(Integer id) {
        Produkt produkt=this.productRepository.findById(id).orElseThrow(()->new RuntimeException("nema takov produkt"));
        productRepository.delete(produkt);
        return produkt;

    }

    @Override
    public List<Produkt> getAllProductsInWishlistForUser(String token) {
        String parts[]=token.split(" ");
        String username=jwtTokenUtil.getUsernameFromToken(parts[1]);
        Korisnik korisnik=korisnikRepository.findByKorisnickoIme(username);
        List<Wishlist> wishlists = wishlistRepository.findAllByKorisnik_KorisnikId(korisnik.getKorisnikId());
        List<Produkt> produkts = wishlists.stream().map(Wishlist::getProdukt).collect(Collectors.toList());
        return produkts;
    }

    @Override
    public List<NajprodavanProduktView> getNajprodavan() {

        return najprodavanProduktViewRepository.findAll();
    }

    @Override
    public List<KriticniProduktiView> getKriticni() {
        return kriticniProduktiViewRepository.findAll();
    }

    @Override
    public List<PotrosuvackaPoMesecPatikiView> getPatiki() {
        return potrosuvackaPoMesecPatikiViewRepository.findAll();
    }

    @Override
    public List<PotrosuvackaPoMesecOblekaView> getObleka() {
        return potrosuvackaPoMesecOblekaViewRepository.findAll();
    }

    @Override
    public List<PotrosuvackaPoMesecAksesoariView> getAksesoari() {
        return potrosuvackaPoMesecAksesoariViewRepository.findAll();
    }

    @Override
    public List<Patiki> getAllPatiki() {
        return patikiRepository.findAll();
    }

    @Override
    public List<Obleka> getAllObleka() {
        return oblekaRepository.findAll();
    }

    @Override
    public List<Accessories> getAllAccessories() {
        return accessoriesRepository.findAll();
    }

    @Override
    public Produkt addClothes(ClothesBody body) {
        Proizvoditel proizvoditel=proizvoditelRepository.findById(body.getProizvoditelId()).orElseThrow(()->new RuntimeException("nema takov"));
        Magacin magacin=magacinRepository.findById(body.getMagacinId()).orElseThrow(()->new RuntimeException("nema takov magacin") );
        Obleka obleka=new Obleka();
        obleka.setBrend(body.getBrend());
        obleka.setCena(body.getCena());
        obleka.setPol(body.getPol());
        obleka.setPopust(body.getPopust());
        obleka.setModel(body.getModel());
        obleka.setProizvoditel(proizvoditel);
        obleka.setSlika(body.getSlika());
        obleka.setVelicina(body.getVelicina());
        obleka.setMaterijal(body.getMaterijal());
        oblekaRepository.save(obleka);
        Produkt produkt=productRepository.findByModel(obleka.getModel());
        ProduktMagacin pm=new ProduktMagacin();
        pm.setProdukt(produkt);
        pm.setKolicina(body.getKolicina());
        pm.setMagacin(magacin);
        magacinProduktReposiotry.save(pm);
        return obleka;

        //return oblekaRepository.save(obleka);

    }

    @Override
    public Produkt addAccessories(ClothesBody body) {
        Proizvoditel proizvoditel=proizvoditelRepository.findById(body.getProizvoditelId()).orElseThrow(()->new RuntimeException("nema takov"));
        Magacin magacin=magacinRepository.findById(body.getMagacinId()).orElseThrow(()->new RuntimeException("nema takov magacin"));
        Accessories accessories=new Accessories();
        accessories.setBrend(body.getBrend());
        accessories.setCena(body.getCena());
        accessories.setPol(body.getPol());
        accessories.setPopust(body.getPopust());
        accessories.setModel(body.getModel());
        accessories.setProizvoditel(proizvoditel);
        accessories.setSlika(body.getSlika());
        accessories.setVelicina(body.getVelicina());
        accessories.setMaterijal(body.getMaterijal());
        accessoriesRepository.save(accessories);
        Produkt produkt=productRepository.findByModel(accessories.getModel());
        ProduktMagacin pm=new ProduktMagacin();
        pm.setProdukt(produkt);
        pm.setKolicina(body.getKolicina());
        pm.setMagacin(magacin);
        magacinProduktReposiotry.save(pm);
        return accessories;


    }

    @Override
    public Produkt updateProduct(updateBody body) {
        Proizvoditel proizvoditel=proizvoditelRepository.findById(body.getProizvoditelId()).orElseThrow(()-> new RuntimeException("nema takov"));
        Produkt produkt =productRepository.findById(body.getPrId()).orElseThrow(()->new RuntimeException("nema takov"));
//                Produkt.builder()
//                        .produktId(body.getPrId())
//                        .brend(body.getBrend())
//                        .model(body.getModel())
//                        .cena(body.getCena())
//                        .pol(body.getPol())
//                        .slika(body.getSlika())
//                        . proizvoditel(proizvoditel)
//                .build();
        produkt.setSlika(body.getSlika());
        produkt.setProizvoditel(proizvoditel);
        produkt.setModel(body.getModel());
        produkt.setBrend(body.getBrend());
        produkt.setPopust(body.getPopust());
        produkt.setCena(body.getCena());
        return productRepository.save(produkt);
    }
}
