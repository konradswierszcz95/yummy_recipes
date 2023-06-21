package pl.konrad.swierszcz.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import pl.konrad.swierszcz.model.id.RecipeId;
import pl.konrad.swierszcz.model.id.UserId;

@Builder(builderMethodName = "aRecipe", setterPrefix = "with", toBuilder = true)
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {
    @EmbeddedId
    RecipeId id;
    @NotBlank
    String name;
    @NotNull
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "authorId"))
    UserId author;
}
