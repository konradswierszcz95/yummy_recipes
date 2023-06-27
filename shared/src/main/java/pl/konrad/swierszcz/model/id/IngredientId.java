package pl.konrad.swierszcz.model.id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.UUID;

public class IngredientId extends DomainIdentity<UUID> {

    private IngredientId() {super();}

    private IngredientId(UUID id) {
        super(id);
    }

    public static IngredientId of(UUID uuid) {
        return new IngredientId(uuid);
    }

    @JsonCreator
    public static IngredientId of(String uuid) {
        return new IngredientId(UUID.fromString(uuid));
    }

    @Override
    @JsonGetter("ingredientId")
    public String jsonRootGetter() {
        return valueAsString();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if(obj != null && !(obj instanceof RecipeId))
            return false;
        return super.equals(obj);
    }
}
