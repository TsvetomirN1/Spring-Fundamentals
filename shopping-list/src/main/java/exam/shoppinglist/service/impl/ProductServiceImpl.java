package exam.shoppinglist.service.impl;

import exam.shoppinglist.model.entity.CategoryEnum;
import exam.shoppinglist.model.entity.ProductEntity;
import exam.shoppinglist.model.service.ProductServiceModel;
import exam.shoppinglist.model.view.ProductViewModel;
import exam.shoppinglist.repository.ProductRepository;
import exam.shoppinglist.service.CategoryService;
import exam.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ModelMapper modelMapper, CategoryService categoryService, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {

        ProductEntity product = modelMapper.map(productServiceModel, ProductEntity.class);

        product.setCategory(categoryService.findByCategoryEnum(productServiceModel.getCategoryEnum()));

        productRepository.save(product);

    }

    @Override
    public List<ProductServiceModel> findByCategory(CategoryEnum category) {

        return productRepository
                .findAllByCategoryName(category)
                .stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductServiceModel.class))
                .collect(Collectors.toList());
    }


    @Override
    public void buyProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAllProducts() {
        productRepository.deleteAll();
    }

    @Override
    public boolean checkExistingName(String name) {
        return productRepository.findByName(name).orElse(null) != null;
    }

    @Override
    public List<ProductViewModel> findAllProducts() {

        List<ProductEntity> productEntityList = productRepository.findAll();
        return productEntityList.stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal totalSum() {

        return this.findAllProducts()
                .stream()
                .map(ProductViewModel::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

    }
}
