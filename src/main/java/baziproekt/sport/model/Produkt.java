package baziproekt.sport.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
//@AllArgsConstructor
@Data
@Entity(name = "produkt")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "produkt")
public class Produkt {

    @Id
    @Column(name = "produkt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer produktId;

    @Column(name = "brend")
    String brend;

    @Column(name = "model")
    String model;

    @ManyToOne
    @JoinColumn(name="proizvoditel_id")
    private Proizvoditel proizvoditel;

    @Column(name = "pol")
    String pol;

    @Column(name = "cena")
    Integer cena;

    @Column(name="popust")
    BigDecimal popust;

    @Column(name = "slika")
    String slika;

}
