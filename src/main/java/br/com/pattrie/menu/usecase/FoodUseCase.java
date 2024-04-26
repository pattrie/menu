package br.com.pattrie.menu.usecase;

import br.com.pattrie.menu.domain.Food;
import br.com.pattrie.menu.gateways.dto.FoodResponseDTO;
import br.com.pattrie.menu.gateways.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
                .collect(Collectors.toList());
    }
}
