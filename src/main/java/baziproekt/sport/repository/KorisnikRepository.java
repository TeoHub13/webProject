package baziproekt.sport.repository;

import baziproekt.sport.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik,Integer> {
    Korisnik findKorisnikByKorisnickoImeAndLozinka(String Kname,String pass);
    Korisnik findByKorisnickoIme(String kName);
    Korisnik findByKorisnikId(Integer userId);
    Korisnik findByMail(String mail);


}
