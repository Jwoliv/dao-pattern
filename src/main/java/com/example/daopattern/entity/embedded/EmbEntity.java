package com.example.daopattern.entity.embedded;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class EmbEntity {
    private String firstField;
    private String secondField;
}
