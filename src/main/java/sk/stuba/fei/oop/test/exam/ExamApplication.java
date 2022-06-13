package sk.stuba.fei.oop.test.exam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sk.stuba.fei.oop.test.exam.artillery.chassis.Crawler;
import sk.stuba.fei.oop.test.exam.cannon.Cannon;
import sk.stuba.fei.oop.test.exam.cannon.Tower;
import sk.stuba.fei.oop.test.exam.service.API;
import sk.stuba.fei.oop.test.exam.web.MenuController;

@SpringBootApplication
@Slf4j
@Controller
public class ExamApplication implements CommandLineRunner {
    private  API api;

    @Autowired
    public ExamApplication(API api) {
        this.api = api;
    }

    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
        log.info("Open in browser: http://localhost:8080/");
    }

    @Override
    public void run(String... args) throws Exception {
        Crawler crawler =  api.createCrawlerChassis("IS-3M",500,6,40,50);
        Cannon cannon =  api.createHeavyCannon("122mm BL-9", 122f, "15/60", Nation.ZSSR,0.8f, 40);
        Cannon cannon1 =  api.createHeavyCannon("122mm BL-9", 122f, "15/60", Nation.ZSSR,0.8f, 40);
        Tower tower =  api.createTower("IS-3", 6, 500, cannon);
        api.createHeavyTank("IS-3", Nation.England, 10000000, tower, crawler);
    }



}
