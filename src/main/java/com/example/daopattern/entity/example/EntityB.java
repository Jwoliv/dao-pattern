package com.example.daopattern.entity.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "entity_b")
@EqualsAndHashCode(callSuper = true)
public class EntityB extends BaseEntity {
    private String bField;
}


