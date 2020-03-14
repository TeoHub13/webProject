package baziproekt.sport.service.impl;

import baziproekt.sport.config.JwtTokenUtil;
import baziproekt.sport.model.*;
import baziproekt.sport.repository.KorisnikRepository;
import baziproekt.sport.repository.KosnicaRepository;
import baziproekt.sport.repository.NarackaRepository;
import baziproekt.sport.repository.PotrosuvackaPoMesecViewRepository;
import baziproekt.sport.service.NarackaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public List<Naracka> getAllNaracki(String token) {

        String parts[]=token.split(" ");
       String username=jwtTokenUtil.getUsernameFromToken(parts[1]);
       Korisnik korisnik=korisnikRepository.findByKorisnickoIme(username);
       return narackaRepository.findAllByKorisnik_KorisnikId(korisnik.getKorisnikId());
    }

    @Override
    public Naracka putNewOrder(String token, Integer cartId, NarackaBody body) {
        String parts[]=token.split(" ");
        String username=jwtTokenUtil.getUsernameFromToken(parts[1]);
        Korisnik korisnik1=korisnikRepository.findByKorisnickoIme(username);
        Kosnica kosnica=kosnicaRepository.findByKorisnik_KorisnikIdAndKosnicaId(korisnik1.getKorisnikId(),cartId);
        Korisnik korisnik=korisnikRepository.findByKorisnikId(korisnik1.getKorisnikId());
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
