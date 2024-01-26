package com.example.daopattern.entity;

import com.example.daopattern.callback.UserJPACallback;
import com.example.daopattern.convert.ExampleConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_user")
@EntityListeners({UserJPACallback.class})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname;
    private String name;
    @Convert(converter = ExampleConverter.class)
    private String patronymic;
}
