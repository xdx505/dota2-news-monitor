package ru.xdx505.dota2newsmonitor.botapi.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.xdx505.dota2newsmonitor.botapi.BotState;
import ru.xdx505.dota2newsmonitor.mvc.data.Follower;
import ru.xdx505.dota2newsmonitor.mvc.service.FollowerService;

@Component
public class StartMessageHandler implements MessageHandler {
  @Autowired
  private FollowerService followerService;

  @Override
  public BotApiMethod<?> handle(Message message) {
    long telegramId = message.getFrom().getId();
    long chatId = message.getChatId();
    String chatType = message.getChat().getType();

    if (followerService.exists(chatId)) {
      return new SendMessage(String.valueOf(chatId), "Вы уже подписаны на новости");
    }

    followerService.save(new Follower(chatId, telegramId, chatType));
    return new SendMessage(String.valueOf(chatId), "Подписал на новости!");
  }

  @Override
  public BotState getHandlerName() {
    return BotState.START;
  }
}
