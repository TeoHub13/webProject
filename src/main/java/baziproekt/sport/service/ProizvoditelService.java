package baziproekt.sport.service;

import baziproekt.sport.model.Proizvoditel;

import java.util.List;

public interface ProizvoditelService  {
    List<Proizvoditel> getAllManufacturers();

    Proizvoditel getManufacturerById(Integer id);

    Proizvoditel createAndSaveManuf(Integer id, String name);

    Proizvoditel deleteManufById(Integer id);
}
