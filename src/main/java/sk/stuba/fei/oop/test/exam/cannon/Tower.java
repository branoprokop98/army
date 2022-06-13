package sk.stuba.fei.oop.test.exam.cannon;

import lombok.AllArgsConstructor;
import lombok.Data;
import sk.stuba.fei.oop.test.exam.service.Parts;

import java.util.concurrent.atomic.AtomicLong;

@Data
public class Tower implements Parts {
    private long id;
    private String name;
    private float rotationSpeed;
    private float view;
    private Cannon cannon;
    private static final AtomicLong generator = new AtomicLong(100);

    public void setID(){
        this.id = generator.getAndIncrement();
    }

    public Tower(String name, float rotationSpeed, float view, Cannon cannon) {
        this.name = name;
        this.rotationSpeed = rotationSpeed;
        this.view = view;
        this.cannon = cannon;
        setID();
    }

}
