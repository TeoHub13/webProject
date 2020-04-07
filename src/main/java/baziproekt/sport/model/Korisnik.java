package baziproekt.sport.model;

import baziproekt.sport.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "korisnik")
@Table(name = "korisnik")
@NoArgsConstructor
//@AllArgsConstructor
@Data
public class Korisnik {

    public Korisnik(Integer korisnikId, String ime, String prezime, String mail, String korisnickoIme, String lozinka) {
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.mail = mail;
        this.korisnikId = korisnikId;
        this.lozinka = lozinka;
    }

    public Korisnik(String korisnickoIme, String lozinka) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer korisnikId;
    @Column(name = "ime_korisnik")
    String ime;
    @Column(name = "prezime_korisnik")
    String prezime;
    @Column(name = "email_korisnik")
    String mail;
    @Column(name = "korisnicko_ime")
    String korisnickoIme;
    @Column(name = "lozinka")
    String lozinka;
    @Column(name = "uloga")
    @Enumerated(EnumType.STRING)
    Role uloga;


//        @ManyToMany(fetch = FetchType.LAZY,
//                cascade = {
//                        CascadeType.PERSIST,
//                        CascadeType.MERGE
//                },
//                mappedBy = "korisnici")

//        @ManyToMany
//        @JoinTable(
//                name = "listaposakuvani",
//                joinColumns = @JoinColumn(name = "korisnik_id"),
//                inverseJoinColumns = @JoinColumn(name = "produkt_id"))
//                List<Produkt>produkti;
//


}
