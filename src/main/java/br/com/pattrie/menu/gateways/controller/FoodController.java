package br.com.pattrie.menu.gateways.controller;

import br.com.pattrie.menu.domain.Food;
import br.com.pattrie.menu.gateways.dto.FoodRequestDTO;
import br.com.pattrie.menu.gateways.dto.FoodResponseDTO;
import br.com.pattrie.menu.usecase.FoodUseCase;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("food")
@RequiredArgsConstructor
public class FoodController {
    private final String ID = "id";

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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public FoodResponseDTO getBy(@PathVariable(ID) final long id) {
        return foodUseCase.getBy(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public FoodResponseDTO updateBy(
            @PathVariable(ID) final long id,
            @RequestBody final FoodRequestDTO foodDTO
    ) {
        val food = new Food(id, foodDTO);
        return foodUseCase.updateBy(food);
    }
}
