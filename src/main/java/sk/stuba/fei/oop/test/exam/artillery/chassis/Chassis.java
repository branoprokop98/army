package sk.stuba.fei.oop.test.exam.artillery.chassis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Chassis {
    private long id;
    private String name;
    private float carryingCapacity;
    private float rotationSpeed;
    private float maxSpeed;
    private static final AtomicLong generator = new AtomicLong(100);

    public void setID(){
        this.id = generator.getAndIncrement();
    }

    public Chassis(String name, float carryingCapacity, float rotationSpeed, float maxSpeed) {
        this.name = name;
        this.carryingCapacity = carryingCapacity;
        this.rotationSpeed = rotationSpeed;
        this.maxSpeed = maxSpeed;
        setID();
    }
}
