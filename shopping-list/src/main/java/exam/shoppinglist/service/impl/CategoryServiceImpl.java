package exam.shoppinglist.service.impl;


import exam.shoppinglist.model.entity.CategoryEntity;
import exam.shoppinglist.model.entity.CategoryEnum;
import exam.shoppinglist.repository.CategoryRepository;
import exam.shoppinglist.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryEnum.values())
                .forEach(categoryEnum -> {
                    CategoryEntity category = new CategoryEntity();
                    category.setName(categoryEnum);
                    categoryRepository.save(category);
                });
    }

    @Override
    public CategoryEntity findByCategoryEnum(CategoryEnum categoryEnum) {

        return categoryRepository.findByName(categoryEnum).orElse(null);
    }
}
