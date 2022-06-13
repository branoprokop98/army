package sk.stuba.fei.oop.test.exam.tank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.test.exam.Nation;
import sk.stuba.fei.oop.test.exam.cannon.Tower;

import java.util.concurrent.atomic.AtomicLong;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Tank {
    private long id;
    private String name;
    private Nation nation;
    private float price;
    private Tower tower;
    private static final AtomicLong generator = new AtomicLong(100);

    public void setID(){
        this.id = generator.getAndIncrement();
    }

    public Tank(String name, Nation nation, float price) {
        this.name = name;
        this.nation = nation;
        this.price = price;
        setID();
    }
}
