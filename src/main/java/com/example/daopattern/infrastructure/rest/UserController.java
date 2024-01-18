package com.example.daopattern.infrastructure.rest;

import com.example.daopattern.dao.UserDao;
import com.example.daopattern.entity.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Setter(onMethod = @__(@Autowired))
    private UserDao userDao;

    @GetMapping("/{id}")
    private User findUserById(@PathVariable("id") Long id) {
        return userDao.findById(id);
    }

    @PostMapping
    private User save(@RequestBody User user) {
        return userDao.save(user);
    }
}
