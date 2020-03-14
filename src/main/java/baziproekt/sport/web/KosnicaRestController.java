package baziproekt.sport.web;

import baziproekt.sport.model.*;
import baziproekt.sport.service.KorisnikService;
import baziproekt.sport.service.KosnicaService;
import baziproekt.sport.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class KosnicaRestController {
    private final KosnicaService kosnicaService;
    private  final ProductService productService;
    private final KorisnikService korisnikService;
    //private final KosnicaProduktMagacinService kosnicaProduktMagacinService;


    //POVIK sto se povikuva na add to card na Front end
    @PostMapping(value = "/users/kosnica/product/{prid}")
    public void addProductToKosnica (@RequestHeader (name="Authorization") String token, @PathVariable("prid") Integer productId,@RequestBody kolicinaInput kol) {

        kosnicaService.addProductToKosnica(token, productId, kol.getKolicina());
    }
    @PostMapping(value = "/users/wishlist/product/{prid}")
    public void addProductToWishList(@RequestHeader (name = "Authorization") String token,@PathVariable("prid") Integer productId,@RequestBody PopustCl popustCl)
    {
        kosnicaService.addProductToWishList(token, productId,popustCl.isPopust());
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
    @GetMapping("/kosnica")
    public  List<KosnicaProduktMagacin> getCart(@RequestHeader (name="Authorization") String token)
    {
        return  kosnicaService.oneCart(token);
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

    @DeleteMapping("/kosnica")
    public void deleteProductFromCart(@RequestBody deleteProductBody key)
    {
         kosnicaService.deleteProductFromCart(key);
    }
    @DeleteMapping("/wishlist")
        public void deleteProductFromWishlist(@RequestHeader (name="Authorization") String token,@RequestBody deleteWishBody body)
        {
            kosnicaService.deleteProductFromWishlist(token,body);
        }


}
