package web.mobileleleapp.web;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.mobileleleapp.models.binding.OfferUpdateBindingModel;
import web.mobileleleapp.models.entities.enums.Engine;
import web.mobileleleapp.models.entities.enums.Transmission;
import web.mobileleleapp.models.service.OfferUpdateServiceModel;
import web.mobileleleapp.models.view.OfferDetailsView;
import web.mobileleleapp.service.OfferService;

import javax.validation.Valid;

@Controller
public class OffersController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;

    public OffersController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    // GET
    @GetMapping("/offers/all")
    public String allOffers(Model model) {
        model.addAttribute("offers",
                offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/offers/{id}/details")
    public String showOffer(
            @PathVariable Long id, Model model){
        model.addAttribute("offer", this.offerService.findById(id));
        return "details";
    }

    // DELETE
    @DeleteMapping("/offers/{id}")
    public String deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }

    // UPDATE

    @GetMapping("/offers/{id}/edit")
    public String editOffer(@PathVariable Long id, Model model) {

        OfferDetailsView offerDetailsView = offerService.findById(id);
        OfferUpdateBindingModel offerModel = modelMapper.map(
                offerDetailsView,
                OfferUpdateBindingModel.class
        );
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        model.addAttribute("offerModel", offerModel);
        return "update";
    }

    @GetMapping("/offers/{id}/edit/errors")
    public String editOfferErrors(@PathVariable Long id, Model model) {
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        return "update";
    }

    @PatchMapping("/offers/{id}/edit")
    public String editOffer(
            @PathVariable Long id,
            @Valid OfferUpdateBindingModel offerModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);

            return "redirect:/offers/" + id + "/edit/errors";
        }

        OfferUpdateServiceModel serviceModel = modelMapper.map(offerModel,
                OfferUpdateServiceModel.class);
        serviceModel.setId(id);

        offerService.updateOffer(serviceModel);

        return "redirect:/offers/" + id + "/details";
    }
}
