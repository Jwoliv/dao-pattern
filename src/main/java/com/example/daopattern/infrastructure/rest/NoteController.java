package com.example.daopattern.infrastructure.rest;

import com.example.daopattern.dao.NoteDaoJT;
import com.example.daopattern.entity.Note;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Setter(onMethod = @__(@Autowired))
    private NoteDaoJT noteDao;
    @GetMapping("/{id}")
    private Note findUserById(@PathVariable("id") Long id) {
        return noteDao.findById(id);
    }

    @DeleteMapping("/{id}")
    private Integer deleteUserById(@PathVariable("id") Long id) {
        return noteDao.deleteById(id);
    }

    @PutMapping
    private Integer updateUserById(@RequestBody Note note) {
        return noteDao.update(note);
    }

    @PostMapping
    private Integer save(@RequestBody Note note) {
        return noteDao.save(note);
    }

    @GetMapping
    private List<Note> findAll() {
        return noteDao.findAll();
    }
}
