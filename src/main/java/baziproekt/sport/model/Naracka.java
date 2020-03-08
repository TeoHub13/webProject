package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "naracka")
@Table(name = "naracka")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Naracka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "naracka_id")
    private Integer narackaId;

    private Integer suma;

    @Column(name = "datum_naracka")
    private Timestamp datum;

    @OneToOne
    @JoinColumn(name="kosnica_id")
    private Kosnica kosnica;

    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;

}
