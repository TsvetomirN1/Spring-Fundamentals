package web.mobileleleapp.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import web.mobileleleapp.service.BrandService;
import web.mobileleleapp.service.ModelService;
import web.mobileleleapp.service.UserService;



@Component
public class DBInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final UserService userService;

    public DBInit(BrandService brandService, ModelService modelService, UserService userService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        brandService.initializeBrand();
        modelService.initializeModels();
        userService.initializeUsers();
    }
}
