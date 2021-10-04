package web.mobileleleapp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import web.mobileleleapp.models.entities.OfferEntity;
import web.mobileleleapp.models.view.OfferSummaryView;
import web.mobileleleapp.repositories.OfferRepository;
import web.mobileleleapp.service.OfferService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeOffers() {
        // TODO
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return offerRepository.
                findAll().
                stream().
                map(this::map).
                collect(Collectors.toList());
    }

    private OfferSummaryView map(OfferEntity offerEntity) {
        OfferSummaryView summaryView = modelMapper
                .map(offerEntity, OfferSummaryView.class);

        summaryView.setModel(offerEntity.getModel().getName());

        return summaryView;
    }
}
