package pl.konrad.swierszcz.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.konrad.swierszcz.model.Recipe;
import org.springframework.stereotype.Service;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.dto.RecipeDto;
import pl.konrad.swierszcz.usecase.AddRecipeUseCase;
import pl.konrad.swierszcz.repository.RecipeRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddRecipeUseCaseImpl implements AddRecipeUseCase {
    private final RecipeRepository repository;

    @Override
    public RecipeId execute(RecipeDto recipe) {
        Recipe newRecipe = Recipe.aRecipe()
                .withId(recipe.getId())
                .withName(recipe.getName())
                .withAuthor(recipe.getAuthor())
                .build();
        return repository.save(newRecipe).getId();
    }
}
