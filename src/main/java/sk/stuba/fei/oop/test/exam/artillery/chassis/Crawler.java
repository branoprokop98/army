package sk.stuba.fei.oop.test.exam.artillery.chassis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.test.exam.service.Parts;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Crawler extends Chassis implements Parts {
    private int beltWidth;

    public Crawler(String name, float carryingCapacity, float rotationSpeed, float maxSpeed, int beltWidth) {
        super(name, carryingCapacity, rotationSpeed, maxSpeed);
        this.beltWidth = beltWidth;
    }
}
