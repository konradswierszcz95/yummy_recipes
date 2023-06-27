package pl.konrad.swierszcz.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.konrad.swierszcz.dto.RecipeDto;
import pl.konrad.swierszcz.model.Recipe;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.repository.RecipeRepository;
import pl.konrad.swierszcz.usecase.AddRecipeUseCase;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddRecipeUseCaseImpl implements AddRecipeUseCase {
    private final RecipeRepository repository;

    @Override
    public RecipeId execute(RecipeDto recipe) {
        RecipeId recipeId = RecipeId.of(UUID.randomUUID());
        Recipe newRecipe = Recipe.ofDto(recipe, recipeId);
        return repository.save(newRecipe).getId();
    }
}
