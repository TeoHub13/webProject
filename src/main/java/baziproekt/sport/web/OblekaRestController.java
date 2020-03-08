//package baziproekt.sport.web;
//
//import baziproekt.sport.model.Obleka;
//import baziproekt.sport.service.OblekaService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/products")
//public class OblekaRestController  {
//    private final OblekaService oblekaService;
//    public  OblekaRestController(OblekaService oblekaService)
//    {
//        this.oblekaService=oblekaService;
//    }
//    @GetMapping("/obleka")
//    public List<Obleka> getAllClothes()
//    {
//        return oblekaService.getAllClothes();
//    }
//    @GetMapping("/obleka/{id}")
//    public  Obleka getClothesById(@PathVariable("id") Integer id)
//    {
//        return  oblekaService.getClothesById(id);
//    }
//    @PostMapping("/obleka")
//    public  Obleka createAndSaveClothes(@RequestParam Integer id,@RequestParam String pol,@RequestParam String brend,@RequestParam String model,@RequestParam Integer cena,@RequestParam Integer velicina,@RequestParam String materijal)
//    {
//        return oblekaService.createAndSaveClothes(id,pol,brend,model,cena,velicina,materijal);
//    }
//    @DeleteMapping("/obleka/{id}")
//    public  Obleka deleteClothesById(@PathVariable("id") Integer id)
//    {
//        return oblekaService.deleteById(id);
//    }
//}
