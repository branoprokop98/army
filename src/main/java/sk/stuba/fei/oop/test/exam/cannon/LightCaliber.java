package sk.stuba.fei.oop.test.exam.cannon;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sk.stuba.fei.oop.test.exam.Nation;
import sk.stuba.fei.oop.test.exam.service.Parts;

@EqualsAndHashCode(callSuper = true)
@Data
public class LightCaliber extends Cannon implements Parts {
    private float radiusOfImpact;

    public LightCaliber(String name, float caliber, Nation nation, String cadence, float spread, float radiusOfImpact) {
        super(name, caliber, nation, cadence, spread);
        this.radiusOfImpact = radiusOfImpact;
    }
}
