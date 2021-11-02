package exam.shoppinglist.service;


import exam.shoppinglist.model.entity.CategoryEnum;
import exam.shoppinglist.model.service.ProductServiceModel;
import exam.shoppinglist.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {


    void addProduct(ProductServiceModel productServiceModel);

    List<ProductServiceModel> findByCategory(CategoryEnum category);

    void buyProduct(Long id);

    void buyAllProducts();

    boolean checkExistingName(String name);

    List<ProductViewModel> findAllProducts();

    BigDecimal totalSum();
}
