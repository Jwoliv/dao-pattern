package com.example.daopattern.callback;

import com.example.daopattern.entity.User;
import com.example.daopattern.repository.UserRepository;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class UserJPACallback {

    @PrePersist
    public void prePersist(User user) {
        System.out.println(getUserRepository().findBySurnameAndNameAndPatronymic(user.getSurname(), user.getName(), user.getPatronymic(), PageRequest.of(0, 40)));
        System.out.println("PRE PERSIST");
    }

    @PreRemove
    public void preRemove(User user) {
        System.out.println("PRE REMOVE");
    }

    public UserRepository getUserRepository() {
        return SpringJPAContext.getApplicationContext().getBean(UserRepository.class);
    }
}
