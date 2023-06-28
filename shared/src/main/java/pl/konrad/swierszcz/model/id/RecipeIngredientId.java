package pl.konrad.swierszcz.model.id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.UUID;

public class RecipeIngredientId extends DomainIdentity<UUID> {
    private RecipeIngredientId() {super();}

    private RecipeIngredientId(UUID id) {
        super(id);
    }

    public static RecipeIngredientId of(UUID uuid) {
        return new RecipeIngredientId(uuid);
    }

    @JsonCreator
    public static RecipeIngredientId of(String uuid) {
        return new RecipeIngredientId(UUID.fromString(uuid));
    }

    @Override
    @JsonGetter("recipeIngredientId")
    public String jsonRootGetter() {
        return valueAsString();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if(obj != null && !(obj instanceof RecipeIngredientId))
            return false;
        return super.equals(obj);
    }
}
