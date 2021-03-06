package baziproekt.sport.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ClothesBody implements Serializable {
    String brend;

    String model;

    Integer proizvoditelId;

    String pol;

    Integer cena;

    BigDecimal popust;

    String slika;

    Integer kolicina;

    char velicina;

    String materijal;


    Integer magacinId;

}
