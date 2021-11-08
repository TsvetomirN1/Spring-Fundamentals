package web.mobileleleapp.service.impl;

import web.mobileleleapp.model.entity.BrandEntity;
import web.mobileleleapp.model.entity.ModelEntity;
import web.mobileleleapp.model.entity.enums.CategoryEnum;
import web.mobileleleapp.repository.BrandRepository;
import web.mobileleleapp.repository.ModelRepository;
import web.mobileleleapp.service.ModelService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void initializeModels() {
        if (modelRepository.count() == 0) {
            BrandEntity volvo = brandRepository.findByName("VOLVO")
                    .orElseThrow(IllegalArgumentException::new);

            ModelEntity v60 = new ModelEntity();
            v60
                    .setName("V60")
                    .setCategory(CategoryEnum.CAR)
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/2018_Volvo_V60_Inscription_PRO_D4_Automatic_2.0.jpg/1920px-2018_Volvo_V60_Inscription_PRO_D4_Automatic_2.0.jpg")
                    .setStartYear(2010)
                    .setBrand(volvo);

            ModelEntity xc60 = new ModelEntity();
            xc60
                    .setName("XC60")
                    .setCategory(CategoryEnum.TRUCK)
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/2018_Volvo_XC60_R-Design_D5_P-Pulse_2.0_Front.jpg/1920px-2018_Volvo_XC60_R-Design_D5_P-Pulse_2.0_Front.jpg")
                    .setStartYear(2008)
                    .setEndYear(2021)
                    .setBrand(volvo);

            modelRepository.saveAll(List.of(v60, xc60));
        }
    }
}
