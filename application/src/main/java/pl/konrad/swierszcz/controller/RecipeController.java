package pl.konrad.swierszcz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.konrad.swierszcz.exception.reciepe.RecipeHasNotEnoughStepsException;
import pl.konrad.swierszcz.model.id.RecipeId;
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
        return addRecipeUseCase.execute(request.toDto());
    }

    @PostMapping("/unprocesable")
    public RecipeId throwUnprocesableEntity() {
        throw new RecipeHasNotEnoughStepsException(UUID.randomUUID(), 0);
    }
}
