package com.example.daopattern.dao;

import com.example.daopattern.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserDaoJT {
    User findById(Long id);
    Boolean save(User user);
    Boolean deleteById(Long id);
    List<User> findByFIO(String surname, String name, String patronymic, Integer limit, Integer offset);
    List<User> findByFIO(String surname, String name, String patronymic, Pageable pageable);
    Integer updateById(User user);
}
