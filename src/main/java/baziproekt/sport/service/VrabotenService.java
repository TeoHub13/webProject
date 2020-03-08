package baziproekt.sport.service;

import baziproekt.sport.model.Magacin;
import baziproekt.sport.model.Vraboten;

import java.util.Date;
import java.util.List;

public interface VrabotenService {
    List<Vraboten> getAllEmployeesFromBase();

    Vraboten getEmployeeById(Integer id);

    Vraboten createAndSaveEmployee(Integer id, String name, String prezime, Date denVrabotuvanje, Magacin magacin);

    Vraboten deleteEmployeeById(Integer id);
}
