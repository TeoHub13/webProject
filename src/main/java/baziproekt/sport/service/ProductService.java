package baziproekt.sport.service;

import baziproekt.sport.model.*;

import java.util.List;

public interface ProductService {

    List<Produkt> getAllProductsFromBase();

    Produkt addProduct(ProductBody body);


    Produkt getProductWithId(Integer id);

    Produkt deleteProduct(Integer id);


    List<Produkt> getAllProductsInWishlistForUser(String token);

    List<NajprodavanProduktView> getNajprodavan();

    List<KriticniProduktiView> getKriticni();

    List<PotrosuvackaPoMesecPatikiView> getPatiki();

    List<PotrosuvackaPoMesecOblekaView> getObleka();

    List<PotrosuvackaPoMesecAksesoariView> getAksesoari();

    List<Patiki> getAllPatiki();

    List<Obleka> getAllObleka();

    List<Accessories> getAllAccessories();

    Produkt addClothes(ClothesBody body);

    Produkt addAccessories(ClothesBody body);

    Produkt updateProduct(updateBody body);
}
