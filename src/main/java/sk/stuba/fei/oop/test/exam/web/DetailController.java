package sk.stuba.fei.oop.test.exam.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.stuba.fei.oop.test.exam.artillery.chassis.Chassis;
import sk.stuba.fei.oop.test.exam.artillery.chassis.Crawler;
import sk.stuba.fei.oop.test.exam.artillery.chassis.Wheel;
import sk.stuba.fei.oop.test.exam.cannon.Cannon;
import sk.stuba.fei.oop.test.exam.cannon.HeavyCaliber;
import sk.stuba.fei.oop.test.exam.cannon.LightCaliber;
import sk.stuba.fei.oop.test.exam.cannon.Tower;
import sk.stuba.fei.oop.test.exam.service.API;
import sk.stuba.fei.oop.test.exam.service.Parts;
import sk.stuba.fei.oop.test.exam.service.Vehicle;
import sk.stuba.fei.oop.test.exam.tank.HeavyTank;
import sk.stuba.fei.oop.test.exam.tank.LightTank;
import sk.stuba.fei.oop.test.exam.tank.Tank;

@Controller
public class DetailController {

    private API api;

    public DetailController(API api) {
        this.api = api;
    }


    @GetMapping("/detailTank/{id}")
    public String detailOfHeavyTank(Model model, @PathVariable long id) {
        Tank tank = api.getTanks().get(id);
        if (tank instanceof HeavyTank) {
            HeavyTank heavyTank = (HeavyTank) api.getTanks().get(id);
            model.addAttribute("heavyTank", heavyTank);
            return "tank/detailHeavyTank";
        } else if (tank instanceof LightTank) {
            LightTank lightTank = (LightTank) api.getTanks().get(id);
            model.addAttribute("lightTank", lightTank);
            return "tank/detailLightTank";
        }
        return "redirect:";
    }

    @GetMapping("/detailCaliber/{id}")
    public String detailOfCaliber(Model model, @PathVariable long id) {
        Cannon cannon = api.getCannons().get(id);
        if (cannon instanceof HeavyCaliber) {
            HeavyCaliber heavyCaliber = (HeavyCaliber) api.getCannons().get(id);
            model.addAttribute("heavyCaliber", heavyCaliber);
            return "cannon/detailHeavyCaliber";
        } else if (cannon instanceof LightCaliber) {
            LightCaliber lightCaliber = (LightCaliber) api.getCannons().get(id);
            model.addAttribute("lightCaliber", lightCaliber);
            return "cannon/detailLightCaliber";
        }
        return "redirect:";
    }

    @GetMapping("/detailChassis/{id}")
    public String detailOfChassis(Model model, @PathVariable long id) {
        Chassis chassis = api.getChassis().get(id);
        if (chassis instanceof Crawler) {
            Crawler crawler = (Crawler) api.getChassis().get(id);
            model.addAttribute("crawler", crawler);
            return "chassis/detailOfCrawler";
        } else if (chassis instanceof Wheel) {
            Wheel wheel = (Wheel) api.getChassis().get(id);
            model.addAttribute("wheel", wheel);
            return "chassis/detailOfWheel";
        }
        return "redirect:";
    }

    @GetMapping("/detailTower/{id}")
    public String detailOfTower(Model model, @PathVariable long id) {
        Tower tower = api.getTowers().get(id);

        model.addAttribute("tower", tower);

        return "tower/detailOfTower";
    }

}
