package pl.konrad.swierszcz.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.model.id.RecipeStepId;

@Value
@Builder(builderMethodName = "aRecipeStepDto", setterPrefix = "with", toBuilder = true)
public class RecipeStepDto {
    @NotBlank
    RecipeStepId id;
    @NotBlank
    String stepContent;
    @NotNull
    RecipeId recipeId;
    String pictureUrl;
    @NotNull
    Integer position;
}
