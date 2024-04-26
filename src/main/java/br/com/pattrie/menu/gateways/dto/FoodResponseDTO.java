package br.com.pattrie.menu.gateways.dto;

import br.com.pattrie.menu.domain.Food;

import java.math.BigDecimal;

public record FoodResponseDTO(Long id, String title, String image, BigDecimal price) {
    public FoodResponseDTO(final Food food) {
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
