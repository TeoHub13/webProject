package baziproekt.sport.service.impl;

import baziproekt.sport.config.JwtTokenUtil;
import baziproekt.sport.model.Korisnik;
import baziproekt.sport.model.Pregled;
import baziproekt.sport.model.Produkt;
import baziproekt.sport.model.pregledCompositeKey;
import baziproekt.sport.repository.KorisnikRepository;
import baziproekt.sport.repository.ProductRepository;
import baziproekt.sport.repository.pregledRepository;
import baziproekt.sport.service.pregledService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@AllArgsConstructor
public class pregledServiceImpl implements pregledService {

    private final pregledRepository pregledRepo;
    private final KorisnikRepository korisnikRepository;
    private final ProductRepository productRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public List<Pregled> getAllRatingById(String token) {
        String parts[]=token.split(" ");
        String username=jwtTokenUtil.getUsernameFromToken(parts[1]);
        Korisnik korisnik=korisnikRepository.findByKorisnickoIme(username);
        return pregledRepo.findAllByKorisnik_KorisnikId(korisnik.getKorisnikId());
    }

    @Override
    public OptionalDouble getAverageOfId(Integer id) {
        List<Pregled>pregledi=pregledRepo.findAllByKorisnik_KorisnikId(id);
        OptionalDouble rejtings = pregledi.stream().mapToDouble(Pregled::getRejting).average();
        return  rejtings;
    }

    @Override
    public OptionalDouble getAverageOfProdId(Integer id) {
        List<Pregled>pregledi=pregledRepo.findAllByProdukt_ProduktId(id);
        OptionalDouble rate=pregledi.stream().mapToDouble(Pregled::getRejting).average();
        return rate;
    }

    @Override
    public Pregled addRating(String token, Integer prId, Integer rejting) {
        String parts[]=token.split(" ");
        String username=jwtTokenUtil.getUsernameFromToken(parts[1]);
        Korisnik korisnik=korisnikRepository.findByKorisnickoIme(username);
       // Korisnik korisnik=korisnikRepository.findByKorisnikId(id);
        Produkt produkt=productRepository.findById(prId).orElseThrow(()-> new RuntimeException("nema"));
        Pregled pregled=new Pregled();
        pregled.setKorisnik(korisnik);
        pregled.setProdukt(produkt);
        pregled.setRejting(rejting);
        return pregledRepo.save(pregled);
    }

    @Override
    @Transactional
    public void deletePregled(String token,Integer prId) {
       // Pregled pregled=pregledRepo.findByKorisnik_KorisnikIdAndProdukt_ProduktId(id,prId);
        String parts[]=token.split(" ");
        String username=jwtTokenUtil.getUsernameFromToken(parts[1]);
        Korisnik korisnik=korisnikRepository.findByKorisnickoIme(username);
        pregledRepo.deleteByKorisnik_KorisnikIdAndProdukt_ProduktId(korisnik.getKorisnikId(),prId);
    }

    @Override
    public Pregled UpdateRating(Integer id, Integer prId, Integer rejting) {
        Pregled pregled=pregledRepo.findByKorisnik_KorisnikIdAndProdukt_ProduktId(id,prId);
        if(pregled.getRejting()==rejting)
        {
            return pregled;
        }
        else
        {
            pregled.setRejting(rejting);
            return pregled;
        }
    }



//    @Override
//    public Pregled postNewRating(Integer id, Integer pId, Integer rejting) {
//        Pregled pregled=pregledRepo.findByKorisnik_KorisnikIdAndProdukt_ProduktId(id,pId);
//        if(pregled.getRejting()==rejting)
//        {
//            throw  new RuntimeException("vekje postoi takov");
//        }
//        else
//        {
//            Pregled pregled1=new Pregled(id,pId,rejting);
//        }
//    }


}
