package web.mobileleleapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.mobileleleapp.models.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {


}
