package com.jason.repository;

import com.jason.model.TvShow;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvShowRepository extends PagingAndSortingRepository<TvShow, Integer> {
    TvShow findTvShowByName(String name);
}
