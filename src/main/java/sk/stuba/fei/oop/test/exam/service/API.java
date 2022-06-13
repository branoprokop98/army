package sk.stuba.fei.oop.test.exam.service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.oop.test.exam.Nation;
import sk.stuba.fei.oop.test.exam.artillery.chassis.Chassis;
import sk.stuba.fei.oop.test.exam.artillery.chassis.Crawler;
import sk.stuba.fei.oop.test.exam.artillery.chassis.Wheel;
import sk.stuba.fei.oop.test.exam.cannon.Cannon;
import sk.stuba.fei.oop.test.exam.cannon.HeavyCaliber;
import sk.stuba.fei.oop.test.exam.cannon.LightCaliber;
import sk.stuba.fei.oop.test.exam.cannon.Tower;
import sk.stuba.fei.oop.test.exam.tank.HeavyTank;
import sk.stuba.fei.oop.test.exam.tank.LightTank;
import sk.stuba.fei.oop.test.exam.tank.Tank;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class API {
    private final Map<Long, Vehicle> vehicleMap;
    private final Map<Long, Parts> partsMap;
    private final Map<Long, Tank> tanks;
    private final Map<Long, Cannon> cannons;
    private final Map<Long, Chassis> chassis;
    private final Map<Long, Tower> towers;
    private static final AtomicLong generatorVehicle = new AtomicLong(100);
    private static final AtomicLong generatorParts = new AtomicLong(100);

    public API() {
        this.vehicleMap = new HashMap<>();
        this.partsMap = new HashMap<>();
        this.tanks = new HashMap<>();
        this.cannons = new HashMap<>();
        this.chassis = new HashMap<>();
        this.towers = new HashMap<>();
    }


    public void addVehicle(Vehicle vehicle){
        vehicleMap.put(generatorVehicle.getAndIncrement(), vehicle);
    }

    public void addPart(Parts parts){
        partsMap.put(generatorParts.getAndIncrement(), parts);
    }

    public HeavyTank createHeavyTank(String name, Nation nation, float price, Tower tower, Crawler crawlerChassis){
        HeavyTank heavyTank = new HeavyTank(name, nation, price, tower, crawlerChassis);
        tanks.put(heavyTank.getId(), heavyTank);
        addVehicle(heavyTank);
        return heavyTank;
    }

    public LightTank createLightTank(String name, Nation nation, float price, Tower tower, Wheel wheelChassis){
        LightTank lightTank = new LightTank(name, nation, price, tower, wheelChassis);
        tanks.put(lightTank.getId(), lightTank);
        addVehicle(lightTank);
        return lightTank;
    }

    public Wheel createWheelChassis(String name, float carryingCapacity, float rotationSpeed, float maxSpeed, int numberOfWheels){
        Wheel wheel = new Wheel(name, carryingCapacity, rotationSpeed, maxSpeed, numberOfWheels);
        chassis.put(wheel.getId(), wheel);
        addPart(wheel);
        return wheel;
    }

    public Crawler createCrawlerChassis(String name, float carryingCapacity, float rotationSpeed, float maxSpeed, int beltWidth){
        Crawler crawler = new Crawler(name, carryingCapacity, rotationSpeed, maxSpeed, beltWidth);
        chassis.put(crawler.getId(), crawler);
        addPart(crawler);
        return crawler;
    }

    public HeavyCaliber createHeavyCannon(String name, float caliber, String cadence, Nation nation, float spread, int numberOfAmmunition){
        HeavyCaliber heavyCaliber = new HeavyCaliber(name, caliber, nation, cadence, spread, numberOfAmmunition);
        cannons.put(heavyCaliber.getId(), heavyCaliber);
        addPart(heavyCaliber);
        return heavyCaliber;
    }

    public LightCaliber createLightCannon(String name, float caliber, String cadence, Nation nation, float spread, float radiusOfImpact){
        LightCaliber lightCaliber = new LightCaliber(name, caliber, nation, cadence, spread, radiusOfImpact);
        cannons.put(lightCaliber.getId(), lightCaliber);
        addPart(lightCaliber);
        return lightCaliber;
    }

    public Tower createTower(String name, float rotationSpeed, float view, Cannon cannon){
        Tower tower = new Tower(name, rotationSpeed, view, cannon);
        this.towers.put(tower.getId(), tower);
        addPart(tower);
        return tower;
    }


    public Tank getTank(long id){
        return this.tanks.get(id);
    }

    public Chassis getChassis(long id){
        return this.chassis.get(id);
    }

    public Cannon getCannon(long id){
        return this.cannons.get(id);
    }

    public Map<Long, Tank> getTanks() {
        return tanks;
    }

    public Map<Long, Cannon> getCannons() {
        return cannons;
    }

    public Map<Long, Chassis> getChassis() {
        return chassis;
    }

    public Map<Long, Tower> getTowers() {
        return towers;
    }

    public Map<Long, Vehicle> getVehicleMap() {
        return vehicleMap;
    }

    public Map<Long, Parts> getPartsMap() {
        return partsMap;
    }
}
