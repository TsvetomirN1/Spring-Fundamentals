package web.mobileleleapp.service;


import web.mobileleleapp.model.view.BrandViewModel;
import java.util.List;

public interface BrandService {

    void initializeBrand();

    List<BrandViewModel> getAllBrands();
}
