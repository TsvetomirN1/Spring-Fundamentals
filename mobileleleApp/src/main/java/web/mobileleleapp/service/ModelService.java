package web.mobileleleapp.service;

import web.mobileleleapp.models.entities.ModelEntity;

public interface ModelService {

    void initializeModels();

    ModelEntity findById(Long id);

}
