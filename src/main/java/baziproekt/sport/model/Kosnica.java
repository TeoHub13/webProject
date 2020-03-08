package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Kosnica {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer kosnicaId;

    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;

    public Kosnica(Korisnik korisnik, Integer koId) {
        this.korisnik=korisnik;
        this.kosnicaId=koId;
    }
}
