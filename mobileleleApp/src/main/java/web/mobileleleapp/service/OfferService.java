package web.mobileleleapp.service;

import org.springframework.stereotype.Service;
import web.mobileleleapp.models.view.OfferSummaryView;

import java.util.List;


public interface OfferService {

    void initializeOffers();

    List<OfferSummaryView> getAllOffers();
}
