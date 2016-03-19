package com.jason.repository;

import com.jason.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    @Modifying(clearAutomatically = true)
    @Query("Update User u set u.username = ?1,u.email = ?2,u.portraitUrl = ?3 where u.id = ?4")
    int updateUser(String username, String email, String portraitUrl, int id);

    @Modifying(clearAutomatically = true)
    @Query("Update User u set u.password = ?1 where u.id = ?2")
    int updatePwd(String password, int id);
}
