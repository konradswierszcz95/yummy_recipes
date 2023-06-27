package pl.konrad.swierszcz.dto;

import lombok.Builder;
import lombok.Value;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.model.id.RecipeStepId;

@Value
@Builder(builderMethodName = "aRecipeStepDto", setterPrefix = "with", toBuilder = true)
public class RecipeStepDto {
    RecipeStepId id;
    String stepContent;
    RecipeId recipeId;
    String pictureUrl;
    Integer position;
}
