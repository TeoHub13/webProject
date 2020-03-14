package baziproekt.sport.service;

import baziproekt.sport.model.*;

import java.util.List;
import java.util.Optional;

public interface KosnicaService {
    Kosnica addNew(Integer kId, Integer koId);

    List<Kosnica> getAllCartsOfId(Integer id);

    List<KosnicaProduktMagacin> oneCart(String token);

    Kosnica deleteCart(Integer userId, Integer kId);

    void addProductToKosnica(String token, Integer productId, Integer kolicina);

    List<Produkt> getAllProductInKosica(Integer userId);

    void deleteProductFromCart(deleteProductBody key);

    void addProductToWishList(String token, Integer productId, boolean popust);

    void deleteProductFromWishlist(String token,deleteWishBody body);
//
//    List<Produkt> getAllProductsFromWishlist(Integer userId);
}
