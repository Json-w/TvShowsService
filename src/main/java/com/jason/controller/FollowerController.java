package com.jason.controller;

import com.jason.model.Follower;
import com.jason.model.ResponseData;
import com.jason.model.Status;
import com.jason.model.User;
import com.jason.service.FollowerService;
import com.jason.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/follower")
public class FollowerController {
    @Autowired
    private FollowerService followerService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseData findFollowersByUserId(@PathVariable int userId, int page, int size) {
        ResponseData responseData = new ResponseData();
        Page<Follower> findResult = followerService.findFollowersByUserId(new PageRequest(page, size), userId);
        if (null == findResult) {
            responseData.setStatus(Status.FAILURE);
        } else {
            responseData.setStatus(Status.SUCCESS);
            responseData.setData(findResult);
        }
        return responseData;
    }

    @RequestMapping(value = "/following/{userId}")
    public ResponseData findFollowingByUserId(@PathVariable int userId) {
        ResponseData responseData = new ResponseData();
        responseData.setStatus(Status.SUCCESS);
        Iterable<Follower> resultFollowing = followerService.findFollowingByUserId(userId);
        for (Follower follower : resultFollowing) {
            User followingUser = userService.find(follower.getUserId());
            followingUser.setPassword("");
            follower.setFollowingUser(followingUser);
        }
        responseData.setData(resultFollowing);
        return responseData;
    }

    @RequestMapping(value = "/follower/{userId}")
    public ResponseData findFollowerByUserId(@PathVariable int userId) {
        ResponseData responseData = new ResponseData();
        responseData.setStatus(Status.SUCCESS);
        Iterable<Follower> resultFollower = followerService.findFollowersByUserId(userId);
        for (Follower follower : resultFollower) {
            User followerUser = userService.find(follower.getFollowerUserId());
            followerUser.setPassword("");
            follower.setFollower(followerUser);
            follower.setInterFollow(followerService.checkIfInterFollow(userId, follower.getFollowerUserId()));
        }
        responseData.setData(resultFollower);
        return responseData;
    }

    @RequestMapping(value = "/followUser", method = RequestMethod.POST)
    public ResponseData followUser(Follower follower) {
        ResponseData responseData = new ResponseData();
        if (followerService.followUser(follower)) {
            responseData.setStatus(Status.SUCCESS);
        } else {
            responseData.setStatus(Status.FAILURE);
        }
        return responseData;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseData cancelFollow(@PathVariable int id) {
        ResponseData responseData = new ResponseData();
        responseData.setStatus(Status.SUCCESS);
        followerService.cancelFollow(id);
        return responseData;
    }
}
