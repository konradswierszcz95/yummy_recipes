package pl.konrad.swierszcz.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.konrad.swierszcz.dto.RecipeStepDto;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.model.id.RecipeStepId;

@Builder(builderMethodName = "aRecipeStep", setterPrefix = "with", toBuilder = true)
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@Table(name = "recipe_steps")
public class RecipeStep {
    @EmbeddedId
    RecipeStepId id;
    @NotBlank
    String stepContent;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "recipe_id"))
    RecipeId recipeId;
    @NotNull
    Integer position;
    String pictureUrl;

    public static RecipeStep ofDto(RecipeStepDto dto) {
        return RecipeStep.aRecipeStep()
                .withId(dto.getId())
                .withRecipeId(dto.getRecipeId())
                .withPictureUrl(dto.getPictureUrl())
                .withPosition(dto.getPosition())
                .withStepContent(dto.getStepContent())
                .build();
    }
}
