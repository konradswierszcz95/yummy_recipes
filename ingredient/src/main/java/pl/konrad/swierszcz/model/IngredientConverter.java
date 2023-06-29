package pl.konrad.swierszcz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.konrad.swierszcz.dto.IngredientConverterDto;
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

    public static IngredientConverter fromDto(IngredientConverterDto dto, IngredientConverterId id, IngredientId ingredientId) {
        return IngredientConverter.aIngredientConverter()
                .withId(id)
                .withIngredientId(ingredientId)
                .withGramValue(dto.getGramValue())
                .withMilliliterValue(dto.getMilliliterValue())
                .withPieceValue(dto.getPieceValue())
                .build();
    }
}
