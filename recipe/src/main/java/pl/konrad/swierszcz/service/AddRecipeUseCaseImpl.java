package pl.konrad.swierszcz.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.konrad.swierszcz.dto.RecipeStepDto;
import pl.konrad.swierszcz.model.Recipe;
import org.springframework.stereotype.Service;
import pl.konrad.swierszcz.model.RecipeStep;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.dto.RecipeDto;
import pl.konrad.swierszcz.usecase.AddRecipeUseCase;
import pl.konrad.swierszcz.repository.RecipeRepository;

import java.util.List;

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
                .withSteps(mapSteps(recipe.getSteps()))
                .build();
        return repository.save(newRecipe).getId();
    }

    private List<RecipeStep> mapSteps(List<RecipeStepDto> stepDtos) {
        return stepDtos.stream()
                .map(RecipeStep::ofDto)
                .toList();
    }
}
