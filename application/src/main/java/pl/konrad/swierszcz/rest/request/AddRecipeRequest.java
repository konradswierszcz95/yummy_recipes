package pl.konrad.swierszcz.rest.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.konrad.swierszcz.dto.RecipeDto;
import pl.konrad.swierszcz.dto.RecipeStepDto;
import pl.konrad.swierszcz.model.id.UserId;

import java.util.List;
import java.util.UUID;

@Builder(builderMethodName = "aAddRecipeRequest", setterPrefix = "with", toBuilder = true)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Data
public class AddRecipeRequest {
    @NotBlank(message = "Recipe name can not be null or contain only white characters")
    @Size(min = 5, max = 100, message = "Recipe name must contain between 5 and 100 characters")
    private String name;

    @NotNull(message = "Reciepe must have author")
    private UUID authorId;

    private List<RequestRecipeStep> steps;

    public RecipeDto toDto() {
        return RecipeDto.aRecipeDto()
                .withName(name)
                .withAuthorId(UserId.of(authorId))
                .withSteps(steps.stream().map(RequestRecipeStep::toDto).toList())
                .build();
    }

    @AllArgsConstructor(staticName = "of")
    @NoArgsConstructor
    @Data
    public static class RequestRecipeStep {
        @NotBlank(message = "Recipe step content can not be null or contain only white characters")
        @Size(min = 10, max = 350, message = "Reciepe step content should contain beetween 10 and 350 characters")
        private String content;

        @NotNull(message = "Recipe step must have position")
        private Integer position;

        private String pictureUrl;

        public RecipeStepDto toDto() {
            return RecipeStepDto.aRecipeStepDto()
                    .withPosition(position)
                    .withStepContent(content)
                    .withPictureUrl(pictureUrl)
                    .build();
        }
    }
}
