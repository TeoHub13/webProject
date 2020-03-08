package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class productBody {



    String brend;

    String model;

    Integer proizvoditelId;

    String pol;

    Integer cena;

    BigDecimal popust;

    String slika;

    Integer kolicina;
}
