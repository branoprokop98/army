package sk.stuba.fei.oop.test.exam.artillery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.test.exam.Nation;
import sk.stuba.fei.oop.test.exam.artillery.chassis.Crawler;
import sk.stuba.fei.oop.test.exam.cannon.HeavyCaliber;
import sk.stuba.fei.oop.test.exam.service.Vehicle;


@Data
@NoArgsConstructor
@AllArgsConstructor
public  class Artillery implements Vehicle {
    private long id;
    private String name;
    private Nation nation;
    private float price;
    private Crawler crawlerChassis;
    private HeavyCaliber heavyCaliber;
}
