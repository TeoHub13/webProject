package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "patiki")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patiki extends Produkt {



    @Column(name = "velicina_patiki")
    private    Integer velicina;


}
