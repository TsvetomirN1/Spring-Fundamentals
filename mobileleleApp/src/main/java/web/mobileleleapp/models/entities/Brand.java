package web.mobileleleapp.models.entities;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    private String name;
    private Instant created;
    private Instant modified;
//    private Set<Model> models;

    public Brand() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

//    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
//    public Set<Model> getModels() {
//        return models;
//    }
//
//    public void setModels(Set<Model> models) {
//        this.models = models;
//    }
}
