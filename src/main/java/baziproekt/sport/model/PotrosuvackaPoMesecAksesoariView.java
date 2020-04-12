package baziproekt.sport.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;

@Entity(name = "potrosuvacka_po_mesec_aksesoari")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Immutable
@IdClass(PotrosuvackaPoMesecOblekaCompositeKey.class)
public class PotrosuvackaPoMesecAksesoariView {

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
