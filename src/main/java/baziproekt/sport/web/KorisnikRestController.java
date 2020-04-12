package baziproekt.sport.web;

import baziproekt.sport.model.Korisnik;
import baziproekt.sport.model.LoginUser;
import baziproekt.sport.model.LoginWBody;
import baziproekt.sport.model.NajaktivenKorisnikView;
import baziproekt.sport.repository.KorisnikRepository;
import baziproekt.sport.service.KorisnikService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin//(origins = "http://localhost:3000")
@RestController
public class KorisnikRestController {

    private final KorisnikService korisnikService;
    public KorisnikRestController(KorisnikService korisnikService)
    {
        this.korisnikService=korisnikService;
    }


    @GetMapping("/users/site")
    public List<Korisnik> getAllUsers()
    {
            return korisnikService.getAllUsersFromBase();
    }

    @GetMapping("/user/najaktiven")
    public  List<NajaktivenKorisnikView> getNajaktiven()
    {
        return korisnikService.getNajaktiven();
    }

    @PostMapping("/users")
    public Korisnik createAndSaveUser(@RequestBody Korisnik korisnik)
    {
        return  this.korisnikService.createAndSaveUser(korisnik);
    }

    @GetMapping("/users/{id}")
    public Korisnik getUserWithId(@PathVariable("id") Integer id)
    {
        return  this.korisnikService.getUserWithId(id);
    }
    @DeleteMapping("/users/{id}")
    public  Korisnik deleteUserWithId(@PathVariable("id") Integer id)
    {
        return  this.korisnikService.deleteUserWithId(id);
    }

    //na klik na submit prati storage
    @PostMapping("/user")
    public LoginUser login(@RequestBody LoginWBody loginInfo)
    {
        Korisnik korisnik=korisnikService.getUser(loginInfo.getKname(),loginInfo.getPass());
        LoginUser loginUser=new LoginUser(korisnik.getKorisnickoIme(),korisnik.getKorisnikId(),korisnik.getUloga());
        return loginUser;
    }


}
