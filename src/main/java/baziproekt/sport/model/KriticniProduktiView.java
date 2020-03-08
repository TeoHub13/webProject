package baziproekt.sport.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "kriticni_produkti")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KriticniProduktiView {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "produkt_id", updatable = false, nullable = false)
    private Integer produktId;

    @Column(name = "prosek_potrosuvacka")
    private Double prosekPotrosuvacka;

    private Integer dostapnost;

}
