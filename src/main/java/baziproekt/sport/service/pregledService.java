package baziproekt.sport.service;

import baziproekt.sport.model.Pregled;
import baziproekt.sport.model.pregledCompositeKey;

import java.util.List;
import java.util.OptionalDouble;

public interface pregledService {
    
    List<Pregled> getAllRatingById(Integer id);

    OptionalDouble getAverageOfId(Integer id);

    void deletePregled(Integer id,Integer prId);

    Pregled UpdateRating(Integer id, Integer prId, Integer rejting);

    OptionalDouble getAverageOfProdId(Integer id);

    Pregled addRating(Integer id, Integer prId, Integer rejting);
//
//    Pregled postNewRating(Integer id, Integer pId, Integer rejting);
}
