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
                name = "get_all_by_surname_name_and_patronymic",
                query = "SELECT u FROM User u WHERE u.surname = :surname AND u.name = :name AND u.patronymic = :patronymic"
        ),
        @NamedQuery(
                name = "get_all_by_surname",
                query = "SELECT u FROM User u WHERE u.surname = :surname"
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
