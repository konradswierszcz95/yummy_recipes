package service;

import lombok.RequiredArgsConstructor;
import model.Recipe;
import org.springframework.stereotype.Service;
import pl.konrad.swierszcz.dto.RecipeDto;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.usecase.AddRecipeUseCase;
import repository.RecipeRepository;

@Service
@RequiredArgsConstructor
public class AddRecipeUseCaseImpl implements AddRecipeUseCase {
    private final RecipeRepository repository;

    public RecipeId execute(RecipeDto recipe) {
        Recipe newRecipe = Recipe.aRecipe()
                .withId(recipe.getId())
                .withName(recipe.getName())
                .withAuthor(recipe.getAuthor())
                .build();
        return repository.save(newRecipe).getId();
    }
}
