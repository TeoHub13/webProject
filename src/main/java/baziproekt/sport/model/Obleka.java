package baziproekt.sport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "obleka")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Obleka extends Produkt{


        @Column(name = "materijal_obleka")
        private  String materijal;
        @Column(name = "velicina_obleka")
        private  char velicina;


}
