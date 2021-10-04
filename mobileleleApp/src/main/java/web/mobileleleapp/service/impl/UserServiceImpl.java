package web.mobileleleapp.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.mobileleleapp.models.entities.UserRoleEntity;
import web.mobileleleapp.models.entities.enums.Role;
import web.mobileleleapp.models.entities.UserEntity;
import web.mobileleleapp.models.user.CurrentUser;
import web.mobileleleapp.models.service.UserLoginServiceModel;
import web.mobileleleapp.repositories.UserRepository;
import web.mobileleleapp.repositories.UserRoleRepository;
import web.mobileleleapp.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final UserRoleRepository userRoleRepository;


    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initializeUserAndRoles() {
        initializeRoles();
        initializeUsers();
    }

    private void initializeUsers() {
        if (userRepository.count() == 0) {

            UserRoleEntity adminRole = userRoleRepository.findByRole(Role.Admin);
            UserRoleEntity userRole = userRoleRepository.findByRole(Role.User);

            UserEntity admin = new UserEntity();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("test"));
            admin.setFirstName("Admin");
            admin.setLastName("Adminov");
            admin.setActive(true);

            admin.setRoles(Set.of(adminRole, userRole));
            userRepository.save(admin);

            UserEntity pesho = new UserEntity();
            pesho.setUsername("pesho");
            pesho.setPassword(passwordEncoder.encode("test"));
            pesho.setFirstName("Pesho");
            pesho.setLastName("Petrov");
            pesho.setActive(true);

            pesho.setRoles(Set.of(userRole));
            userRepository.save(pesho);
        }
    }

    private void initializeRoles() {

        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setRole(Role.Admin);

            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setRole(Role.User);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }

    @Override
    public boolean login(UserLoginServiceModel loginServiceModel) {


        Optional<UserEntity> userEntityOpt =
                userRepository.findByUsername(loginServiceModel.getUsername());

        if (userEntityOpt.isEmpty()) {
            logoutUser();
            return false;
        } else {
            boolean success = passwordEncoder.matches(
                    loginServiceModel.getRawPassword(),
                    userEntityOpt.get().getPassword());

            if (success) {
                UserEntity loggedInUser = userEntityOpt.get();
                currentUser.
                        setLoggedIn(true).
                        setUserName(loggedInUser.getUsername()).
                        setFirstName(loggedInUser.getFirstName()).
                        setLastName(loggedInUser.getLastName());

                loggedInUser.getRoles().
                        forEach(r -> currentUser.addRole(r.getRole()));
            }

            return success;
        }
    }

    @Override
    public void logoutUser() {
        currentUser.clean();

    }
}

