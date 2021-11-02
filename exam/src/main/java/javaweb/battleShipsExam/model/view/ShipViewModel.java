package javaweb.battleShipsExam.model.view;


import javaweb.battleShipsExam.model.entity.UserEntity;

public class ShipViewModel {
    private String name;
    private Long health;
    private Long power;
    private UserEntity user;

    public ShipViewModel() {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
