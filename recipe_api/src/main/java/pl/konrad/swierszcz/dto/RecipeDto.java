package pl.konrad.swierszcz.dto;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.model.id.UserId;

import java.util.List;

@Value
@Builder(builderMethodName = "aRecipeDto", setterPrefix = "with", toBuilder = true)
public class RecipeDto {
    RecipeId id;
    String name;
    UserId authorId;
    @Singular
    List<RecipeStepDto> steps;
}
