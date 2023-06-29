package pl.konrad.swierszcz.dto;

import lombok.Builder;
import lombok.Value;
import pl.konrad.swierszcz.model.id.IngredientId;

@Value
@Builder(builderMethodName = "aIngredientDto", setterPrefix = "with", toBuilder = true)
public class IngredientDto {
    IngredientId id;
    String name;
    Double energyValue;
    Double proteins;
    Double fats;
    Double carbohydrates;
    IngredientConverterDto converter;
}
