package com.jason.service;

import com.jason.model.Activities;
import com.jason.model.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ActivitiesService {
    Page<Activities> findActivitiesByUserId(Pageable pageable, int userId);

    Page<Activities> findAllActivities(Pageable pageable);

    Page<Comments> findCommentsByActivityId(Pageable pageable, int activityId);

    boolean sendActivity(Activities activities);

    void deleteActivity(int activityId);

    boolean commentActivity(Comments comments);
}
