package com.example.daopattern.infrastructure.rest;

import com.example.daopattern.dao.UserDao;
import com.example.daopattern.entity.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Setter(onMethod = @__(@Autowired))
    private UserDao userDao;

    @GetMapping("/{id}")
    private User findUserById(@PathVariable("id") Long id) {
        return userDao.findById(id);
    }

    @DeleteMapping("/{id}")
    private Boolean deleteUserById(@PathVariable("id") Long id) {
        return userDao.deleteById(id);
    }

    @PutMapping
    private Integer updateUserById(@RequestBody User user) {
        return userDao.updateById(user);
    }

    @PostMapping
    private Boolean save(@RequestBody User user) {
        return userDao.save(user);
    }

    @GetMapping
    private List<User> findById(
            @RequestParam("s") String surname,
            @RequestParam("n") String name,
            @RequestParam("p") String patronymic
    ) {
        return userDao.findByFIO(surname, name, patronymic);
    }
}
