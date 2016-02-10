package com.jason.service.impl;

import com.jason.model.TvShow;
import com.jason.repository.TvShowRepository;
import com.jason.service.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TvShowServiceImpl implements TvShowService {
    @Autowired
    private TvShowRepository tvShowRepository;

    @Override
    public Page<TvShow> findLatestTvShows(Pageable pageable) {
        return tvShowRepository.findAll(pageable);
    }
}
