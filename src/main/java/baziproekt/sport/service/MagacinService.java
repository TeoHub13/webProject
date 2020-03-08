package baziproekt.sport.service;

import baziproekt.sport.model.Magacin;

import java.util.List;

public interface MagacinService {
    List<Magacin> getAllWareHouseFromBase();

    Magacin getWareHouseWithId(Integer id);

    Magacin createAndSaveWareHouse(Integer id, String name, String location);

    Magacin deleteWareHouseById(Integer id);
}
