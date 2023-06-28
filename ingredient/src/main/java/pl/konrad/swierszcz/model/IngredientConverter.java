package pl.konrad.swierszcz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.konrad.swierszcz.model.id.IngredientConverterId;
import pl.konrad.swierszcz.model.id.IngredientId;

@Builder(builderMethodName = "aIngredientConverter", setterPrefix = "with", toBuilder = true)
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@Table(name = "ingredient_converters", schema = "ingredient")
public class IngredientConverter {
    @EmbeddedId
    IngredientConverterId id;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "ingredient_id"))
    IngredientId ingredientId;
    Double gramValue;
    Double milliliterValue;
    Double pieceValue;
    Double glassValue;
}
