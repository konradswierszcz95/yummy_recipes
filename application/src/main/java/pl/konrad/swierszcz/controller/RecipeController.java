package pl.konrad.swierszcz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.konrad.swierszcz.dto.RecipeDto;
import pl.konrad.swierszcz.dto.RecipeStepDto;
import pl.konrad.swierszcz.exception.reciepe.RecipeHasNotEnoughStepsException;
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
                .withName("reciepe name " + recipeId)
                .withAuthor(UserId.of(UUID.randomUUID()))
                .withStep(
                        RecipeStepDto.aRecipeStepDto()
                                .withId(RecipeStepId.of(UUID.randomUUID()))
                                .withStepContent("aaa")
                                .withRecipeId(recipeId)
                                .withPosition(1)
                                .build()
                )
                .withStep(
                        RecipeStepDto.aRecipeStepDto()
                                .withId(RecipeStepId.of(UUID.randomUUID()))
                                .withStepContent("bbb")
                                .withRecipeId(recipeId)
                                .withPosition(2)
                                .build()
                )
                .withStep(
                        RecipeStepDto.aRecipeStepDto()
                                .withId(RecipeStepId.of(UUID.randomUUID()))
                                .withStepContent("ccc")
                                .withRecipeId(recipeId)
                                .withPosition(3)
                                .build()
                )
                .build();

        return addRecipeUseCase.execute(recipeDto);
    }

    @PostMapping("/unprocesable")
    public RecipeId throwUnprocesableEntity() {
        throw new RecipeHasNotEnoughStepsException(UUID.randomUUID(), 0);
    }
}
