package baziproekt.sport.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "potrosuvacka_po_mesec_aksesoari")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PotrosuvackaPoMesecAksesoariView {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "produkt_id", updatable = false, nullable = false)
    private Integer produktId;

    private Integer mesec;
    private Double potroshuvacka;

}
