package repository;

import model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.konrad.swierszcz.model.id.RecipeId;

public interface RecipeRepository extends JpaRepository<Recipe, RecipeId> {
}
