package com.example.daopattern.dao;

import com.example.daopattern.entity.User;

import java.util.List;

public interface UserDaoHibernate {
    User findById(Long id);
    Boolean save(User user);
    Boolean deleteById(Long id);
    List<User> findByFIO(String surname, String name, String patronymic);
    Integer updateById(User user);
    List<User> findBySurnameWithCriteria(String surname);
    List<User> findBySurnameWithoutCriteria(String surname);
}
