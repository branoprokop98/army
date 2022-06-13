package sk.stuba.fei.oop.test.exam.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sk.stuba.fei.oop.test.exam.service.API;
import sk.stuba.fei.oop.test.exam.service.Vehicle;
import sk.stuba.fei.oop.test.exam.tank.HeavyTank;
import sk.stuba.fei.oop.test.exam.tank.LightTank;

@Controller
public class VehicleController {

    private API api;

    public VehicleController(API api) {
        this.api = api;
    }

    @GetMapping("detailVehicle/{id}")
    public String detailOfVehicle(Model model, @PathVariable long id){
        Vehicle vehicle = api.getVehicleMap().get(id);

        if(vehicle instanceof HeavyTank){
            HeavyTank heavyTank = (HeavyTank) vehicle;
            model.addAttribute("heavyTank", heavyTank);
            return "tank/detailHeavyTank";
        }else if(vehicle instanceof LightTank){
            LightTank lightTank = (LightTank) vehicle;
            model.addAttribute("lightTank", lightTank);
            return "tank/detailLightTank";
        }

//        model.addAttribute("vehicle", vehicle);
//        return "vehicle_parts/detailVehicle";
        return "redirect:";
    }
}
