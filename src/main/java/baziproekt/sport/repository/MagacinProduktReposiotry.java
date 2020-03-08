package baziproekt.sport.repository;

import baziproekt.sport.model.Magacin;
import baziproekt.sport.model.ProduktMagacin;
import baziproekt.sport.model.ProduktMagacinCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MagacinProduktReposiotry extends JpaRepository<ProduktMagacin, ProduktMagacinCompositeKey> {

    /*@Query(value ="select * from ProduktMagacin as k where k.produkt = :pId",nativeQuery = true)
    List<ProduktMagacin> findAllByProdukt(@Param("pId") Integer pId);
*/
    List<ProduktMagacin> findAllByProdukt_ProduktId(Integer productID);

    ProduktMagacin findByProdukt_ProduktId(Integer prId);

    ProduktMagacin getByProdukt_ProduktIdAndAndMagacin_MagacinId(Integer prId,Integer mgId);


}
