package web.mobileleleapp.models.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

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
    private Brand brand;
    @OneToMany(mappedBy = "model")
    private List<Offer> offers;

    public Model() {
    }


    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Model setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Model setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public Model setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public Model setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public Model setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }


    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @PrePersist
    public void beforeCreate() {
        setCreated(Instant.now());
    }

}
