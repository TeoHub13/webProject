package baziproekt.sport.web;

import baziproekt.sport.model.*;
import baziproekt.sport.service.KosnicaService;
import baziproekt.sport.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class KosnicaRestController {
    private final KosnicaService kosnicaService;
    private  final ProductService productService;
    //private final KosnicaProduktMagacinService kosnicaProduktMagacinService;
    public KosnicaRestController(KosnicaService kosnicaService, ProductService productService)
    {
        this.kosnicaService=kosnicaService;
        this.productService = productService;
    }

    //POVIK sto se povikuva na add to card na Front end
    @PostMapping(value = "/users/{usrId}/kosnica/product/{prid}")
    public void addProductToKosnica (@PathVariable("usrId") Integer userId, @PathVariable("prid") Integer productId,@RequestBody kolicinaInput kol) {
        kosnicaService.addProductToKosnica(userId, productId, kol.getKolicina());
    }
    @PostMapping(value = "/users/{userId}/wishlist/product/{prid}")
    public void addProductToWishList(@PathVariable("userId") Integer userId,@PathVariable("prid") Integer productId,@RequestBody PopustCl popustCl)
    {
        kosnicaService.addProductToWishList(userId, productId,popustCl.isPopust());
    }
//    @GetMapping(value = "/wishlist/{userId}")
//    public List<Produkt> getProductsFromWishlist(@PathVariable("userId") Integer userId)
//    {
//        return  kosnicaService.getAllProductsFromWishlist(userId);
//    }
    @PostMapping("/us")
    public void zdrMetod()
    {
        System.out.println("eve rabotam");
    }

    @PostMapping("/kosnica")
    public Kosnica addNewKosnica(@RequestParam Integer kId,Integer koId)
    {
        return  kosnicaService.addNew(kId,koId);
    }

    //Povik sto se povikuva koga korisnikot kje se pridvizi do stranata na kosnicata
    @GetMapping("/kosnica/user/{id}")
    public List<Produkt> getProduktsFromUserKosnica(@PathVariable("id") Integer userId) {
        return kosnicaService.getAllProductInKosica(userId);
    }

    @GetMapping("/kosnica/users/{userId}")
    public List<Kosnica> getAllCarts(@PathVariable Integer id)
    {
        return kosnicaService.getAllCartsOfId(id);
    }


    //todo: kID nema da ti treba , ke ja zemes preku listata (poslednata od listata mu e tekovnata kosica)
    @GetMapping("/kosnica/{userId}")
    public  List<KosnicaProduktMagacin> getCart(@PathVariable Integer userId)
    {
        return  kosnicaService.oneCart(userId,0);
   }
//    @GetMapping("/cart")
//    public Produkt proba(@RequestParam Integer kId)
//    {
//           List<Integer> kosnicaProduktMagacinService.getProdId(kId);
//    }

    @DeleteMapping("/kosnica/{userId}/{kId}")
    public  Kosnica deleteCart(@PathVariable Integer userId,@PathVariable Integer kId)
    {
        return kosnicaService.deleteCart(userId,kId);
    }

    @DeleteMapping("/kosnica/{userId}")
    public void deleteProductFromCart(@PathVariable Integer userId, @RequestBody deleteProductBody key)
    {
         kosnicaService.deleteProductFromCart(key);
    }
    @DeleteMapping("/wishlist/{userId}")
        public void deleteProductFromWishlist(@PathVariable Integer userId, @RequestBody WishlistCompositeKey key)
        {
            kosnicaService.deleteProductFromWishlist(key);
        }


}
