package javaweb.battleShipsExam.repository;

import javaweb.battleShipsExam.model.entity.CategoryEntity;
import javaweb.battleShipsExam.model.entity.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    Optional<CategoryEntity> findByName(CategoryEnum name);
}
