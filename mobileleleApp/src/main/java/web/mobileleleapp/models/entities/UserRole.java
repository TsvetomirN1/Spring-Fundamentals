package web.mobileleleapp.models.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role name;

    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }
}


