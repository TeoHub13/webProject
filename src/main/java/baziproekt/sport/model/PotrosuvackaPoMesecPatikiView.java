package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;

@Entity(name = "potrosuvacka_po_mesec_patiki")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Immutable
public class PotrosuvackaPoMesecPatikiView {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "produkt_id", updatable = false, nullable = false)
    private Integer produktId;

    private Integer mesec;
    private Double potroshuvacka;



}
