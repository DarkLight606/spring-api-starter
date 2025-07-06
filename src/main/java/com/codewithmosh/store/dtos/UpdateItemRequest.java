package com.codewithmosh.store.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateItemRequest {
    @NotNull(message = "")
    @Min(value = 1)
    @Max(value = 1000)
    private Integer quantity;
}
