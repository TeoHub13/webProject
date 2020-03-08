package baziproekt.sport.web;

import baziproekt.sport.model.Magacin;
import baziproekt.sport.service.MagacinService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class MagacinRestController {

    private final MagacinService magacinService;
    public MagacinRestController(MagacinService magacinService)
    {
        this.magacinService=magacinService;
    }

    @GetMapping("/magacini")
    public List<Magacin> getAllWareHouse()
    {
        return magacinService.getAllWareHouseFromBase();
    }
    @GetMapping("/magacini/{id}")
    public Magacin getWareHouseFromId(@PathVariable("id") Integer id)
    {
        return magacinService.getWareHouseWithId(id);
    }
    @PostMapping("/magacini")
    public Magacin createAndSaveWareHouse(@RequestParam Integer id,@RequestParam String name,@RequestParam String location)
    {
        return  magacinService.createAndSaveWareHouse(id,name,location);
    }
    @DeleteMapping("/magacini/{id}")
    public Magacin deleteMagacin(@PathVariable("id") Integer id)
    {
        return magacinService.deleteWareHouseById(id);
    }


}
