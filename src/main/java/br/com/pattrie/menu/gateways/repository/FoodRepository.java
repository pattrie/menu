package br.com.pattrie.menu.gateways.repository;

import br.com.pattrie.menu.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
