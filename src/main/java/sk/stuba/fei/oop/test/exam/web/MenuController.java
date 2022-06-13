package sk.stuba.fei.oop.test.exam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sk.stuba.fei.oop.test.exam.service.API;

@Controller
public class MenuController {

    private  API api;

    public MenuController(API api) {
        this.api = api;
    }

    @GetMapping
    public String menu(Model model){
        model.addAttribute("api", api);
        return "menu";
    }
}
