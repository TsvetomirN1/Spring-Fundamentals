package exam.shoppinglist.web;

import exam.shoppinglist.model.binding.ProductAddBindingModel;
import exam.shoppinglist.model.service.ProductServiceModel;
import exam.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("productAddBindingModel")) {
            model.addAttribute("productAddBindingModel", new ProductAddBindingModel())
                    .addAttribute("existingName", false);

        }
        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        boolean checkExistingName = productService.checkExistingName(productAddBindingModel.getName());
        if (bindingResult.hasErrors() || checkExistingName) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);

            if (checkExistingName) {
                redirectAttributes.addFlashAttribute("existingName", true);
            }

            return "redirect:add";
        }

        productService.addProduct(modelMapper
                .map(productAddBindingModel, ProductServiceModel.class));
        return "redirect:/";
    }


    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id) {
        productService.buyProduct(id);
        return "redirect:/";
    }

    @GetMapping("/buy/all")
    public String buyAll() {
        productService.buyAllProducts();
        return "redirect:/";
    }


    @ModelAttribute
    public ProductAddBindingModel productAddBindingModel() {
        return new ProductAddBindingModel();
    }
}

