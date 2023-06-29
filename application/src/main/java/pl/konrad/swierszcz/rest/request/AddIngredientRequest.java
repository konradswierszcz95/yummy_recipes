package pl.konrad.swierszcz.rest.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.konrad.swierszcz.dto.IngredientConverterDto;
import pl.konrad.swierszcz.dto.IngredientDto;

@Builder(builderMethodName = "aAddIngredientRequest", setterPrefix = "with", toBuilder = true)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Data
public class AddIngredientRequest {
    @NotBlank(message = "Ingredient name can not be null or contain only white characters")
    @Size(min = 3, max = 50, message = "Ingredient name must contain between 3 and 50 characters")
    private String name;
    @NotNull(message = "Energy value must be included")
    private Double energyValue;
    @NotNull(message = "Proteins amount must be included")
    private Double proteins;
    @NotNull(message = "Fats amount must be included")
    private Double fats;
    @NotNull(message = "Carbohydrates amount must be included")
    private Double carbohydrates;
    @NotNull(message = "Ingredient requires unit converter")
    private RequestIngredientConverter unitConverter;

    public IngredientDto toDto() {
        return IngredientDto.aIngredientDto()
                .withName(name)
                .withEnergyValue(energyValue)
                .withProteins(proteins)
                .withFats(fats)
                .withCarbohydrates(carbohydrates)
                .withConverter(unitConverter.toDto())
                .build();
    }

    @Builder(builderMethodName = "aRequestIngredientConverter", setterPrefix = "with", toBuilder = true)
    @AllArgsConstructor(staticName = "of")
    @NoArgsConstructor
    @Data
    public static class RequestIngredientConverter {
        private Double gramValue;
        private Double milliliterValue;
        private Double pieceValue;

        public IngredientConverterDto toDto() {
            return IngredientConverterDto.aIngredientConverterDto()
                    .withGramValue(gramValue)
                    .withMilliliterValue(milliliterValue)
                    .withPieceValue(pieceValue)
                    .build();
        }
    }
}
