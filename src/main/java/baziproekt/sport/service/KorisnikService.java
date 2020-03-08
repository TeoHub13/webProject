package baziproekt.sport.service;

import baziproekt.sport.model.Korisnik;
import baziproekt.sport.model.NajaktivenKorisnikView;
import org.springframework.stereotype.Service;

import java.util.List;

public interface KorisnikService {

    List<Korisnik> getAllUsersFromBase();

    Korisnik createAndSaveUser(Korisnik korisnik);

    Korisnik getUserWithId(Integer id);

    Korisnik deleteUserWithId(Integer id);

    Korisnik getUser(String kName, String pass);

    List<NajaktivenKorisnikView> getNajaktiven();
}
