package baziproekt.sport.web;


import baziproekt.sport.model.Magacin;
import baziproekt.sport.model.Vraboten;
import baziproekt.sport.service.VrabotenService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class VrabotenRestController {
    private final VrabotenService vrabotenService;

    public  VrabotenRestController(VrabotenService vrabotenService)
    {
        this.vrabotenService=vrabotenService;
    }

        @GetMapping("/vraboteni")
        public List<Vraboten> getAllEmployees()
        {
            return vrabotenService.getAllEmployeesFromBase();
        }
    @GetMapping("/vraboteni/{id}")
    public Vraboten getEmployeeById(@PathVariable("id") Integer id)
    {
        return vrabotenService.getEmployeeById(id);
    }
    @PostMapping("/vraboteni")
    public Vraboten createAndSaveEmployee(@RequestParam Integer id,@RequestParam String name,@RequestParam String prezime,@RequestParam Date denVrabotuvanje, @RequestParam Magacin magacin)
    {
        return  vrabotenService.createAndSaveEmployee(id,name,prezime,denVrabotuvanje, magacin);
    }
    @DeleteMapping("/vraboteni/{id}")
    public Vraboten deleteEmployeeById(@PathVariable("id") Integer id)
    {
        return vrabotenService.deleteEmployeeById(id);
    }

}

