package web.mobileleleapp.service;


import web.mobileleleapp.models.entities.Brand;

public interface BrandService {

    void initializeBrand();

    Brand findByName(String name);
}
