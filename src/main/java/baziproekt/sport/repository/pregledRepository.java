package baziproekt.sport.repository;

import baziproekt.sport.model.Pregled;
import baziproekt.sport.model.pregledCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface pregledRepository extends JpaRepository<Pregled, pregledCompositeKey> {

    List<Pregled> findAllByKorisnik_KorisnikId(Integer id);

    Integer deleteByKorisnik_KorisnikIdAndProdukt_ProduktId(Integer id,Integer prId);

    Pregled findByKorisnik_KorisnikIdAndProdukt_ProduktId(Integer id,Integer prId);

    List<Pregled> findAllByProdukt_ProduktId(Integer id);




}
