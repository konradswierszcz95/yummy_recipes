package pl.konrad.swierszcz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.konrad.swierszcz.model.id.IngredientId;
import pl.konrad.swierszcz.rest.request.AddIngredientRequest;
import pl.konrad.swierszcz.usecase.AddIngredientUseCase;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private final AddIngredientUseCase addIngredientUseCase;

    @PostMapping("/add")
    public IngredientId addIngredient(@RequestBody @Valid AddIngredientRequest addIngredientRequest) {
        return addIngredientUseCase.execute(addIngredientRequest.toDto());
    }
}
