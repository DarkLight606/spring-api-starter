package com.codewithmosh.store.mappers;

import com.codewithmosh.store.dtos.CartDto;
import com.codewithmosh.store.dtos.CartItemDto;
import com.codewithmosh.store.dtos.UpdateItemRequest;
import com.codewithmosh.store.entities.Cart;
import com.codewithmosh.store.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(expression = "java(cart.getTotalPrice())", target = "totalPrice")
    CartDto toDto(Cart cart);

    @Mapping(expression = "java(cartItem.getTotalPrice())", target = "totalPrice")
    CartItemDto toDto(CartItem cartItem);

    void updateCartItem(UpdateItemRequest request, @MappingTarget CartItem cartItem);
}
