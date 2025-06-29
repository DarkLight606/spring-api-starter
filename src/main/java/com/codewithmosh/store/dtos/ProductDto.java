package com.codewithmosh.store.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    Long id;
    String name;
    String description;
    BigDecimal price;
    Byte categoryId;
}
