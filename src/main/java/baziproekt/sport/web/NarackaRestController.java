package baziproekt.sport.web;

import baziproekt.sport.model.Kosnica;
import baziproekt.sport.model.Naracka;
import baziproekt.sport.model.NarackaBody;
import baziproekt.sport.model.PotrosuvackaPoMesecView;
import baziproekt.sport.service.NarackaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class NarackaRestController {

    private final NarackaService narackaService;

    public NarackaRestController(NarackaService narackaService) {
        this.narackaService = narackaService;
    }

    @GetMapping("/naracki/{userId}")
    public List<Naracka> getAllNarackiFromUser(@PathVariable("userId") Integer userId)
    {
        return narackaService.getAllNaracki(userId);
    }
    @GetMapping("naracki/potrosuvacka")
    public  List<PotrosuvackaPoMesecView> getPotrosuvacka()
    {
        return narackaService.getPotrosuvacka();
    }
    @PostMapping("/naracki/{userId}/{cartId}")
    public Naracka checkoutCart(@PathVariable("userId") Integer userId, @PathVariable("cartId") Integer cartId, @RequestBody NarackaBody body)
    {
        return narackaService.putNewOrder(userId,cartId,body);
    }

}
