package com.jason.controller;

import com.jason.model.*;
import com.jason.service.ActivitiesService;
import com.jason.service.UserService;
import com.mysql.fabric.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/activity")
public class ActivitiesController {
    @Autowired
    private ActivitiesService activitiesService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseData findActivitiesByUserId(@PathVariable int userId, int page, int size) {
        ResponseData responseData = new ResponseData();
        Map<String, Object> mixData = new HashMap<>();
        Page<Activities> findResult = activitiesService.findActivitiesByUserId(new PageRequest(page, size), userId);
        User user = userService.find(userId);
        user.setPassword("");
        mixData.put("userInfo", user);
        mixData.put("activities", findResult);
        if (findResult == null) {
            responseData.setStatus(Status.FAILURE);
        } else {
            responseData.setStatus(Status.SUCCESS);
        }
        responseData.setData(mixData);
        return responseData;
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResponseData sendActivity(Activities activitie) {
        ResponseData responseData = new ResponseData();
        if (activitiesService.sendActivity(activitie)) {
            responseData.setStatus(Status.SUCCESS);
        } else {
            responseData.setStatus(Status.FAILURE);
        }
        return responseData;
    }

    @RequestMapping(value = "/delete/{activityId}", method = RequestMethod.DELETE)
    public ResponseData deleteActivity(@PathVariable int activityId) {
        ResponseData responseData = new ResponseData();
        activitiesService.deleteActivity(activityId);
        responseData.setStatus(Status.SUCCESS);
        return responseData;
    }

    @RequestMapping(value = "/comments/{activityId}", method = RequestMethod.GET)
    public ResponseData findCommentsByActivityId(@PathVariable int activityId, int page, int size) {
        ResponseData responseData = new ResponseData();
        Page<Comments> findResult = activitiesService.findCommentsByActivityId(new PageRequest(page, size), activityId);
        if (null == findResult) {
            responseData.setStatus(Status.FAILURE);
            responseData.setData(findResult);
        } else {
            responseData.setStatus(Status.SUCCESS);
        }
        return responseData;
    }

    @RequestMapping(value = "/comments/comment", method = RequestMethod.POST)
    public ResponseData commentActivity(Comments comment) {
        ResponseData responseData = new ResponseData();
        if (activitiesService.commentActivity(comment)) {
            responseData.setStatus(Status.SUCCESS);
        } else {
            responseData.setStatus(Status.FAILURE);
        }

        return responseData;
    }
}
