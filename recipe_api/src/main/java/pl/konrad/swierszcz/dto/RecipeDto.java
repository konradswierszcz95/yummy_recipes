package pl.konrad.swierszcz.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.model.id.UserId;

@Value
@Builder(builderMethodName = "aRecipeDto", setterPrefix = "with", toBuilder = true)
public class RecipeDto {
    @NotNull
    RecipeId id;
    @NotBlank
    String name;
    @NotNull
    UserId author;
}
