package baziproekt.sport.repository;

import baziproekt.sport.model.KosnicaProduktMagacin;
import baziproekt.sport.model.KosnicaProduktMagacinCompositeKey;
import baziproekt.sport.model.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KosnicaProduktMagacinRepository extends JpaRepository<KosnicaProduktMagacin, KosnicaProduktMagacinCompositeKey> {

    @Query(value = "select * from kosnicaproduktmagacin as k where k.kosnica_id = ?1", nativeQuery = true)
    List<KosnicaProduktMagacin> findAllBykosnicaId(Integer id);

    List<KosnicaProduktMagacin> findAllByKosnica_KosnicaId(Integer kosnicaId);

    Integer deleteByKosnica_KosnicaIdAndMagacin_MagacinIdAndProdukt_ProduktId(Integer kId,Integer mId,Integer pId);


}
