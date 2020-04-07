package baziproekt.sport.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClothesBody {
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

}
