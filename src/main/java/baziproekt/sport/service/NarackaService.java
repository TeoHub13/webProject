package baziproekt.sport.service;

import baziproekt.sport.model.Kosnica;
import baziproekt.sport.model.Naracka;
import baziproekt.sport.model.NarackaBody;
import baziproekt.sport.model.PotrosuvackaPoMesecView;

import java.util.List;

public interface NarackaService {
    List<Naracka> getAllNaracki(String token);

    Naracka putNewOrder(String token, Integer cartId, NarackaBody body);

    List<PotrosuvackaPoMesecView> getPotrosuvacka();
}
