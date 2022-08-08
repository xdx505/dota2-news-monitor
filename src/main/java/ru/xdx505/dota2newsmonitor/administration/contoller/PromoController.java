package ru.xdx505.dota2newsmonitor.administration.contoller;

import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;

@RestController("/administration/promo")
public class PromoController {
  @RequestMapping(method = RequestMethod.POST, value = "{chatType}")
  public BotApiMethod<?> sendPromo(
    @RequestParam String message,
    @RequestParam(required = false) byte[] image,
    @PathVariable String chatType
  ) {
    return null;//TODO реклама
  }
}
