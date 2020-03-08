package baziproekt.sport.service;

import baziproekt.sport.model.Obleka;

import java.util.List;

public interface OblekaService {
    List<Obleka> getAllClothes();

    Obleka getClothesById(Integer id);

    Obleka createAndSaveClothes(Integer id, String pol, String brend, String model, Integer cena, Integer velicina, String materijal);

    Obleka deleteById(Integer id);
}
