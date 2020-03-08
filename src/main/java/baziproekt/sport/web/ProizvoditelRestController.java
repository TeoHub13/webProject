package baziproekt.sport.web;

import baziproekt.sport.model.Proizvoditel;
import baziproekt.sport.service.ProizvoditelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class ProizvoditelRestController {
    private  final ProizvoditelService proizvoditelService;
    public ProizvoditelRestController(ProizvoditelService proizvoditelService)
    {
        this.proizvoditelService=proizvoditelService;
    }
    @GetMapping("/proizvoditeli")
    public List<Proizvoditel> getAllManufacturers()
    {
        return proizvoditelService.getAllManufacturers();

    }
    @GetMapping("/proizvoditeli/{id}")
    public Proizvoditel getManufacturerById(@PathVariable("id") Integer id)
    {
        return proizvoditelService.getManufacturerById(id);

    }
    @PostMapping("/proizvoditeli")
    public Proizvoditel createAndSave(@RequestParam Integer id,@RequestParam String name)
    {
        return proizvoditelService.createAndSaveManuf(id,name);
    }
    @DeleteMapping("/proizvoditeli/{id}")
    public Proizvoditel deleteManufById(@PathVariable("id") Integer id)
    {
        return  proizvoditelService.deleteManufById(id);
    }
}