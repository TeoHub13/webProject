package baziproekt.sport.repository;

import baziproekt.sport.model.Produkt;
import baziproekt.sport.model.Wishlist;
import baziproekt.sport.model.WishlistCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, WishlistCompositeKey> {

    List<Wishlist> findAllByKorisnik_KorisnikId(Integer id);

    Integer deleteByKorisnik_KorisnikIdAndProdukt_ProduktId(Integer kId,Integer pId);
}
