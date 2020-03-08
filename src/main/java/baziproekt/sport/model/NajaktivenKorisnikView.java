package baziproekt.sport.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "najaktiven_korisnik")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NajaktivenKorisnikView {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "korisnik_id", updatable = false, nullable = false)
    Integer korisnikId;
    @Column(name="prezime_korisnik")
    String prezime;
    @Column(name = "korisnicko_ime")
    String korisnickoIme;


}
