package baziproekt.sport.model;


import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Immutable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Immutable
@Entity(name = "potrosuvacka_po_mesec_obleka")
@IdClass(PotrosuvackaPoMesecOblekaCompositeKey.class)
public class PotrosuvackaPoMesecOblekaView {

    @Id
    @Column(name = "produkt_id", updatable = false, nullable = false)
    private Integer produktId;

    @Id
    @Column(name = "mesec", updatable = false, nullable = false)
    private Integer mesec;

    @Id
    @Column(name = "godina", updatable = false, nullable = false)
    private Integer godina;

    private Double potroshuvacka;

}




