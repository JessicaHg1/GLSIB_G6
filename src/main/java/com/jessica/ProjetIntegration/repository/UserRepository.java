package com.jessica.ProjetIntegration.repository;


import com.jessica.ProjetIntegration.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query("SELECT u from user u where u.username = :username")
    User findByUsername(@Param("username") String username);
}
