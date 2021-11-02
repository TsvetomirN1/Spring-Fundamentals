package javaweb.battleShipsExam.model.binding;

public class BattleBindingModel {

    private String ship1;
    private String ship2;

    public BattleBindingModel() {
    }

    public String getShip1() {
        return ship1;
    }

    public BattleBindingModel setShip1(String ship1) {
        this.ship1 = ship1;
        return this;
    }

    public String getShip2() {
        return ship2;
    }

    public BattleBindingModel setShip2(String ship2) {
        this.ship2 = ship2;
        return this;
    }
}
