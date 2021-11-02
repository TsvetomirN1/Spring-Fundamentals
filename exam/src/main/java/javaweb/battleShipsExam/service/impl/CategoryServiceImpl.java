package javaweb.battleShipsExam.service.impl;

import javaweb.battleShipsExam.model.entity.CategoryEntity;
import javaweb.battleShipsExam.model.entity.CategoryEnum;
import javaweb.battleShipsExam.repository.CategoryRepository;
import javaweb.battleShipsExam.service.CategoryService;
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
                        case BATTLE:
                            category.setName(CategoryEnum.BATTLE);
                            category.setDescription("description for Battle");
                            break;
                        case CARGO:
                            category.setName(CategoryEnum.CARGO);
                            category.setDescription("description for Cargo");
                            break;
                        case PATROL:
                            category.setName(CategoryEnum.PATROL);
                            category.setDescription("description for Patrol");
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
