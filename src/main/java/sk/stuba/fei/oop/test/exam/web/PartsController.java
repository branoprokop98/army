package sk.stuba.fei.oop.test.exam.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sk.stuba.fei.oop.test.exam.artillery.chassis.Crawler;
import sk.stuba.fei.oop.test.exam.artillery.chassis.Wheel;
import sk.stuba.fei.oop.test.exam.cannon.HeavyCaliber;
import sk.stuba.fei.oop.test.exam.cannon.LightCaliber;
import sk.stuba.fei.oop.test.exam.cannon.Tower;
import sk.stuba.fei.oop.test.exam.service.API;
import sk.stuba.fei.oop.test.exam.service.Parts;

@Controller
public class PartsController {

    private API api;

    public PartsController(API api) {
        this.api = api;
    }

    @GetMapping("detailPart/{id}")
    public String detailOfPart(Model model, @PathVariable long id) {
        Parts parts = api.getPartsMap().get(id);

        if (parts instanceof HeavyCaliber) {
            HeavyCaliber heavyCaliber = (HeavyCaliber) parts;
            model.addAttribute("heavyCaliber", heavyCaliber);
            return "cannon/detailHeavyCaliber";
        } else if (parts instanceof LightCaliber) {
            LightCaliber lightCaliber = (LightCaliber) parts;
            model.addAttribute("lightCaliber", lightCaliber);
            return "cannon/detailLightCaliber";
        } else if (parts instanceof Crawler) {
            Crawler crawler = (Crawler) parts;
            model.addAttribute("crawler", crawler);
            return "chassis/detailOfCrawler";
        } else if (parts instanceof Wheel) {
            Wheel wheel = (Wheel) parts;
            model.addAttribute("wheel", wheel);
            return "chassis/detailOfWheel";
        } else if(parts instanceof Tower){
            Tower tower = (Tower) parts;
            model.addAttribute("tower", tower);
            return "tower/detailOfTower";
        }

        model.addAttribute("part", parts);

        return "redirect:";
    }
}
