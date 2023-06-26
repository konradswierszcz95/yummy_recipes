package pl.konrad.swierszcz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.konrad.swierszcz.dto.RecipeDto;
import pl.konrad.swierszcz.dto.RecipeStepDto;
import pl.konrad.swierszcz.exception.reciepe.RecipeHasNotEnoughStepsException;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.model.id.RecipeStepId;
import pl.konrad.swierszcz.model.id.UserId;
import pl.konrad.swierszcz.rest.request.AddRecipeRequest;
import pl.konrad.swierszcz.usecase.AddRecipeUseCase;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final AddRecipeUseCase addRecipeUseCase;

    @PostMapping("/add")
    public RecipeId addRecipe(@RequestBody @Valid AddRecipeRequest request) {
        RecipeId recipeId = RecipeId.of(UUID.randomUUID());
        RecipeDto recipeDto = RecipeDto.aRecipeDto()
                .withId(recipeId)
                .withName(request.getName())
                .withAuthor(UserId.of(UUID.randomUUID()))
                .withSteps(
                        request.getSteps().stream().map(requestRecipeStep ->
                                RecipeStepDto.aRecipeStepDto()
                                        .withId(RecipeStepId.of(UUID.randomUUID()))
                                        .withRecipeId(recipeId)
                                        .withPosition(requestRecipeStep.getPosition())
                                        .withStepContent(requestRecipeStep.getContent())
                                        .withPictureUrl(requestRecipeStep.getPictureUrl())
                                        .build()
                        ).toList()
                )
                .build();

        return addRecipeUseCase.execute(recipeDto);
    }

    @PostMapping("/unprocesable")
    public RecipeId throwUnprocesableEntity() {
        throw new RecipeHasNotEnoughStepsException(UUID.randomUUID(), 0);
    }
}
