package baziproekt.sport.service.impl;

import baziproekt.sport.model.*;
import baziproekt.sport.repository.*;
import baziproekt.sport.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final WishlistRepository wishlistRepository;
    private  final ProizvoditelRepository proizvoditelRepository;
    private final NajprodavanProduktViewRepository najprodavanProduktViewRepository;
    private  final KriticniProduktiViewRepository kriticniProduktiViewRepository;
    private  final  PotrosuvackaPoMesecPatikiViewRepository potrosuvackaPoMesecPatikiViewRepository;
    private final PotrosuvackaPoMesecOblekaViewRepository potrosuvackaPoMesecOblekaViewRepository;
    private final PotrosuvackaPoMesecAksesoariViewRepository potrosuvackaPoMesecAksesoariViewRepository;
    private final MagacinRepository magacinRepository;
    private final MagacinProduktReposiotry magacinProduktReposiotry;
    @Override
    public List<Produkt> getAllProductsFromBase() {
        return  productRepository.findAll();
    }

    @Override
    public Produkt addProduct(productBody body) {
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
        //pm.setMagacin(magacinRepository.findAll().get(0));

        return productRepository.save(produkt);
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
    public List<Produkt> getAllProductsInWishlistForUser(Integer userId) {
        List<Wishlist> wishlists = wishlistRepository.findAllByKorisnik_KorisnikId(userId);
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

}
