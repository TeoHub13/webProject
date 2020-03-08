package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vraboten {

    @Id
            @Column(name = "vraboten_id")
    private Integer vrabotenId;
    @Column(name = "ime_vraboten")
    private String imeVraboten;
    @Column(name = "prezime_vraboten")
    private String prezimeVraboten;
    @Column(name = "denvrabotuvanje")
    private Date denVrabotuvanje;

    @ManyToOne
    @JoinColumn(name = "magacin_id")
    private Magacin magacin;


}
