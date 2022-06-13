package sk.stuba.fei.oop.test.exam.tank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.test.exam.Nation;
import sk.stuba.fei.oop.test.exam.artillery.chassis.Wheel;
import sk.stuba.fei.oop.test.exam.cannon.Tower;
import sk.stuba.fei.oop.test.exam.service.Vehicle;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LightTank extends Tank implements Vehicle {

    private Wheel wheelChassis;
    private Tower lightWeightTower;

    public LightTank(String name, Nation nation, float price, Tower tower, Wheel wheelChassis) {
        super(name, nation, price);
        this.lightWeightTower = tower;
        this.wheelChassis = wheelChassis;
    }
}
