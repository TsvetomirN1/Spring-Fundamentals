package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.enums.LevelEnum;
import com.example.pathfinder.model.enums.RoleEnum;
import com.example.pathfinder.model.service.UserServiceModel;
import com.example.pathfinder.repository.RoleRepository;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.UserService;
import com.example.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleRepository roleRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
        this.currentUser = currentUser;
    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        Role userRole = roleRepository.findByRole(RoleEnum.USER);

        User user = modelMapper.map(userServiceModel, User.class);
        user.setLevel(LevelEnum.BEGINNER);
        user.setRoles(Set.of(userRole));

        System.out.println();

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {

        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setUsername(username);
        currentUser.setId(id);

    }

    @Override
    public void logoutUser() {
        currentUser.setUsername(null);
        currentUser.setId(null);
    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public boolean isNameExist(String username) {

        return userRepository.findByUsername(username).isPresent();
    }
}
