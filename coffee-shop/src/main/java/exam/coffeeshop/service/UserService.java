package exam.coffeeshop.service;


import exam.coffeeshop.model.entity.UserEntity;
import exam.coffeeshop.model.service.UserServiceModel;
import exam.coffeeshop.model.view.UserViewModel;

import java.util.List;

public interface UserService {


    void registerUser(UserServiceModel userServiceModel);


    UserServiceModel findByUsernameAndPassword(String username, String password);


    void loginUser(Long id, String username);

    UserEntity findById(Long id);

    List<UserViewModel> findAllUsersAndCountOfOrders();
}
