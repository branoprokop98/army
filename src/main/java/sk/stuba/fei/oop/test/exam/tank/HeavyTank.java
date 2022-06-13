package sk.stuba.fei.oop.test.exam.tank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.test.exam.Nation;
import sk.stuba.fei.oop.test.exam.artillery.chassis.Crawler;
import sk.stuba.fei.oop.test.exam.cannon.Tower;
import sk.stuba.fei.oop.test.exam.service.Vehicle;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class HeavyTank extends Tank implements Vehicle {
    private Crawler crawlerChassis;
    private Tower heavyWeightTower;

    public HeavyTank(String name, Nation nation, float price, Tower tower, Crawler crawlerChassis) {
        super(name, nation, price);
        this.heavyWeightTower = tower;
        this.crawlerChassis = crawlerChassis;
    }
}
