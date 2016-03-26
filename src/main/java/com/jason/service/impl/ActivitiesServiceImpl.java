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
        return activitiesRepository.findActivitiesByUserId(pageable, userId);
    }

    @Override
    public Page<Activities> findAllActivities(Pageable pageable) {
        return activitiesRepository.findAll(pageable);
    }

    @Override
    public Page<Comments> findCommentsByActivityId(Pageable pageable, int activityId) {
        return commentsRepository.findCommentsByActivityId(pageable, activityId);
    }

    @Override
    public Iterable<Comments> findCommentsByActivityId(int activityId) {
        return commentsRepository.findCommentsByActivityId(activityId);
    }

    @Override
    public boolean sendActivity(Activities activities) {
        Activities savedActivity = activitiesRepository.save(activities);
        if (savedActivity.getId() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteActivity(int activityId) {
        activitiesRepository.delete(activityId);
    }

    @Override
    public boolean commentActivity(Comments comments) {
        Comments savedComments = commentsRepository.save(comments);
        if (savedComments.getId() != 0) {
            return true;
        }
        return false;
    }
}
