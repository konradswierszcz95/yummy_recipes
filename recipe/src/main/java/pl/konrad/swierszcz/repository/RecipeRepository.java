package pl.konrad.swierszcz.repository;

import pl.konrad.swierszcz.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.konrad.swierszcz.model.id.RecipeId;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, RecipeId> {
}
