package com.jason.repository;

import com.jason.model.Follower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerRepository extends PagingAndSortingRepository<Follower, Integer> {
    Page<Follower> findFollowersByUserId(Pageable pageable, int userId);

    Iterable<Follower> findFollowersByUserId(int userId);

    long countByUserId(int userId);

    long countByFollowerUserId(int followerUserId);

    @Query("select f from Follower f where f.followerUserId = ?1")
    Iterable<Follower> findFolloweingByUserId(int userId);

    @Query("select f from Follower f where f.userId = ?1 and f.followerUserId = ?2")
    Follower findFollowerByUserIdAndFollowerId(int userId, int followerId);
}
