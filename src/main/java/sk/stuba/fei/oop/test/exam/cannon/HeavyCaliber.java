package sk.stuba.fei.oop.test.exam.cannon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.test.exam.Nation;
import sk.stuba.fei.oop.test.exam.service.Parts;

@EqualsAndHashCode(callSuper = true)
@Data
public class HeavyCaliber extends Cannon implements Parts {
    private int numberOfAmmunition;

    public HeavyCaliber(String name, float caliber, Nation nation, String cadence, float spread, int numberOfAmmunition) {
        super(name, caliber, nation, cadence, spread);
        this.numberOfAmmunition = numberOfAmmunition;
    }
}
