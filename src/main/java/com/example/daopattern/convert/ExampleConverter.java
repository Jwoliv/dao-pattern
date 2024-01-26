package com.example.daopattern.convert;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ExampleConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String attribute) {
        return new StringBuilder(attribute).reverse().toString().concat("111");
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        String data = new StringBuilder(dbData).reverse().toString();
        return data.substring(3);
    }
}
