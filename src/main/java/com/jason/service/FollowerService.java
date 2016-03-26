package com.jason.service;

import com.jason.model.Follower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FollowerService {
    Page<Follower> findFollowersByUserId(Pageable pageable, int userId);

    Iterable<Follower> findFollowersByUserId(int userId);

    boolean followUser(Follower follower);

    int countFollowersNum(int userId);

    int countFollowingNum(int userId);

    Iterable<Follower> findFollowingByUserId(int userId);

    void cancelFollow(int id);

    boolean checkIfInterFollow(int userId, int followerId);
}
