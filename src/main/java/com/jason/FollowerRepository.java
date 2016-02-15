package com.jason;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerRepository extends PagingAndSortingRepository<Follower, Integer> {
    Page<Follower> findFollowersByUserId(Pageable pageable, int userId);
}
