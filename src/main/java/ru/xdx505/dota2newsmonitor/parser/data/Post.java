package ru.xdx505.dota2newsmonitor.parser.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post implements Serializable {
  @JsonProperty("gid")
  private String eventGid;

  private String headLine;

  private String imageUrl;

  private String text;

  @SuppressWarnings("unchecked")
  @JsonProperty("announcement_body")
  private void unpackNested(Map<String, Object> announcementBody) {
    String body = (String) announcementBody.get("body");
    String[] bodyParts = body.split("\n");
    this.imageUrl = "https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/clans"
      + bodyParts[0].replace("[img]{STEAM_CLAN_IMAGE}", "").replace("[/img]", "");
    this.text = Arrays.stream(bodyParts).skip(1).collect(Collectors.joining("\n"));

    this.headLine = (String) announcementBody.get("headline");
  }
}
