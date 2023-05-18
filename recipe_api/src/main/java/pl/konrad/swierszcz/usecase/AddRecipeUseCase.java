package pl.konrad.swierszcz.usecase;

import pl.konrad.swierszcz.dto.RecipeDto;
import pl.konrad.swierszcz.model.id.RecipeId;

public interface AddRecipeUseCase {
    RecipeId execute(RecipeDto recipeDto);
}
