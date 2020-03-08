package baziproekt.sport.service.impl;

import baziproekt.sport.model.Proizvoditel;
import baziproekt.sport.repository.ProizvoditelRepository;
import baziproekt.sport.service.ProizvoditelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProizvoditelServiceImpl implements ProizvoditelService {
    private final ProizvoditelRepository proizvoditelRepository;

    @Override
    public List<Proizvoditel> getAllManufacturers() {
        return  proizvoditelRepository.findAll();
    }

    @Override
    public Proizvoditel getManufacturerById(Integer id) {
        return proizvoditelRepository.findById(id).orElseThrow(()->new RuntimeException("nema takov proizvoditel"));
    }

    @Override
    public Proizvoditel createAndSaveManuf(Integer id, String name) {
        Optional<Proizvoditel> proizvoditel=proizvoditelRepository.findById(id);
        if(proizvoditel.isPresent())
        {
            throw new RuntimeException("veke postoi takov proizvoditel");
        }
        Proizvoditel proizvoditel1=new Proizvoditel(id,name);
        return proizvoditel1;
    }

    @Override
    public Proizvoditel deleteManufById(Integer id) {
        Proizvoditel proizvoditel=proizvoditelRepository.findById(id).orElseThrow(()->new RuntimeException("nema takov manuf"));
        proizvoditelRepository.deleteById(id);
        return proizvoditel;
    }

}
