package ru.xdx505.dota2newsmonitor.botapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration(value = "telegramBot")
@ConfigurationProperties(prefix = "bot")
public class BotConfig {
    private String path;
    private String username;
    private String token;
    private boolean dropUpdates;
}
