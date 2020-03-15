package baziproekt.sport.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "aksesoari")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Accessories extends Produkt {

    @Column(name = "materijal_aksesoari ")
    private  String materijal;
    @Column(name = "velicina_aksesoari")
    private  char velicina;
}
