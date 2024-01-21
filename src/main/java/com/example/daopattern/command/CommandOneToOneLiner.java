package com.example.daopattern.command;

import com.example.daopattern.entity.one_to_one.Child;
import com.example.daopattern.entity.one_to_one.Parent;
import com.example.daopattern.repository.ParentRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandOneToOneLiner implements CommandLineRunner {
    @Setter(onMethod = @__(@Autowired))
    private ParentRepository parentRepository;

    @Override
    public void run(String... args) {
        Parent parent = Parent.builder().parentTitle("PARENT TITLE").child(Child.builder().childTitle("CHILD TITLE").build()).build();
        parentRepository.save(parent);
    }
}
