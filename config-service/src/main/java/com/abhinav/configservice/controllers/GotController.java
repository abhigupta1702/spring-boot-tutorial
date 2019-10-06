package com.abhinav.configservice.controllers;

import com.abhinav.configservice.GameOfThroneProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Data
public class GotController {
    private List<String> characters; //props
    private int kingdoms; //props
    @Value("${server.port}")
    private int port; //args
    private String profile; // Env
    private String author;

    @Value("${game-of-thrones.characters}")
    void setCharacters(String players) {
        this.characters = Arrays.asList(players.split(","));
    }

    // export SPRING_PROFILES_ACTIVE=dev in bash_profile
    @Value("${spring.profiles.active}")
    void setActiveProfiles(String profile) {
        this.profile = profile;
    }

    @Autowired
    void setProjectProperties(GameOfThroneProperties gameOfThroneProperties) {
        this.kingdoms = gameOfThroneProperties.getKingdoms();
    }

    @Autowired
    void setAuthor(Environment environment) {
        this.author = environment.getProperty("game-of-thrones.author");
    }

    @GetMapping("/props")
    public GotController get() {
        return this;
    }
}
