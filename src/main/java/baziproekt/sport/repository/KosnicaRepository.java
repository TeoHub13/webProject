package baziproekt.sport.repository;

import baziproekt.sport.model.Kosnica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KosnicaRepository extends JpaRepository<Kosnica,Integer> {

    List<Kosnica> findAllByKorisnik_KorisnikId(Integer id);

    Kosnica findByKorisnik_KorisnikIdAndKosnicaId(Integer id,Integer kid);

    Kosnica deleteByKorisnik_KorisnikIdAndKosnicaId(Integer id,Integer kid);
}
