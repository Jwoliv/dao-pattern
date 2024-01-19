package com.example.daopattern.dao.impl;

import com.example.daopattern.dao.UserDaoJT;
import com.example.daopattern.entity.User;
import com.example.daopattern.mapper.UserListMapper;
import com.example.daopattern.mapper.UserMapper;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.daopattern.utils.SqlRequests.*;


@Slf4j
@Component
public class UserDaoJTImpl implements UserDaoJT {
    @Setter(onMethod = @__(@Autowired))
    private JdbcTemplate jdbcTemplate;
    @Setter(onMethod = @__(@Autowired))
    private UserMapper userMapper;
    @Setter(onMethod = @__(@Autowired))
    private UserListMapper userListMapper;

    @Override
    public User findById(Long id) {
        log.info("ID" + id);
        return jdbcTemplate.queryForObject(SELECT_BY_ID, userMapper, id);
    }

    @Override
    public Boolean save(User user) {
        return jdbcTemplate.update(INSERT_NEW_USER, userMapper, user.getSurname(), user.getName(), user.getPatronymic()) > 0;
    }

    @Override
    public Boolean deleteById(Long id) {
        return jdbcTemplate.update(DELETE_USER_BY_ID, id) > 0;
    }

    @Override
    public List<User> findByFIO(String surname, String name, String patronymic) {
        return jdbcTemplate.queryForObject(SELECT_ALL_BY_FIO, userListMapper, surname, name, patronymic);
    }

    @Override
    public Integer updateById(User user) {
        return jdbcTemplate.update(UPDATE_EXISTED_USER, user.getName(), user.getSurname(), user.getPatronymic());
    }
}
