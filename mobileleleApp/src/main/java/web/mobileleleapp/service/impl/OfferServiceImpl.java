package web.mobileleleapp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import web.mobileleleapp.models.entities.OfferEntity;
import web.mobileleleapp.models.entities.enums.Engine;
import web.mobileleleapp.models.entities.enums.Transmission;
import web.mobileleleapp.models.view.OfferSummaryView;
import web.mobileleleapp.repositories.ModelRepository;
import web.mobileleleapp.repositories.OfferRepository;
import web.mobileleleapp.repositories.UserRepository;
import web.mobileleleapp.service.OfferService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ModelRepository modelRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void initializeOffers() {

        if (offerRepository.count() == 0) {
            OfferEntity offer1 = new OfferEntity();

            offer1.setModel(modelRepository.findById(1L).orElse(null));
            offer1.setEngine(Engine.DIESEL);
            offer1.setTransmission(Transmission.MANUAL);
            offer1.setMileage(140300);
            offer1.setPrice(6900);
            offer1.setYear(2009);
            offer1.setDescription("Used, but well serviced and in good condition.");
            offer1.setSeller(userRepository.findByUsername("pesho")
                    .orElse(null));// or currentUser.getUserName()
            offer1.setImageUrl(
                    "https://image.shutterstock.com/image-photo/gerardmer-france-november-11-2016-600w-1347874922.jpg");

            OfferEntity offer2 = new OfferEntity();

            offer2.setModel(modelRepository.findById(1L).orElse(null));
            offer2.setEngine(Engine.GASOLINE);
            offer2.setTransmission(Transmission.AUTOMATIC);
            offer2.setMileage(209000);
            offer2.setPrice(10500);
            offer2.setYear(2010);
            offer2.setDescription("After full maintenance, full insurance, new tires and well preserved");
                   offer2.setSeller(userRepository.findByUsername("admin")
                            .orElse(null)); // or currentUser.getUserName()
                    offer2 .setImageUrl(
                            "https://image.shutterstock.com/image-photo/volvo-v50-motorshow-bologna-2005-600w-1450606.jpg");

            offerRepository.saveAll(List.of(offer1, offer2));
        }
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
