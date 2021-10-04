package web.mobileleleapp.models.entities;

import web.mobileleleapp.models.entities.enums.Category;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Enumerated(STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Integer startYear;

    private Integer endYear;

    @ManyToOne
    private BrandEntity brand;

//    @OneToMany(mappedBy = "model")
//    private List<OfferEntity> offers;

    public ModelEntity() {
    }


    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ModelEntity setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelEntity setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }


//    public List<OfferEntity> getOffers() {
//        return offers;
//    }
//
//    public void setOffers(List<OfferEntity> offers) {
//        this.offers = offers;
//    }


}
