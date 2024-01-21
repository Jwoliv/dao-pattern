package com.example.daopattern.dao;

import com.example.daopattern.entity.Note;

import java.util.List;

public interface NoteDaoJT {
    List<Note> findAll();
    Note findById(Long id);
    Integer save(Note note);
    Integer update(Note note);
    Integer deleteById(Long id);
}
