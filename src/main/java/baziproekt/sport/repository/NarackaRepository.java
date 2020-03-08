package baziproekt.sport.repository;

import baziproekt.sport.model.Kosnica;
import baziproekt.sport.model.Naracka;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NarackaRepository extends JpaRepository<Naracka,Integer> {

    List<Naracka> findAllByKorisnik_KorisnikId(Integer userId);



}
