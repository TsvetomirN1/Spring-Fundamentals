package web.mobileleleapp.repository;

import web.mobileleleapp.model.entity.UserRoleEntity;
import web.mobileleleapp.model.entity.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

  UserRoleEntity findByRole(UserRoleEnum role);

}