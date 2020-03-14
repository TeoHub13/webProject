package baziproekt.sport.web;

import baziproekt.sport.model.*;
import baziproekt.sport.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/patiki")
    public List<Patiki> getAllPatiki() {
        return productService.getAllPatiki();
    }


    @GetMapping("/products")
    public List<Produkt> getAllProducts() {
        return productService.getAllProductsFromBase();
    }

    @GetMapping("/products/patiki")
    public List<PotrosuvackaPoMesecPatikiView> getPatiki()
    {
        return  productService.getPatiki();
    }

    @GetMapping("/products/obleka")
    public List<PotrosuvackaPoMesecOblekaView> getObleka()
    {
        return  productService.getObleka();
    }
    @GetMapping("/products/aksesoari")
    public List<PotrosuvackaPoMesecAksesoariView> getAksesoari()
    {
        return  productService.getAksesoari();
    }


    @GetMapping("/products/najprodavan")
    public List<NajprodavanProduktView> getNajprodavan()
    {
        return  productService.getNajprodavan();
    }
    @GetMapping("products/kriticni")
    public List<KriticniProduktiView> getKriticni()
    {
        return  productService.getKriticni();
    }

    @PostMapping("/products")
    public Produkt createAndSave(@RequestBody productBody body ) {
        return this.productService.addProduct(body);
    }


    @GetMapping("/products/{id}")
    public Produkt getProductWithId(@PathVariable("id") Integer id) {
        return this.productService.getProductWithId(id);
    }

    @DeleteMapping("/products/{id}")
    public Produkt deleteProduct(@PathVariable("id") Integer id) {
        return this.productService.deleteProduct(id);
    }


    @GetMapping("/products/users/wishlist")
    public List<Produkt> getProductsInWhishlist(@RequestHeader (name="Authorization") String token) {
        return productService.getAllProductsInWishlistForUser(token);
    }


}

