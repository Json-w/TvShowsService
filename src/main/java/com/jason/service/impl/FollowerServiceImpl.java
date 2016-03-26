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
    public Iterable<Follower> findFollowersByUserId(int userId) {
        return followerRepository.findFollowersByUserId(userId);
    }

    @Override
    public boolean followUser(Follower follower) {
        if (followerRepository.save(follower).getId() > -1) {
            return true;
        }
        return false;
    }

    @Override
    public int countFollowersNum(int userId) {
        return (int) followerRepository.countByUserId(userId);
    }

    @Override
    public int countFollowingNum(int userId) {
        return (int) followerRepository.countByFollowerUserId(userId);
    }

    @Override
    public Iterable<Follower> findFollowingByUserId(int userId) {
        return followerRepository.findFolloweingByUserId(userId);
    }

    @Override
    public void cancelFollow(int id) {
        followerRepository.delete(id);
    }

    @Override
    public boolean checkIfInterFollow(int userId, int followerId) {
        if (followerRepository.findFollowerByUserIdAndFollowerId(userId, followerId) != null &&
                followerRepository.findFollowerByUserIdAndFollowerId(followerId, userId) != null) {
            return true;
        }
        return false;
    }
}
