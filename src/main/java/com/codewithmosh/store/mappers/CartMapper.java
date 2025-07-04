package com.codewithmosh.store.mappers;

import com.codewithmosh.store.dtos.CartDto;
import com.codewithmosh.store.dtos.CartItemDto;
import com.codewithmosh.store.entities.Cart;
import com.codewithmosh.store.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(source = "id", target = "id")
    CartDto toDto(Cart cart);

    @Mapping(expression = "java(cartItem.getTotalPrice())", target = "totalPrice")
    CartItemDto toDto(CartItem cartItem);
}
