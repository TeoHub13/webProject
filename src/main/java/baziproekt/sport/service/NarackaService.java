package baziproekt.sport.service;

import baziproekt.sport.model.Kosnica;
import baziproekt.sport.model.Naracka;
import baziproekt.sport.model.NarackaBody;
import baziproekt.sport.model.PotrosuvackaPoMesecView;

import java.util.List;

public interface NarackaService {
    List<Naracka> getAllNaracki(Integer userId);

    Naracka putNewOrder(Integer userId, Integer cartId, NarackaBody body);

    List<PotrosuvackaPoMesecView> getPotrosuvacka();
}
