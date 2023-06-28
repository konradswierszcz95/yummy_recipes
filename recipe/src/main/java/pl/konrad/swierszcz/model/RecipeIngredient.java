package pl.konrad.swierszcz.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.konrad.swierszcz.model.id.IngredientId;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.model.id.RecipeIngredientId;
import pl.konrad.swierszcz.model.types.IngredientUnitType;

@Builder(builderMethodName = "aRecipeIngredient", setterPrefix = "with", toBuilder = true)
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@Table(name = "recipe_ingredients", schema = "recipe")
public class RecipeIngredient {
    @EmbeddedId
    RecipeIngredientId id;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "recipe_id"))
    RecipeId recipeId;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "ingredient_id"))
    IngredientId ingredientId;
    @NotNull
    Double amount;
    @NotNull
    @Enumerated(EnumType.STRING)
    IngredientUnitType unit;
}
