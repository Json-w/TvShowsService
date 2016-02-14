package com.jason.service.impl;

import com.jason.model.Activities;
import com.jason.model.Comments;
import com.jason.repository.ActivitiesRepository;
import com.jason.repository.CommentsRepository;
import com.jason.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ActivitiesServiceImpl implements ActivitiesService {
    @Autowired
    private ActivitiesRepository activitiesRepository;
    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public Page<Activities> findActivitiesByUserId(Pageable pageable, int userId) {
        return null;
    }

    @Override
    public Page<Comments> findCommentsByActivityId(Pageable pageable, int activityId) {
        return null;
    }

    @Override
    public boolean sendActivity(Activities activities) {
        return false;
    }

    @Override
    public void deleteActivity(int activityId) {

    }

    @Override
    public boolean commentActivity(Comments comments) {
        return false;
    }
}
