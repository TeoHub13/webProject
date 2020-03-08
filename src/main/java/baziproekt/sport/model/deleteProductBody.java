package baziproekt.sport.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class deleteProductBody {

    private Integer kosnica;

    private Integer produkt;

    private Integer magacin;

    private Integer kolicina;

}
