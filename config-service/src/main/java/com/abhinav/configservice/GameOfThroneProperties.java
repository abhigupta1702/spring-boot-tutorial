package com.abhinav.configservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("game-of-thrones")
@Data
public class GameOfThroneProperties {
    private String characters;
    private int kingdoms;
}
