package pl.konrad.swierszcz.rest.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(builderMethodName = "aAddRecipeRequest", setterPrefix = "with", toBuilder = true)
@AllArgsConstructor (staticName = "of")
@NoArgsConstructor
@Data
public class AddRecipeRequest {
    @NotBlank(message = "Recipe name can not contain only white characters")
    @Min(value = 5, message = "Recipe name must contain at least 5 characters")
    @Max(value = 100, message = "Recipe name can not be longer than 100 characters")
    private String name;
}
