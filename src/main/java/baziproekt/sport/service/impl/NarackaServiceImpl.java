package baziproekt.sport.service.impl;

import baziproekt.sport.model.*;
import baziproekt.sport.repository.KorisnikRepository;
import baziproekt.sport.repository.KosnicaRepository;
import baziproekt.sport.repository.NarackaRepository;
import baziproekt.sport.repository.PotrosuvackaPoMesecViewRepository;
import baziproekt.sport.service.NarackaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NarackaServiceImpl implements NarackaService {

    private final NarackaRepository narackaRepository;
    private final KosnicaRepository kosnicaRepository;
    private final KorisnikRepository korisnikRepository;
    private final PotrosuvackaPoMesecViewRepository potrosuvackaPoMesecViewRepository;
    @Override
    public List<Naracka> getAllNaracki(Integer userId) {
       return narackaRepository.findAllByKorisnik_KorisnikId(userId);
    }

    @Override
    public Naracka putNewOrder(Integer userId, Integer cartId, NarackaBody body) {
        Kosnica kosnica=kosnicaRepository.findByKorisnik_KorisnikIdAndKosnicaId(userId,cartId);
        Korisnik korisnik=korisnikRepository.findByKorisnikId(userId);
        Timestamp ts=new Timestamp(body.getDatum().getTime());
        Naracka naracka=new Naracka();
        naracka.setDatum(ts);
        naracka.setKorisnik(korisnik);
        naracka.setKosnica(kosnica);
        naracka.setSuma(body.getSuma());
        Kosnica kosnica1=new Kosnica();
        kosnica1.setKorisnik(korisnik);
        kosnica1.setKosnicaId(cartId+1);
        kosnicaRepository.save(kosnica1);
        return   narackaRepository.save(naracka) ;
    }

    @Override
    public List<PotrosuvackaPoMesecView> getPotrosuvacka() {
        return potrosuvackaPoMesecViewRepository.findAll();
    }
}
