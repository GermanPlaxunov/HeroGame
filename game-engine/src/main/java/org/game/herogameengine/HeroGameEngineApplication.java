package org.game.herogameengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class HeroGameEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroGameEngineApplication.class, args);
    }

}
