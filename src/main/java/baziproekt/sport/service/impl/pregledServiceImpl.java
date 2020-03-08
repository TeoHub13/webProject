package baziproekt.sport.service.impl;

import baziproekt.sport.model.Korisnik;
import baziproekt.sport.model.Pregled;
import baziproekt.sport.model.Produkt;
import baziproekt.sport.model.pregledCompositeKey;
import baziproekt.sport.repository.KorisnikRepository;
import baziproekt.sport.repository.ProductRepository;
import baziproekt.sport.repository.pregledRepository;
import baziproekt.sport.service.pregledService;
import lombok.AllArgsConstructor;
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
    @Override
    public List<Pregled> getAllRatingById(Integer id) {
        return pregledRepo.findAllByKorisnik_KorisnikId(id);
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
    public Pregled addRating(Integer id, Integer prId, Integer rejting) {
        Korisnik korisnik=korisnikRepository.findByKorisnikId(id);
        Produkt produkt=productRepository.findById(prId).orElseThrow(()-> new RuntimeException("nema"));
        Pregled pregled=new Pregled();
        pregled.setKorisnik(korisnik);
        pregled.setProdukt(produkt);
        pregled.setRejting(rejting);
        return pregledRepo.save(pregled);
    }

    @Override
    @Transactional
    public void deletePregled(Integer id,Integer prId) {
       // Pregled pregled=pregledRepo.findByKorisnik_KorisnikIdAndProdukt_ProduktId(id,prId);
        pregledRepo.deleteByKorisnik_KorisnikIdAndProdukt_ProduktId(id,prId);
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
