package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductBody {



    String brend;

    String model;

    Integer proizvoditelId;

    String pol;

    Integer cena;

    BigDecimal popust;

    String slika;

    Integer kolicina;

    Integer velicina;
}
