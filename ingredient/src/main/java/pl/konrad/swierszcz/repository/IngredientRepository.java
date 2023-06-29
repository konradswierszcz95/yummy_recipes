package pl.konrad.swierszcz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.konrad.swierszcz.model.Ingredient;
import pl.konrad.swierszcz.model.id.IngredientId;

public interface IngredientRepository extends JpaRepository<Ingredient, IngredientId> {
}
