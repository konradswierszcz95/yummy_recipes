package pl.konrad.swierszcz.usecase;

import pl.konrad.swierszcz.dto.IngredientConverterDto;
import pl.konrad.swierszcz.model.id.IngredientConverterId;

public interface AddIngredientConverterUseCase {
    IngredientConverterId execute(IngredientConverterDto ingredientConverterDto);
}
