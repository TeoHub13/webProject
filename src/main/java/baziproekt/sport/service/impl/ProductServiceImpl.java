package baziproekt.sport.service.impl;

import baziproekt.sport.config.JwtTokenUtil;
import baziproekt.sport.model.*;
import baziproekt.sport.repository.*;
import baziproekt.sport.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Produkt produkt=new Produkt();
        produkt.setBrend(body.getBrend());
        produkt.setCena(body.getCena());
        produkt.setPol(body.getPol());
        produkt.setPopust(body.getPopust());
        produkt.setModel(body.getModel());
        produkt.setProizvoditel(proizvoditel);
        produkt.setSlika(body.getSlika());
        ProduktMagacin pm=new ProduktMagacin();

        Patiki patiki=new Patiki();
        patiki.setBrend(body.getBrend());
        patiki.setCena(body.getCena());
        patiki.setPol(body.getPol());
        patiki.setPopust(body.getPopust());
        patiki.setModel(body.getModel());
        patiki.setProizvoditel(proizvoditel);
        patiki.setSlika(body.getSlika());
        patiki.setVelicina(body.getVelicina());
        return patikiRepository.save(patiki);
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
        return oblekaRepository.save(obleka);

    }

    @Override
    public Produkt addAccessories(ClothesBody body) {
        Proizvoditel proizvoditel=proizvoditelRepository.findById(body.getProizvoditelId()).orElseThrow(()->new RuntimeException("nema takov"));
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
        return accessoriesRepository.save(accessories);


    }

    @Override
    public Produkt updateProduct(ProductBody body) {
        Produkt produkt =
                Produkt.builder()
                        .produktId(1)
                        .brend(body.getBrend())
                        .model(body.getModel())
                .build();
        return productRepository.save(produkt);
    }
}
