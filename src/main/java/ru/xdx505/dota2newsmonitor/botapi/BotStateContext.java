package ru.xdx505.dota2newsmonitor.botapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.xdx505.dota2newsmonitor.botapi.handler.MessageHandler;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class BotStateContext {
  private final Map<BotState, MessageHandler> messageHandlers;

  @Autowired
  public BotStateContext(
    List<MessageHandler> messageHandlers
  ) {
    this.messageHandlers = messageHandlers.stream().collect(Collectors.toMap(MessageHandler::getHandlerName, Function.identity()));
  }

  public BotApiMethod<?> processInputMessage(BotState botState, Message message) {
    return messageHandlers.get(botState).handle(message);
  }
}
