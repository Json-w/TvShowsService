package com.jason.repository;

import com.jason.model.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentsRepository extends PagingAndSortingRepository<Comments, Integer> {
    Page<Comments> findCommentsByActivityId(Pageable pageable, int activityId);
}
