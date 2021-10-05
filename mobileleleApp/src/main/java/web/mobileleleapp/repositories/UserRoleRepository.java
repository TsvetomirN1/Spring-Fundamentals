package web.mobileleleapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.mobileleleapp.models.entities.enums.Role;
import web.mobileleleapp.models.entities.UserRoleEntity;

import java.util.Optional;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {


    UserRoleEntity findByRole(Role role);

}
