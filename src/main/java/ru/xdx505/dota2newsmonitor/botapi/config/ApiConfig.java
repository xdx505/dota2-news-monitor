package ru.xdx505.dota2newsmonitor.botapi.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.xdx505.dota2newsmonitor.botapi.Bot;
import ru.xdx505.dota2newsmonitor.botapi.TelegramFacade;

@Configuration
public class ApiConfig {
    @Autowired
    private BotConfig botConfig;

    @Bean
    public SetWebhook setWebhook() {
        return SetWebhook.builder()
                .url((botConfig.getPath()))
                .dropPendingUpdates(botConfig.isDropUpdates())
                .build();
    }

    @Bean
    public Bot springWebHookBot(SetWebhook setWebhook, TelegramFacade telegramFacade) throws TelegramApiException {
        Bot bot = new Bot(setWebhook, telegramFacade);
        bot.setBotToken(botConfig.getToken());
        bot.setBotUsername(botConfig.getUsername());
        bot.setBotPath(StringUtils.EMPTY);
        bot.setWebhook(setWebhook);
        return bot;
    }
}
