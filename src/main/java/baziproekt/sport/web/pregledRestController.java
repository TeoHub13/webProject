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

     @GetMapping("/users/pregled")
    public List<PregledDTO> getAllRatingbyId(@RequestHeader (name="Authorization") String token) {

         List<Pregled> allRatingById = pregledServ.getAllRatingById(token);
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


     @DeleteMapping("users/del/{prId}")
    public  void deleteRecord(@RequestHeader (name = "Authorization") String token,@PathVariable Integer prId)
     {
         pregledServ.deletePregled(token,prId);
     }
     @PatchMapping("users/{id}/{produktId}/pregled")
    public Pregled updateRating(@PathVariable Integer id,@PathVariable Integer prId,@RequestParam Integer rejting)
     {
         return pregledServ.UpdateRating(id,prId,rejting);
     }

     @PostMapping("users/{prId}")
     public Pregled addRating(@RequestHeader (name = "Authorization") String token,@PathVariable Integer prId,@RequestBody RejtingBodyClass rejting)
     {
         return pregledServ.addRating(token,prId,rejting.getRejting());
     }

//    @PostMapping("/pregledi")
//    public  Pregled addNewRating(@RequestParam Integer id,@RequestParam Integer pId, @RequestParam Integer rejting)
//    {
//        return pregledServ.postNewRating(id,pId,rejting);
//    }

}
