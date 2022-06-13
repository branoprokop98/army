package sk.stuba.fei.oop.test.exam.cannon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.test.exam.Nation;

import java.util.concurrent.atomic.AtomicLong;

@Data
@NoArgsConstructor
public abstract class Cannon {
    private long id;
    private String name;
    private Nation nation;
    private float caliber;
    private String cadence;
    private float spread;
    private static final AtomicLong generator = new AtomicLong(100);

    public void setID(){
        this.id = generator.getAndIncrement();
    }

    public Cannon(String name, float caliber, Nation nation, String cadence, float spread) {
        this.name = name;
        this.caliber = caliber;
        this.cadence = cadence;
        this.spread = spread;
        this.nation = nation;
        setID();
    }
}
