package baziproekt.sport.web;

import baziproekt.sport.model.Pregled;
import baziproekt.sport.model.Produkt;
import baziproekt.sport.model.RejtingBodyClass;
import baziproekt.sport.model.pregledCompositeKey;
import baziproekt.sport.service.pregledService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class pregledRestController {
    private  final pregledService pregledServ;
    public pregledRestController(pregledService pregledServ)
    {
        this.pregledServ=pregledServ;
    }

    @Data
    @AllArgsConstructor
    class PregledDTO {
        private Pregled pregled;
        private Double averageRating;
    }

     @GetMapping("/users/{id}/pregled")
    public List<PregledDTO> getAllRatingbyId(@PathVariable Integer id) {

         List<Pregled> allRatingById = pregledServ.getAllRatingById(id);
         Map<Integer, OptionalDouble> prodIdToRejting = allRatingById.stream().map(Pregled::getProdukt)
                 .collect(Collectors.toMap(Produkt::getProduktId, produkt -> pregledServ.getAverageOfProdId(produkt.getProduktId())));
         List<PregledDTO> pregledDTOs = allRatingById.stream().map(pregled -> new PregledDTO(pregled, prodIdToRejting.get(pregled.getProdukt().getProduktId()).orElseGet(() -> 0))).collect(Collectors.toList());
         return pregledDTOs;
     }
     @GetMapping("/users/{id}/pregled/average")
    public OptionalDouble getAverageRaitingOfId(@PathVariable Integer id)
     {
         return  pregledServ.getAverageOfId(id);
     }

     @GetMapping("/pregled/{id}")
     public OptionalDouble getAverageRaitingOfProduct(@PathVariable Integer id)
     {
         return pregledServ.getAverageOfProdId(id);
     }


     @DeleteMapping("users/{id}/{prId}")
    public  void deleteRecord(@PathVariable Integer id,@PathVariable Integer prId)
     {
         pregledServ.deletePregled(id,prId);
     }
     @PatchMapping("users/{id}/{produktId}/pregled")
    public Pregled updateRating(@PathVariable Integer id,@PathVariable Integer prId,@RequestParam Integer rejting)
     {
         return pregledServ.UpdateRating(id,prId,rejting);
     }

     @PostMapping("users/{id}/{prId}")
     public Pregled addRating(@PathVariable Integer id,@PathVariable Integer prId,@RequestBody RejtingBodyClass rejting)
     {
         return pregledServ.addRating(id,prId,rejting.getRejting());
     }

//    @PostMapping("/pregledi")
//    public  Pregled addNewRating(@RequestParam Integer id,@RequestParam Integer pId, @RequestParam Integer rejting)
//    {
//        return pregledServ.postNewRating(id,pId,rejting);
//    }

}
