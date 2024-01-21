package com.example.daopattern.mapper;

import com.example.daopattern.entity.Note;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class NoteMapper implements RowMapper<Note> {
    @Override
    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Note.builder()
                .id(rs.getLong("id"))
                .text(rs.getString("text"))
                .likes(rs.getLong("likes"))
                .dislikes(rs.getLong("dislikes"))
                .build();
    }
}
