package com.example.daopattern.repository;

import com.example.daopattern.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findBySurnameAndNameAndPatronymic(String surname, String name, String patronymic, Pageable pageable);
}
