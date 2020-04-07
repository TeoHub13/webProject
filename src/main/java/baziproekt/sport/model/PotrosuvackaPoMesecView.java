package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Immutable
@Entity(name = "potrosuvacka_po_mesec")
public class PotrosuvackaPoMesecView {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mesec;
    private Integer suma;


}
