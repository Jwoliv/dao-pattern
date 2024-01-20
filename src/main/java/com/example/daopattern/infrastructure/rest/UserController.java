package com.example.daopattern.infrastructure.rest;

import com.example.daopattern.entity.User;
import com.example.daopattern.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Setter(onMethod = @__(@Autowired))
    private UserRepository userRepository;

    @GetMapping("/{id}")
    private User findUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    private void deleteUserById(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }

    @PutMapping
    private void updateUserById(@RequestBody User user) {
        userRepository.save(user);
    }

    @PostMapping
    private void save(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping
    private List<User> findBySurnameAndNameAndPatronymic(
            @RequestParam("s") String surname,
            @RequestParam("n") String name,
            @RequestParam("p") String patronymic,
            @RequestParam("pn") Integer pageNumber,
            @RequestParam("ps") Integer pageSize,
            @RequestParam("sf") String sortedField
    ) {
        return userRepository.findBySurnameAndNameAndPatronymic(surname, name, patronymic, PageRequest.of(pageNumber, pageSize, Sort.by(sortedField).descending()));
    }
}
