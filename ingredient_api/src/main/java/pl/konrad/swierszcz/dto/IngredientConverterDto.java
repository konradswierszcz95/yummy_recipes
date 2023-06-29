package pl.konrad.swierszcz.dto;

import lombok.Builder;
import lombok.Value;
import pl.konrad.swierszcz.model.id.IngredientConverterId;
import pl.konrad.swierszcz.model.id.IngredientId;

@Value
@Builder(builderMethodName = "aIngredientConverterDto", setterPrefix = "with", toBuilder = true)
public class IngredientConverterDto {
    IngredientConverterId id;
    IngredientId ingredientId;
    Double gramValue;
    Double milliliterValue;
    Double pieceValue;
}
