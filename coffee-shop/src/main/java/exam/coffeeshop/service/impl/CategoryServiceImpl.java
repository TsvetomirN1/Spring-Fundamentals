package exam.coffeeshop.service.impl;

import exam.coffeeshop.model.entity.CategoryEntity;
import exam.coffeeshop.model.entity.CategoryEnum;
import exam.coffeeshop.repository.CategoryRepository;
import exam.coffeeshop.service.CategoryService;
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
                    switch (categoryEnum) {
                        case Cake:
                            category.setNeededTime(10);
                            break;
                        case Drink:
                            category.setNeededTime(1);
                            break;
                        case Coffee:
                            category.setNeededTime(2);
                            break;
                        case Other:
                            category.setNeededTime(5);
                            break;
                    }

                    categoryRepository.save(category);
                });
    }

    @Override
    public CategoryEntity findByCategoryEnum(CategoryEnum categoryEnum) {


        return categoryRepository.findByName(categoryEnum).orElse(null);
    }
}
