package br.com.pattrie.menu.gateways.controller;

import br.com.pattrie.menu.domain.Food;
import br.com.pattrie.menu.gateways.dto.FoodRequestDTO;
import br.com.pattrie.menu.gateways.dto.FoodResponseDTO;
import br.com.pattrie.menu.usecase.FoodUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("food")
@RequiredArgsConstructor
public class FoodController {
    private final FoodUseCase foodUseCase;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody final FoodRequestDTO foodDTO) {
        final Food food = new Food(foodDTO);
        foodUseCase.save(food);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        return foodUseCase.getAll();
    }
}
