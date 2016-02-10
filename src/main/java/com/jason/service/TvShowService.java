package com.jason.service;

import com.jason.model.TvShow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TvShowService {
    Page<TvShow> findLatestTvShows(Pageable pageable);
}
