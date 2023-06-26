package pl.konrad.swierszcz.rest.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(builderMethodName = "aAddRecipeRequest", setterPrefix = "with", toBuilder = true)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Data
public class AddRecipeRequest {
    @NotBlank(message = "Recipe name can not contain only white characters")
    @Size(min = 5, max = 100, message = "Recipe name must contain between 5 and 100 characters")
    private String name;
}
