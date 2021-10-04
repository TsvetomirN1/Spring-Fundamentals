package web.mobileleleapp.service;


import web.mobileleleapp.models.entities.BrandEntity;

public interface BrandService {

    void initializeBrand();

    BrandEntity findByName(String name);
}
