package pl.konrad.swierszcz.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.konrad.swierszcz.dto.IngredientDto;
import pl.konrad.swierszcz.model.Ingredient;
import pl.konrad.swierszcz.model.id.IngredientId;
import pl.konrad.swierszcz.repository.IngredientRepository;
import pl.konrad.swierszcz.usecase.AddIngredientUseCase;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class AddIngredientUseCaseImpl implements AddIngredientUseCase {

    private final IngredientRepository ingredientRepository;

    @Override
    public IngredientId execute(IngredientDto ingredientDto) {
        IngredientId id = IngredientId.of(UUID.randomUUID());
        Ingredient newIngredient = Ingredient.fromDto(ingredientDto, id);
        return ingredientRepository.save(newIngredient).getId();
    }
}
