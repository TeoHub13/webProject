package baziproekt.sport.service;

import baziproekt.sport.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    List<Produkt> getAllProductsFromBase();

    Produkt addProduct(productBody body);


    Produkt getProductWithId(Integer id);

    Produkt deleteProduct(Integer id);


    List<Produkt> getAllProductsInWishlistForUser(Integer userId);

    List<NajprodavanProduktView> getNajprodavan();

    List<KriticniProduktiView> getKriticni();

    List<PotrosuvackaPoMesecPatikiView> getPatiki();

    List<PotrosuvackaPoMesecOblekaView> getObleka();

    List<PotrosuvackaPoMesecAksesoariView> getAksesoari();
}
