package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity(name = "magacin")
@Table(name = "magacin")
public class Magacin {

    @Id
    @Column(name="magacin_id")
    private Integer magacinId;
    @Column(name = "ime_magacin")
    private String imeMagacin;
    private String lokacija;

    public Magacin(Integer magacinId, String imeMagacin, String lokacija) {
        this.magacinId = magacinId;
        this.imeMagacin = imeMagacin;
        this.lokacija = lokacija;
    }
//
//    @ManyToMany(mappedBy = "magacini")
//    List<Produkt>produkti;
}
