package baziproekt.sport.service.impl;

import baziproekt.sport.model.Korisnik;
import baziproekt.sport.model.Magacin;
import baziproekt.sport.repository.MagacinRepository;
import baziproekt.sport.service.MagacinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MagacinServiceImpl implements MagacinService {
    private final MagacinRepository magacinRepository;
    @Override
    public List<Magacin> getAllWareHouseFromBase() {
        return magacinRepository.findAll();
    }

    @Override
    public Magacin getWareHouseWithId(Integer id) {
        return magacinRepository.findById(id).orElseThrow(()-> new RuntimeException("nema takov magacin"));

    }

    @Override
    public Magacin createAndSaveWareHouse(Integer id, String name, String location) {
        Optional<Magacin> m1=magacinRepository.findById(id);
        if(m1.isPresent())
        {

            throw new RuntimeException("vekje postoi takov magacin");
        }
        Magacin magacin=new Magacin(id,name,location);
        this.magacinRepository.save(magacin);
        return magacin;

    }

    @Override
    public Magacin deleteWareHouseById(Integer id) {
        Magacin magacin=magacinRepository.findById(id).orElseThrow(()->new RuntimeException("nema takov magacin"));
        magacinRepository.deleteById(id);
        return magacin;
    }
}
