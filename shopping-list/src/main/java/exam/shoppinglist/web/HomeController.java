package exam.shoppinglist.web;


import exam.shoppinglist.current.CurrentUser;
import exam.shoppinglist.model.entity.CategoryEnum;
import exam.shoppinglist.service.CategoryService;
import exam.shoppinglist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ProductService productService;
    private final CategoryService categoryService;

    public HomeController(CurrentUser currentUser, ProductService productService, CategoryService categoryService) {
        this.currentUser = currentUser;
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @GetMapping()
    public String home(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }
        //ToDo model.addAttributes()
        model.addAttribute("productViewModel", productService.findAllProducts());
        model.addAttribute("totalSum", productService.totalSum());

        model.addAttribute("drink", productService.findByCategory(CategoryEnum.Drink));
        model.addAttribute("food", productService.findByCategory(CategoryEnum.Food));
        model.addAttribute("other", productService.findByCategory(CategoryEnum.Other));
        model.addAttribute("households", productService.findByCategory(CategoryEnum.Household));

        return "home";
    }
}





