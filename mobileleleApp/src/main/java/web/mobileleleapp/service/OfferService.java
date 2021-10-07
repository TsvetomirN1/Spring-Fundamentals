package web.mobileleleapp.service;


import web.mobileleleapp.models.view.OfferSummaryView;

import java.util.List;


public interface OfferService {

    void initializeOffers();

    List<OfferSummaryView> getAllOffers();
}
