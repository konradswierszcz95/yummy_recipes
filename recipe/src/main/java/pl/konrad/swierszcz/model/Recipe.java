package pl.konrad.swierszcz.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import pl.konrad.swierszcz.dto.RecipeDto;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.model.id.UserId;

import java.util.List;

@Builder(builderMethodName = "aRecipe", setterPrefix = "with", toBuilder = true)
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@Table(name = "recipes", schema = "recipe")
public class Recipe {
    @EmbeddedId
    RecipeId id;
    @NotBlank
    String name;
    @NotNull
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "authorId"))
    UserId authorId;
    @Singular
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    List<RecipeStep> steps;

    public static Recipe ofDto(RecipeDto dto, RecipeId recipeId) {
        return Recipe.aRecipe()
                .withId(recipeId)
                .withName(dto.getName())
                .withAuthorId(dto.getAuthorId())
                .withSteps(
                        dto.getSteps().stream()
                                .map(step -> RecipeStep.ofDto(step, recipeId))
                                .toList()
                )
                .build();
    }
}
