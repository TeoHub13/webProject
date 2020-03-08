package baziproekt.sport.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "listaposakuvani")
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(WishlistCompositeKey.class)
public class Wishlist {

    @Id
    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;

    @Id
    @ManyToOne
    @JoinColumn(name = "produkt_id")
    private Produkt produkt;

    @Column(name = "dalipopust")
    private boolean popust;


}
