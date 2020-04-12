package baziproekt.sport.repository;

import baziproekt.sport.model.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Produkt,Integer> {

    Produkt findByProduktId(Integer id);

    Produkt findByModel(String model);

    @Query(value = "select * from produkt",nativeQuery = true)
    List<Produkt> find();

}

