package com.example.daopattern.mapper;


import com.example.daopattern.entity.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserListMapper implements RowMapper<List<User>> {
    @Setter(onMethod = @__(@Autowired))
    private UserMapper userMapper;

    @Override
    public List<User> mapRow(ResultSet rs, int rowNum) throws SQLException {
        var users = new ArrayList<User>();
        while (rs.next()) {
            users.add(userMapper.mapRow(rs, rowNum));
        }
        return users;
    }
}
