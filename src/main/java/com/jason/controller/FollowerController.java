package com.jason.controller;

import com.jason.Follower;
import com.jason.model.ResponseData;
import com.jason.model.Status;
import com.jason.service.FollowerService;
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

}
