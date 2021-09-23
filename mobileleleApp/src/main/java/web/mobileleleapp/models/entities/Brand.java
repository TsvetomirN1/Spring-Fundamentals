package web.mobileleleapp.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    private String name;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Model> models;


    public Brand() {
    }

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }

    public List<Model> getModels() {
        return models;
    }

    public Brand setModels(
            List<Model> models) {
        this.models = models;
        return this;
    }
}
