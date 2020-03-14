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

    @GetMapping("/naracki")
    public List<Naracka> getAllNarackiFromUser(@RequestHeader (name="Authorization") String token)
    {
        return narackaService.getAllNaracki(token);
    }
    @GetMapping("naracki/potrosuvacka")
    public  List<PotrosuvackaPoMesecView> getPotrosuvacka()
    {
        return narackaService.getPotrosuvacka();
    }
    @PostMapping("/naracki/{cartId}")
    public Naracka checkoutCart(@RequestHeader(name = "Authorization") String token, @PathVariable("cartId") Integer cartId, @RequestBody NarackaBody body)

    {
        return narackaService.putNewOrder(token,cartId,body);
    }

}
