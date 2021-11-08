package web.mobileleleapp.service.impl;

import web.mobileleleapp.model.entity.BrandEntity;
import web.mobileleleapp.model.entity.ModelEntity;
import web.mobileleleapp.model.view.BrandViewModel;
import web.mobileleleapp.model.view.ModelViewModel;
import web.mobileleleapp.repository.BrandRepository;
import web.mobileleleapp.service.BrandService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeBrand() {
        if (brandRepository.count() == 0) {
            BrandEntity volvo = new BrandEntity();
            volvo.setName("VOLVO");

            brandRepository.save(volvo);
        }
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(brandEntity -> {
                    BrandViewModel brandViewModel = new BrandViewModel().
                        setName(brandEntity.getName());

                    brandViewModel.setModels(
                        brandEntity.
                            getModels().
                            stream().
                            map(this::map).
                            collect(Collectors.toList()));
                    return brandViewModel;
                })
                .collect(Collectors.toList());
    }

    private ModelViewModel map(ModelEntity modelEntity) {
        return modelMapper.map(modelEntity, ModelViewModel.class);
    }
}
