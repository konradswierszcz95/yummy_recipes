package pl.konrad.swierszcz.model.id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.UUID;

public class RecipeId extends DomainIdentity<UUID> {

    private RecipeId() {super();}

    private RecipeId(UUID id) {
        super(id);
    }

    public static RecipeId of(UUID uuid) {
        return new RecipeId(uuid);
    }

    @JsonCreator
    public static RecipeId of(String uuid) {
        return new RecipeId(UUID.fromString(uuid));
    }

    @Override
    @JsonGetter("recipeId")
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
