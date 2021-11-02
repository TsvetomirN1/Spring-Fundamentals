package javaweb.battleShipsExam.repository;

import javaweb.battleShipsExam.model.entity.ShipEntity;
import javaweb.battleShipsExam.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity,Long> {

    List<ShipEntity> findAll();

    List<ShipEntity> findAllByUser(UserEntity user);

    List<ShipEntity> findAllByUserNot(UserEntity user);

    ShipEntity findByName(String name);


}
