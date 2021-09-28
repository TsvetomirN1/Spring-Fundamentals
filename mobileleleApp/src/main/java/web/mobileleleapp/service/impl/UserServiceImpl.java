package web.mobileleleapp.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.mobileleleapp.models.entities.User;
import web.mobileleleapp.models.security.CurrentUser;
import web.mobileleleapp.models.service.UserLoginServiceModel;
import web.mobileleleapp.repositories.UserRepository;
import web.mobileleleapp.service.UserService;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;


    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;

        this.currentUser = currentUser;
    }

    @Override
    public void initializeUsers() {

        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword((passwordEncoder.encode("1234")));
            admin.setFirstName("Master");
            admin.setLastName("Developer");
            admin.setActive(true);


            userRepository.save(admin);
        }

    }

    @Override
    public boolean login(UserLoginServiceModel loginServiceModel) {

        Optional<User> userEntity =
                userRepository.findByUsername(loginServiceModel.getUsername());

        if (userEntity.isEmpty()) {
            return false;
        } else {
            return passwordEncoder.matches(
                    loginServiceModel.getRawPassword(),
                    userEntity.get().getPassword());
        }
    }

    @Override
    public void logoutUser() {
        currentUser.setAnonymous(true);

    }
}

