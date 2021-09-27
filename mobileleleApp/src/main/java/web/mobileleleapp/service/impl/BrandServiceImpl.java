package web.mobileleleapp.service.impl;

import org.springframework.stereotype.Service;
import web.mobileleleapp.models.entities.Brand;
import web.mobileleleapp.repositories.BrandRepository;
import web.mobileleleapp.service.BrandService;


@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void initializeBrand() {
        if (brandRepository.count() == 0) {
            Brand volvo = new Brand();
            volvo.setName("Volvo");

            brandRepository.save(volvo);
        }

    }

    @Override
    public Brand findByName(String name) {

        return brandRepository
                .findByName(name)
                .orElseThrow(() ->
                        new IllegalArgumentException("No brand with name " + name + " found!"));

    }
}

