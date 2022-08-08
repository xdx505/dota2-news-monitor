package ru.xdx505.dota2newsmonitor.parser.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.xdx505.dota2newsmonitor.parser.data.Post;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class ParserService {

  public Post getLastPost() {
    try {
      Iterator<JsonNode> events = getEvents(1);
      JsonNode postJsonNode = events.next();
      return new ObjectMapper().treeToValue(postJsonNode, Post.class);
    } catch (IOException | NoSuchElementException e) {
      log.error(e.getMessage());
      return null;
    }
  }

  private Iterator<JsonNode> getEvents(int count) throws IOException {
    try (InputStream responseStream = getNewsResponse(count)) {
      return new ObjectMapper().readTree(responseStream).get("events").elements();
    }
  }

  private InputStream getNewsResponse(int count) throws IOException {
    URL url = new URL("https://store.steampowered.com/events/ajaxgetpartnereventspageable/?clan_accountid=0&appid=570&offset=0&l=russian&origin=https:%2F%2Fwww.dota2.com&count=" + count);
    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
    httpConn.setRequestMethod("GET");

    httpConn.setRequestProperty("Accept", "application/json, text/plain, */*");
    httpConn.setRequestProperty("Accept-Language", "en-US,en;q=0.9,ru;q=0.8");
    httpConn.setRequestProperty("Connection", "keep-alive");
    httpConn.setRequestProperty("Origin", "https://www.dota2.com");
    httpConn.setRequestProperty("Referer", "https://www.dota2.com/");
    httpConn.setRequestProperty("Sec-Fetch-Dest", "empty");
    httpConn.setRequestProperty("Sec-Fetch-Mode", "cors");
    httpConn.setRequestProperty("Sec-Fetch-Site", "cross-site");
    httpConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36");
    httpConn.setRequestProperty("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"102\", \"Google Chrome\";v=\"102\"");
    httpConn.setRequestProperty("sec-ch-ua-mobile", "?0");
    httpConn.setRequestProperty("sec-ch-ua-platform", "\"Windows\"");

    return httpConn.getResponseCode() / 100 == 2
      ? httpConn.getInputStream()
      : httpConn.getErrorStream();
  }
}
