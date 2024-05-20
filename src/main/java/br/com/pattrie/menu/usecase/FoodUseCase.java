package br.com.pattrie.menu.usecase;

import br.com.pattrie.menu.domain.Food;
import br.com.pattrie.menu.gateways.dto.FoodResponseDTO;
import br.com.pattrie.menu.gateways.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodUseCase {
    private final FoodRepository repository;

    public void save(final Food food) {
        repository.save(food);
    }

    public List<FoodResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(FoodResponseDTO::new)
                .toList();
    }

    public FoodResponseDTO getBy(final Long id) {
        return repository.findById(id).map(FoodResponseDTO::new).orElse(null);
    }

    public FoodResponseDTO updateBy(final Food food) {
        if (repository.existsById(food.getId())) {
            repository.save(food);
        }
        return null;
    }
}
