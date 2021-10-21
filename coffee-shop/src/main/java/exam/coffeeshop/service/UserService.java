package exam.coffeeshop.service;


import exam.coffeeshop.model.service.UserServiceModel;

public interface UserService {


    void registerUser(UserServiceModel userServiceModel);


    UserServiceModel findByUsernameAndPassword(String username, String password);


    void loginUser(Long id, String username);
}
