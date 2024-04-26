package br.com.pattrie.menu.domain;

import br.com.pattrie.menu.gateways.dto.FoodRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private BigDecimal price;

    public Food(final FoodRequestDTO foodRequestDTO) {
        this.title = foodRequestDTO.title();
        this.image = foodRequestDTO.image();
        this.price = BigDecimal.valueOf(foodRequestDTO.price());
    }
}
