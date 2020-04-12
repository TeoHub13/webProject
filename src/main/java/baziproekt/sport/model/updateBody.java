package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class updateBody {

    Integer prId;

    String brend;

    String model;

    Integer proizvoditelId;

    String pol;

    Integer cena;

    BigDecimal popust;

    String slika;
}
