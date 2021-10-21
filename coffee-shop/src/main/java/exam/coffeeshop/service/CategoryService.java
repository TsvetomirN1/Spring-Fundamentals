package exam.coffeeshop.service;

import exam.coffeeshop.model.entity.CategoryEntity;
import exam.coffeeshop.model.entity.CategoryEnum;

public interface CategoryService {

    void initCategories();

    CategoryEntity findByCategoryEnum(CategoryEnum categoryEnum);
}
