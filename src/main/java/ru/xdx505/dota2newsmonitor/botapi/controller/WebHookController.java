package ru.xdx505.dota2newsmonitor.botapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.xdx505.dota2newsmonitor.botapi.Bot;

@RestController
public class WebHookController {
  @Autowired
  private Bot telegramBot;

  @RequestMapping(method = RequestMethod.POST, value = "${bot.token}/callback")
  public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
    return telegramBot.onWebhookUpdateReceived(update);
  }

}
