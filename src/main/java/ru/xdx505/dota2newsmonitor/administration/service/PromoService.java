package ru.xdx505.dota2newsmonitor.administration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xdx505.dota2newsmonitor.mvc.service.FollowerService;

@Service
public class PromoService {
  @Autowired
  private FollowerService followerService;
}
