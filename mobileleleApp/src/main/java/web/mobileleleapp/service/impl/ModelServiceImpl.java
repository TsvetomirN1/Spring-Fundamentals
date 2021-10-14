package web.mobileleleapp.service.impl;

import org.springframework.stereotype.Service;
import web.mobileleleapp.models.entities.BrandEntity;
import web.mobileleleapp.models.entities.enums.Category;
import web.mobileleleapp.models.entities.ModelEntity;
import web.mobileleleapp.repositories.ModelRepository;
import web.mobileleleapp.service.BrandService;
import web.mobileleleapp.service.ModelService;

import java.util.List;


@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandService brandService;

    public ModelServiceImpl(ModelRepository modelRepository, BrandService brandService) {
        this.modelRepository = modelRepository;
        this.brandService = brandService;
    }


    @Override
    public void initializeModels() {

        BrandEntity volvo = brandService.findByName("Volvo");

        ModelEntity v50 = new ModelEntity();
        v50
                .setName("v50")
                .setCategory(Category.Car)
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/2008_Volvo_V50_%28MY09%29_LE_station_wagon_%282015-07-15%29_01.jpg/1280px-2008_Volvo_V50_%28MY09%29_LE_station_wagon_%282015-07-15%29_01.jpg")
                .setStartYear(2003)
                .setBrand(volvo);

        ModelEntity s60 = new ModelEntity();
        s60
                .setName("s60")
                .setCategory(Category.Car)
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/2019_Volvo_S60_R-Design_Edition_T5_Automatic_2.0.jpg/1920px-2019_Volvo_S60_R-Design_Edition_T5_Automatic_2.0.jpg")
                .setStartYear(2000)
                .setEndYear(2020)
                .setBrand(volvo);

        modelRepository.saveAll(List.of(v50, s60));
    }

    @Override
    public ModelEntity findById(Long id) {
        return modelRepository.findById(id).orElse(null);
    }

}

