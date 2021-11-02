package javaweb.battleShipsExam.service;

import javaweb.battleShipsExam.model.service.ShipAddServiceModel;
import javaweb.battleShipsExam.model.view.ShipViewModel;

import java.util.Arrays;
import java.util.List;

public interface ShipService {

    void addShip(ShipAddServiceModel shipAddServiceModel);

    List<ShipViewModel> findAll();

    void fire(String ship1, String ship2);

    List<ShipViewModel> findByUser(Long id);

    List<ShipViewModel> findByUserNot(Long id);
}
