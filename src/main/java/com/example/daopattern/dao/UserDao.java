package com.example.daopattern.dao;

import com.example.daopattern.entity.User;

import java.util.List;

public interface UserDao {
    User findById(Long id);
    User save(User user);
    Boolean deleteById(Long id);
    List<User> findByFIO(String surname, String name, String patronymic);
    Boolean updateById(User user);
}
