package web.mobileleleapp.models.binding;


import web.mobileleleapp.models.entities.enums.Engine;
import web.mobileleleapp.models.entities.enums.Transmission;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class OfferUpdateBindingModel {

    @NotNull
    @Min(100)
    private Integer price;

    private Long id;

    @NotBlank
    private String description;

    @NotNull
    private Engine engine;

    @NotBlank
    private String imageUrl;

    @NotNull
    @PositiveOrZero
    private Integer mileage;

    @NotNull
    private Transmission transmission;

    @NotNull
    @Min(1930)
    private Integer year;


    public OfferUpdateBindingModel() {
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
