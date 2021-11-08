package web.mobileleleapp.service;

import web.mobileleleapp.model.binding.OfferAddBindModel;
import web.mobileleleapp.model.service.OfferAddServiceModel;
import web.mobileleleapp.model.service.OfferUpdateServiceModel;
import web.mobileleleapp.model.view.OfferDetailsView;
import web.mobileleleapp.model.view.OfferSummaryView;
import java.util.List;

public interface OfferService {
  void initializeOffers();

  List<OfferSummaryView> getAllOffers();

  OfferDetailsView findById(Long id);

  void deleteOffer(Long id);

  void updateOffer(OfferUpdateServiceModel offerModel);

  OfferAddServiceModel addOffer(OfferAddBindModel offerAddBindModel, String ownerId);
}
