package ru.xdx505.dota2newsmonitor.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.xdx505.dota2newsmonitor.mvc.data.Follower;
import ru.xdx505.dota2newsmonitor.mvc.repository.FollowerRepository;

@Service
public class FollowerService {
  @Autowired
  private FollowerRepository followerRepository;

  @Transactional(readOnly = true)
  public boolean exists(long chatId) {
    return followerRepository.existsById(chatId);
  }

  @Transactional
  public Follower save(Follower follower) {
    return followerRepository.save(follower);
  }
}
