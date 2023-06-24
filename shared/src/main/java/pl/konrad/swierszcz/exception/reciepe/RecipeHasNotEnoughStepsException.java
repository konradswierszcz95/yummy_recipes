package pl.konrad.swierszcz.exception.reciepe;

import pl.konrad.swierszcz.exception.UnprocesableEntityApiException;

import java.util.UUID;

public class RecipeHasNotEnoughStepsException extends UnprocesableEntityApiException {

    public RecipeHasNotEnoughStepsException(UUID recipeId, Integer numberOfSteps) {
        super(String.format("Recipe %s has only %s steps, but at least %s are required", recipeId.toString(), numberOfSteps, 3),
                RecipeErrorCodes.RECIPE_HAS_NOT_ENOUGH_STEPS.toString());

    }

    public RecipeHasNotEnoughStepsException(UUID recipeId, Integer numberOfSteps, Throwable cause) {
        super(String.format("Recipe %s has only %s steps, but at least %s are required", recipeId.toString(), numberOfSteps, 3),
                RecipeErrorCodes.RECIPE_HAS_NOT_ENOUGH_STEPS.toString(),
                cause);
    }
}
