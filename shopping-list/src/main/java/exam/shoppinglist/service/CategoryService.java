package exam.shoppinglist.service;


import  exam.shoppinglist.model.entity.CategoryEntity;
import exam.shoppinglist.model.entity.CategoryEnum;

public interface CategoryService {

    void initCategories();

    CategoryEntity findByCategoryEnum(CategoryEnum categoryEnum);
}
