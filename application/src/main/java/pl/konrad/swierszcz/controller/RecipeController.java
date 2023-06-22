package pl.konrad.swierszcz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.konrad.swierszcz.dto.RecipeDto;
import pl.konrad.swierszcz.dto.RecipeStepDto;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.model.id.RecipeStepId;
import pl.konrad.swierszcz.model.id.UserId;
import pl.konrad.swierszcz.usecase.AddRecipeUseCase;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final AddRecipeUseCase addRecipeUseCase;

    @PostMapping("/random")
    public RecipeId saveRandomRecipe() {
        RecipeId recipeId = RecipeId.of(UUID.randomUUID());
        RecipeDto recipeDto = RecipeDto.aRecipeDto()
                .withId(recipeId)
                .withName("randooom")
                .withAuthor(UserId.of(UUID.randomUUID()))
                .withStep(
                        RecipeStepDto.aRecipeStepDto()
                                .withId(RecipeStepId.of(UUID.randomUUID()))
                                .withStepContent("some random step content")
                                .withRecipeId(recipeId)
                                .withPosition(1)
                                .build()
                )
                .withStep(
                        RecipeStepDto.aRecipeStepDto()
                                .withId(RecipeStepId.of(UUID.randomUUID()))
                                .withStepContent("another random step content")
                                .withRecipeId(recipeId)
                                .withPosition(2)
                                .build()
                )
                .build();

        return addRecipeUseCase.execute(recipeDto);
    }


}
