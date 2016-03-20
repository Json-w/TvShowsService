package com.jason.service.impl;

import com.jason.model.ChooseTvShow;
import com.jason.model.TvShow;
import com.jason.repository.ChooseTvShowRepository;
import com.jason.repository.TvShowRepository;
import com.jason.service.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class TvShowServiceImpl implements TvShowService {
    @Autowired
    private TvShowRepository tvShowRepository;
    @Autowired
    private ChooseTvShowRepository chooseTvShowRepository;

    @Override
    public Page<TvShow> findLatestTvShows(Pageable pageable) {
        return tvShowRepository.findAll(pageable);
    }


    @Override
    public Page<ChooseTvShow> findChooseTvShowByUserId(Pageable pageable, int useId) {
        Page<ChooseTvShow> result = chooseTvShowRepository.findChooseTvShowsByUserId(pageable, useId);
        for (ChooseTvShow chooseTvShow : result.getContent()) {
            chooseTvShow.setTvShow(tvShowRepository.findTvShowByName(chooseTvShow.getTvShowName()));
        }
        return result;
    }

    @Override
    public void collectTvShow(String tvShowname, int userId) {
        ChooseTvShow chooseTvShow = new ChooseTvShow();
        chooseTvShow.setAddTime(new Date());
        chooseTvShow.setUserId(userId);
        chooseTvShow.setTvShowName(tvShowname);
        chooseTvShowRepository.save(chooseTvShow);
    }

    @Override
    public boolean checkIfCollected(String tvShowname, int userId) {
        if (chooseTvShowRepository.findChooseTvShowByTvShowNameAndUserId(tvShowname, userId) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteChooseTvShow(String tvShowname, int userId) {
        chooseTvShowRepository.deleteChooseTvShowByTvShowNameAndUserId(tvShowname, userId);
    }


}
