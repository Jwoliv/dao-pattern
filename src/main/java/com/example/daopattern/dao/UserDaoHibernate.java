package com.example.daopattern.dao;

import com.example.daopattern.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserDaoHibernate {
    User findById(Long id);
    Boolean save(User user);
    Boolean deleteById(Long id);
    List<User> findByFIO(String surname, String name, String patronymic, Pageable pageRequest);
    Integer updateById(User user);
    List<User> findBySurnameWithCriteria(String surname);
    List<User> findBySurnameWithoutCriteria(String surname);
}
