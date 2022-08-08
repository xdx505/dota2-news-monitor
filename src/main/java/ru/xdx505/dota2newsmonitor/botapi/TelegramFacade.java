package ru.xdx505.dota2newsmonitor.botapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.xdx505.dota2newsmonitor.mvc.service.FollowerService;

@Component
public class TelegramFacade {
  @Autowired
  private BotStateContext botStateContext;

  @Autowired
  private FollowerService followerService;

  public BotApiMethod<?> handleUpdate(Update update) {
    if (update.hasCallbackQuery()) {
      return handleCallbackQuery(update);
    }
    if (update.hasMessage()) {
      return handleMessage(update.getMessage());
    }
    return null;
  }

  public BotApiMethod<?> handleCallbackQuery(Update update) {
    return null;
  }

  public BotApiMethod<?> handleMessage(Message message) {
    if (message.getText().startsWith("/start")) {
      return botStateContext.processInputMessage(BotState.START, message);
    }
    return null;
  }
}
