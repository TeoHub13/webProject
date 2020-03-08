package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KosnicaProduktMagacinCompositeKey implements Serializable {


    private Integer kosnica;

    private Integer produkt;

    private Integer magacin;


}
