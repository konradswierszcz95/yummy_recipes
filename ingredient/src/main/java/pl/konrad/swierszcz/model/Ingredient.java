package pl.konrad.swierszcz.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import pl.konrad.swierszcz.dto.IngredientDto;
import pl.konrad.swierszcz.model.id.IngredientConverterId;
import pl.konrad.swierszcz.model.id.IngredientId;

import java.util.UUID;

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
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id")
    IngredientConverter converter;

    public static Ingredient fromDto(IngredientDto dto, IngredientId id) {
        return Ingredient.aIngredient()
                .withId(id)
                .withName(dto.getName())
                .withEnergyValue(dto.getEnergyValue())
                .withProteins(dto.getProteins())
                .withFats(dto.getFats())
                .withCarbohydrates(dto.getCarbohydrates())
                .withConverter(IngredientConverter.fromDto(dto.getConverter(), IngredientConverterId.of(UUID.randomUUID()), id))
                .build();
    }
}
