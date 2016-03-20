package com.jason.repository;

import com.jason.model.ChooseTvShow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChooseTvShowRepository extends PagingAndSortingRepository<ChooseTvShow, Integer> {
    Page<ChooseTvShow> findChooseTvShowsByUserId(Pageable queryCondition, int userId);

    ChooseTvShow findChooseTvShowByTvShowNameAndUserId(String tvShowname, int userId);

    void deleteChooseTvShowByTvShowNameAndUserId(String tvShowname, int userId);
}
