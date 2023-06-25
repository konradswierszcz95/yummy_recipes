package pl.konrad.swierszcz.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.model.id.UserId;

import java.util.List;

@Value
@Builder(builderMethodName = "aRecipeDto", setterPrefix = "with", toBuilder = true)
@Valid
public class RecipeDto {
    @NotNull
    RecipeId id;
    @NotBlank
    String name;
    @NotNull
    UserId author;
    @Singular
    @NotEmpty
    List<RecipeStepDto> steps;
}
