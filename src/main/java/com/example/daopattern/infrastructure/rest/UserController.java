package com.example.daopattern.infrastructure.rest;

import com.example.daopattern.dao.UserDaoHibernate;
import com.example.daopattern.entity.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
// THREE OPTIONS OF THE DAO FOR USE CRUD OPERATIONS TO THE DATA
//    @Setter(onMethod = @__(@Autowired))
//    private UserDaoJT userDao;
//    @Setter(onMethod = @__(@Autowired))
//    private UserDao userDao;
    @Setter(onMethod = @__(@Autowired))
    private UserDaoHibernate userDao;

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
    private List<User> findBySurnameNameAndPatronymic(
            @RequestParam("s") String surname,
            @RequestParam("n") String name,
            @RequestParam("p") String patronymic,
            @RequestParam("ps") Integer pageSize,
            @RequestParam("pn") Integer pageNumber
    ) {
        return userDao.findByFIO(surname, name, patronymic, PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("/surname")
    private List<User> findBySurname(@RequestParam("s") String surname) {
        return userDao.findBySurnameWithoutCriteria(surname);
    }
}
