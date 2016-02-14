package com.jason.repository;

import com.jason.model.Activities;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesRepository extends PagingAndSortingRepository<Activities, Integer> {
    Page<Activities> findActivitiesByUserId(Pageable pageable, int userId);
}
