package com.example.daopattern.repository;

import com.example.daopattern.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryVarietyQueries extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM _user AS U WHERE U.surname = :surname")
    List<User> getAllBySurnameWithNativeQuery(@Param("surname") String surname);

    @Query("SELECT U FROM User AS U WHERE U.surname = ?1")
    List<User> getAllBySurnameWithQuery(String surname);

    @Query("SELECT U FROM User AS U WHERE U.surname = :surname")
    List<User> getAllBySurnameWithQueryOfNames(@Param("surname") String surname);

    List<User> getAllBySurnameNativeQuery(String surname);
}
