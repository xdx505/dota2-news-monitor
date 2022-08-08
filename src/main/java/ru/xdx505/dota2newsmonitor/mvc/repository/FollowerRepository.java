package ru.xdx505.dota2newsmonitor.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xdx505.dota2newsmonitor.mvc.data.Follower;

public interface FollowerRepository extends JpaRepository<Follower, Long> {
}
