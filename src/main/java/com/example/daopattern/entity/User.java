package com.example.daopattern.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_user")
@NamedQueries({
        @NamedQuery(
                name = "User.getAllBySurnameNameAndPatronymicNativeQuery",
                query = "FROM User u WHERE u.surname = :surname AND u.name = :name AND u.patronymic = :patronymic"
        ),
        @NamedQuery(
                name = "User.getAllBySurnameNativeQuery",
                query = "FROM User u WHERE u.surname = :surname"
        )
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
}
