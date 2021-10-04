package web.mobileleleapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.mobileleleapp.models.entities.ModelEntity;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

    ModelEntity findByName(String model);
}
