package pl.konrad.swierszcz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.konrad.swierszcz.dto.RecipeDto;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.model.id.UserId;
import pl.konrad.swierszcz.usecase.AddRecipeUseCase;

import java.util.UUID;

@RequiredArgsConstructor
@RestController("/recipe")
public class RecipeController {

    private final AddRecipeUseCase addRecipeUseCase;

    @PostMapping("/random")
    public RecipeId saveRandomRecipe() {
        RecipeDto recipeDto = RecipeDto.aRecipeDto()
                .withId(RecipeId.of(UUID.randomUUID()))
                .withName("randooom")
                .withAuthor(UserId.of(UUID.randomUUID()))
                .build();

        return addRecipeUseCase.execute(recipeDto);
    }


}
