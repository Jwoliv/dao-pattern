package com.example.daopattern.entity.embedded;

import com.example.daopattern.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

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
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    @Column(updatable = false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm ")
    private Timestamp createdTime;
    @UpdateTimestamp
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
    private Timestamp updatedTime;
    @Embedded
    private EmbEntity embEntity;
}
