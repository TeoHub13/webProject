package baziproekt.sport.model;



import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "potrosuvacka_po_mesec_obleka")
public class PotrosuvackaPoMesecOblekaView {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "produkt_id", updatable = false, nullable = false)
        private Integer produktId;

        private Integer mesec;
        private Double potroshuvacka;



    }




