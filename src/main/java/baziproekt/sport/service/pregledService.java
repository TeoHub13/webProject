package baziproekt.sport.service;

import baziproekt.sport.model.Pregled;
import baziproekt.sport.model.pregledCompositeKey;

import java.util.List;
import java.util.OptionalDouble;

public interface pregledService {
    
    List<Pregled> getAllRatingById(String token);

    OptionalDouble getAverageOfId(Integer id);

    void deletePregled(String token,Integer prId);

    Pregled UpdateRating(Integer id, Integer prId, Integer rejting);

    OptionalDouble getAverageOfProdId(Integer id);

    Pregled addRating(String token, Integer prId, Integer rejting);
//
//    Pregled postNewRating(Integer id, Integer pId, Integer rejting);
}
