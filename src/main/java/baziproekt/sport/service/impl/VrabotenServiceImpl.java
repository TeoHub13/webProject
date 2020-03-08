package baziproekt.sport.service.impl;

import baziproekt.sport.model.Magacin;
import baziproekt.sport.model.Vraboten;
import baziproekt.sport.repository.VrabotenRepository;
import baziproekt.sport.service.VrabotenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VrabotenServiceImpl implements VrabotenService {
        private VrabotenRepository vrabotenRepository;

    @Override
    public List<Vraboten> getAllEmployeesFromBase() {
        return vrabotenRepository.findAll();
    }

    @Override
    public Vraboten getEmployeeById(Integer id) {
        return vrabotenRepository.findById(id).orElseThrow(()->new RuntimeException("nema takov vraboten"));
    }

    @Override
    public Vraboten createAndSaveEmployee(Integer id, String name, String prezime, Date denVrabotuvanje, Magacin magacin) {
        Optional<Vraboten> v1=vrabotenRepository.findById(id);
        if(v1.isPresent())
        {
            throw new RuntimeException("veke postoi takov");
        }
        Vraboten vraboten=new Vraboten(id,name,prezime,denVrabotuvanje,magacin);
        return vrabotenRepository.save(vraboten);
    }

    @Override
    public Vraboten deleteEmployeeById(Integer id) {

            Vraboten v1=vrabotenRepository.findById(id).orElseThrow(()->new RuntimeException("nema takov vraboten"));
            vrabotenRepository.deleteById(id);
            return v1;
    }

}
