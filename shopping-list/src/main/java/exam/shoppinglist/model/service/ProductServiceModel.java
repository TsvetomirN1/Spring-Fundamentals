package exam.shoppinglist.model.service;


import exam.shoppinglist.model.entity.CategoryEntity;
import exam.shoppinglist.model.entity.CategoryEnum;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductServiceModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime neededBefore;
    private String description;
    private CategoryEnum categoryEnum;


    public ProductServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }
}
