package com.jason.service.impl;

import com.jason.model.Follower;
import com.jason.repository.FollowerRepository;
import com.jason.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FollowerServiceImpl implements FollowerService {
    @Autowired
    private FollowerRepository followerRepository;

    @Override
    public Page<Follower> findFollowersByUserId(Pageable pageable, int userId) {
        return followerRepository.findFollowersByUserId(pageable, userId);
    }

    @Override
    public boolean followUser(Follower follower) {
        if (followerRepository.save(follower).getId() > -1) {
            return true;
        }
        return false;
    }
}
