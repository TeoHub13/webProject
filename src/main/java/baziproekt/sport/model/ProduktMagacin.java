package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "produktmagacin")
@Table(name="produktmagacin")
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(ProduktMagacinCompositeKey.class)
public class ProduktMagacin {

    @Id
    @ManyToOne
    @JoinColumn(name = "magacin_id")
    private Magacin magacin;

    @Id
    @ManyToOne
    @JoinColumn(name = "produkt_id")
    private Produkt produkt;

    private Integer kolicina;
}
