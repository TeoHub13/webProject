package baziproekt.sport.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "najprodavan_produkt")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NajprodavanProduktView {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "produkt_id", updatable = false, nullable = false)
    private Integer produktId;

    @Column(name = "brend")
    String brend;

    @Column(name = "model")
    String model;

    @Column(name = "pol")
    String pol;

    @Column(name = "cena")
    Integer cena;




}
