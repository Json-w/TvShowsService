package com.jason.controller;

import com.jason.model.ResponseData;
import com.jason.model.Status;
import com.jason.model.TvShow;
import com.jason.service.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tvShow")
public class TvShowController {
    @Autowired
    private TvShowService tvShowService;

    @RequestMapping("/listLatest")
    private ResponseData listLatestTvShows(int page, int size) {
        Pageable pageRequest = new PageRequest(page, size);
        ResponseData responseData = new ResponseData();
        Page<TvShow> findResult = tvShowService.findLatestTvShows(pageRequest);
        if (null != findResult) {
            responseData.setStatus(Status.SUCCESS);
            responseData.setData(findResult);
        } else {
            responseData.setStatus(Status.FAILURE);
        }
        return responseData;
    }

}
