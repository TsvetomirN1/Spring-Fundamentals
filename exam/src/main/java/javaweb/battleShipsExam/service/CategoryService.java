package javaweb.battleShipsExam.service;


import javaweb.battleShipsExam.model.entity.CategoryEntity;
import javaweb.battleShipsExam.model.entity.CategoryEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByCategoryEnum(CategoryEnum categoryEnum);
}
