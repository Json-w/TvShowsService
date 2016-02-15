package com.jason.service;

import com.jason.Follower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FollowerService {
    Page<Follower> findFollowersByUserId(Pageable pageable, int userId);

    boolean followUser(Follower follower);

}
