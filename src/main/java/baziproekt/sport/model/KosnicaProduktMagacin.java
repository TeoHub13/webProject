package baziproekt.sport.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "kosnicaproduktmagacin")
@Data
@IdClass(KosnicaProduktMagacinCompositeKey.class)
public class KosnicaProduktMagacin {

    @Id
    @ManyToOne
    @JoinColumn(name = "kosnica_id")
    private Kosnica kosnica;

    @Id
    @ManyToOne
    @JoinColumn(name = "produkt_id")
    private Produkt produkt;

    @Id
    @ManyToOne
    @JoinColumn(name = "magacin_id")
    private Magacin magacin;

    private Integer kolicina;
}
