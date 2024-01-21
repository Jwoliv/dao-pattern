package com.example.daopattern.dao.impl;

import com.example.daopattern.dao.NoteDaoJT;
import com.example.daopattern.entity.Note;
import com.example.daopattern.mapper.NoteMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteDaoJTImpl implements NoteDaoJT {
    @Setter(onMethod = @__(@Autowired))
    private JdbcTemplate jdbcTemplate;
    @Setter(onMethod = @__(@Autowired))
    private NoteMapper noteMapper;

    @Override
    public List<Note> findAll() {
        return jdbcTemplate.query("SELECT * FROM note AS N", noteMapper);
    }

    @Override
    public Note findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM note AS N WHERE id = ?", noteMapper, id);
    }

    @Override
    public Integer save(Note note) {
        return jdbcTemplate.update(
                "INSERT INTO note(text, likes, dislikes) VALUES(?, ?, ?)",
                note.getText(), note.getLikes(), note.getDislikes()
        );
    }

    @Override
    public Integer update(Note note) {
        return jdbcTemplate.update(
                "UPDATE note SET text = ?, likes = ?, dislikes = ? WHERE id = ?",
                note.getDislikes(), note.getLikes(), note.getDislikes(), note.getId()
        );
    }

    @Override
    public Integer deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM note WHERE id = ?", id);
    }
}
