package web.mobileleleapp.service;


import web.mobileleleapp.models.service.OfferUpdateServiceModel;
import web.mobileleleapp.models.view.OfferDetailsView;
import web.mobileleleapp.models.view.OfferSummaryView;

import java.util.List;


public interface OfferService {

    void initializeOffers();


    List<OfferSummaryView> getAllOffers();

    OfferDetailsView findById(Long id);

    void deleteOffer(Long id);

    void updateOffer(OfferUpdateServiceModel offerModel);
}
