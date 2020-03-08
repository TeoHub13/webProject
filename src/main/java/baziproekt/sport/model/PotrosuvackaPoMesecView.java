package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "potrosuvacka_po_mesec")
public class PotrosuvackaPoMesecView {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mesec;
    private Integer suma;


}
