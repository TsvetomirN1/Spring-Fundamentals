package web.mobileleleapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.mobileleleapp.models.entities.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {


}
