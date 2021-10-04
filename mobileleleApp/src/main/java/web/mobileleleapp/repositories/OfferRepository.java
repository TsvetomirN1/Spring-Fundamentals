package web.mobileleleapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.mobileleleapp.models.entities.OfferEntity;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {


}
