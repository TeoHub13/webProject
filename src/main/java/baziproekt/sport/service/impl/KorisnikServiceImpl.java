package baziproekt.sport.service.impl;

import baziproekt.sport.model.JwtRequest;
import baziproekt.sport.model.Korisnik;
import baziproekt.sport.model.NajaktivenKorisnikView;
import baziproekt.sport.repository.KorisnikRepository;
import baziproekt.sport.repository.NajaktivenKorisnikViewRepository;
import baziproekt.sport.service.KorisnikService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;
    private final NajaktivenKorisnikViewRepository najaktivenKorisnikViewRepository;

    @Override
    public List<Korisnik> getAllUsersFromBase() {
        return korisnikRepository.findAll();
    }

    @Override
    public Korisnik createAndSaveUser(Korisnik korisnik) {
       Optional<Korisnik> kor= Optional.ofNullable(korisnikRepository.findByMail(korisnik.getMail()));
        if(kor.isPresent())
        {
            throw new RuntimeException("the mail you entered is already in use");
        }
        Korisnik korisnik1=new Korisnik();
        korisnik1.setIme(korisnik.getIme());
        korisnik1.setPrezime(korisnik.getPrezime());
        korisnik1.setKorisnickoIme(korisnik.getKorisnickoIme());
        korisnik1.setLozinka(korisnik.getLozinka());
        korisnik1.setMail(korisnik.getMail());
        korisnik1.setUloga(korisnik.getUloga());
         this.korisnikRepository.save(korisnik1);
        return korisnik1;
    }

    @Override
    public Korisnik getUserWithId(Integer id) {
        return  this.korisnikRepository.findById(id).orElseThrow(()-> new RuntimeException("nema takov korisnik"));
    }

    @Override
    public Korisnik deleteUserWithId(Integer id) {
        Korisnik korisnik=korisnikRepository.findById(id).orElseThrow(()->new RuntimeException("nema takov korisnik"));
        this.korisnikRepository.delete(korisnik);
        return  korisnik;
    }

    @Override
    public Korisnik getUser(String kName, String pass) {
        Korisnik korisnik = korisnikRepository.findKorisnikByKorisnickoImeAndLozinka(kName,pass);
        return korisnik;


    }

    @Override
    public List<NajaktivenKorisnikView> getNajaktiven() {
        return najaktivenKorisnikViewRepository.findAll();
    }
//
//    @Override
//    public Korisnik getKorinsikByUsername(JwtRequest authenticationRequest) {
//        return korisnikRepository.findByKorisnickoIme(authenticationRequest.getUsername());
//    }


}
