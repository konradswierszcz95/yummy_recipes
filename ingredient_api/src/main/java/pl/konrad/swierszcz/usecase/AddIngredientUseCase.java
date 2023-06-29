package pl.konrad.swierszcz.usecase;

import pl.konrad.swierszcz.dto.IngredientDto;
import pl.konrad.swierszcz.model.id.IngredientId;

public interface AddIngredientUseCase {
    IngredientId execute(IngredientDto ingredientDto);
}
