package javaweb.battleShipsExam.service;

import javaweb.battleShipsExam.model.entity.UserEntity;
import javaweb.battleShipsExam.model.service.UserServiceModel;
import javaweb.battleShipsExam.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    UserEntity findById(Long id);

    List<UserViewModel> findAll();
}
