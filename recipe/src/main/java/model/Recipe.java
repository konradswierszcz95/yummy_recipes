package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.model.id.UserId;

@Builder(builderMethodName = "aRecipe", setterPrefix = "with", toBuilder = true)
@Value
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    RecipeId id;
    @NotBlank
    String name;
    @NotNull
    UserId author;
}
