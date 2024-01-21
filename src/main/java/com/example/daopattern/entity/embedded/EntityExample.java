package com.example.daopattern.entity.embedded;

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
@Table(name = "entity_example")
@AttributeOverrides({
        @AttributeOverride(
                name = "embEntity.firstField",
                column = @Column(name = "first_field")
        ),
        @AttributeOverride(
                name = "embEntity.secondField",
                column = @Column(name = "second_field")
        )
})
public class EntityExample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String baseField1;
    private String baseField2;
    private String baseField3;
    private String baseField4;
    @Embedded
    private EmbEntity embEntity;
}
