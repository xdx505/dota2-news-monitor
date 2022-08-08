package ru.xdx505.dota2newsmonitor.mvc.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Follower {
  @Id
  private Long chatId;
  private Long followedTelegramId;
  private String chatType;
}
