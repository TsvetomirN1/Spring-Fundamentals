package javaweb.battleShipsExam.service.impl;

import javaweb.battleShipsExam.current.CurrentUser;
import javaweb.battleShipsExam.model.entity.ShipEntity;
import javaweb.battleShipsExam.model.entity.UserEntity;
import javaweb.battleShipsExam.model.service.ShipAddServiceModel;
import javaweb.battleShipsExam.model.view.ShipViewModel;
import javaweb.battleShipsExam.repository.ShipRepository;
import javaweb.battleShipsExam.service.CategoryService;
import javaweb.battleShipsExam.service.ShipService;
import javaweb.battleShipsExam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CurrentUser currentUser;
    private final ShipRepository shipRepository;

    public ShipServiceImpl(ModelMapper modelMapper, UserService userService, CategoryService categoryService, CurrentUser currentUser, ShipRepository shipRepository) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
        this.currentUser = currentUser;
        this.shipRepository = shipRepository;
    }

    @Override
    public void addShip(ShipAddServiceModel shipAddServiceModel) {

        ShipEntity ship = modelMapper.map(shipAddServiceModel, ShipEntity.class);
        ship.setUser(userService.findById(currentUser.getId()));
        ship.setCategory(categoryService.findByCategoryEnum(shipAddServiceModel.getCategory()));

        shipRepository.save(ship);
    }

    @Override
    public List<ShipViewModel> findAll() {

        return shipRepository.findAll()
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void fire(String ship1, String ship2) {

        ShipEntity attacker = shipRepository.findByName(ship1);
        ShipEntity defender = shipRepository.findByName(ship2);

        if (attacker!=null && defender!=null){

            Long power = attacker.getPower();
            Long health = defender.getHealth();

            if(health-power <= 0){
                shipRepository.delete(defender);
            }else {
                defender.setHealth(health-power);
                shipRepository.save(defender);
            }

        }


    }

    @Override
    public List<ShipViewModel> findByUser(Long id) {

        UserEntity user = userService.findById(id);

        List<ShipEntity> ships = shipRepository.findAllByUser(user);

        return ships
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<ShipViewModel> findByUserNot(Long id) {

        UserEntity user = userService.findById(id);

        List<ShipEntity> ships = shipRepository.findAllByUserNot(user);

        return ships.stream().map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class))
                .collect(Collectors.toList());

    }
}
