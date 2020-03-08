package baziproekt.sport.service.impl;

import baziproekt.sport.model.Obleka;
import baziproekt.sport.repository.OblekaRepository;
import baziproekt.sport.service.OblekaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OblekaServiceImpl implements OblekaService {
    private final OblekaRepository oblekaRepository;

    @Override
    public List<Obleka> getAllClothes() {
        return oblekaRepository.findAll();
    }

    @Override
    public Obleka getClothesById(Integer id) {
        return oblekaRepository.findById(id).orElseThrow(()->new RuntimeException("nema takvo parce"));
    }

    @Override
    public Obleka createAndSaveClothes(Integer id, String pol, String brend, String model, Integer cena, Integer velicina, String materijal) {
        Optional<Obleka> obleka=oblekaRepository.findById(id);
        if(obleka.isPresent())
        {
            throw new RuntimeException("vekje postoi");
        }
        Obleka o1= null;//new Obleka(id,pol,brend,model,cena,velicina,materijal);
        return oblekaRepository.save(o1);
    }

    @Override
    public Obleka deleteById(Integer id) {
        Obleka obleka=oblekaRepository.findById(id).orElseThrow(()->new RuntimeException("nema takvo parce"));
        oblekaRepository.deleteById(id);
        return obleka;
    }

}
