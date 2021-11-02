package javaweb.battleShipsExam.model.service;


import javaweb.battleShipsExam.model.entity.CategoryEnum;
import javaweb.battleShipsExam.model.entity.UserEntity;

import java.time.LocalDate;

public class ShipAddServiceModel {

    private Long id;
    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryEnum category;
    private UserEntity user;

    public ShipAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
