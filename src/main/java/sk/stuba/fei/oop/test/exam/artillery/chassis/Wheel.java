package sk.stuba.fei.oop.test.exam.artillery.chassis;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sk.stuba.fei.oop.test.exam.service.Parts;

@EqualsAndHashCode(callSuper = true)
@Data
public class Wheel extends Chassis implements Parts {
    private int numberOfWheels;

    public Wheel(String name, float carryingCapacity, float rotationSpeed, float maxSpeed, int numberOfWheels) {
        super(name, carryingCapacity, rotationSpeed, maxSpeed);
        this.numberOfWheels = numberOfWheels;
    }


}
