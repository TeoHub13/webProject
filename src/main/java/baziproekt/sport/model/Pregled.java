package baziproekt.sport.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pregled")
@IdClass(pregledCompositeKey.class)
public class Pregled {

    @Id
    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;

    @Id
    @ManyToOne
    @JoinColumn(name = "produkt_id")
    private Produkt produkt;

    private Integer rejting;
}
