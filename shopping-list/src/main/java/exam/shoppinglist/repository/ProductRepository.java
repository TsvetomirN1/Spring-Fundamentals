package exam.shoppinglist.repository;

import exam.shoppinglist.model.entity.CategoryEnum;
import exam.shoppinglist.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p WHERE p.category.name = :name")
    List<ProductEntity> findAllByCategoryName(CategoryEnum name);

    Optional<ProductEntity> findByName(String name);


}
