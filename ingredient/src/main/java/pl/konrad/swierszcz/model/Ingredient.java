package pl.konrad.swierszcz.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.konrad.swierszcz.model.id.IngredientId;

@Builder(builderMethodName = "aIngredient", setterPrefix = "with", toBuilder = true)
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@Table(name = "ingredients", schema = "ingredient")
public class Ingredient {
    @EmbeddedId
    IngredientId id;
    @NotBlank
    String name;
    @NotNull
    Double energyValue;
    @NotNull
    Double proteins;
    @NotNull
    Double fats;
    @NotNull
    Double carbohydrates;

}
