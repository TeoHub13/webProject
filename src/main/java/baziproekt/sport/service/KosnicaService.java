package baziproekt.sport.service;

import baziproekt.sport.model.*;

import java.util.List;
import java.util.Optional;

public interface KosnicaService {
    Kosnica addNew(Integer kId, Integer koId);

    List<Kosnica> getAllCartsOfId(Integer id);

    List<KosnicaProduktMagacin> oneCart(Integer userId, Integer kId);

    Kosnica deleteCart(Integer userId, Integer kId);

    void addProductToKosnica(Integer userId, Integer productId, Integer kolicina);

    List<Produkt> getAllProductInKosica(Integer userId);

    void deleteProductFromCart(deleteProductBody key);

    void addProductToWishList(Integer userId, Integer productId, boolean popust);

    void deleteProductFromWishlist(WishlistCompositeKey key);
//
//    List<Produkt> getAllProductsFromWishlist(Integer userId);
}
