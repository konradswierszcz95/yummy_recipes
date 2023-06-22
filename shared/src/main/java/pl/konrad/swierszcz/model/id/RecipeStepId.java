package pl.konrad.swierszcz.model.id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.UUID;

public class RecipeStepId extends DomainIdentity<UUID> {
    private RecipeStepId() {super();}

    private RecipeStepId(UUID id) {
        super(id);
    }

    public static RecipeStepId of(UUID uuid) {
        return new RecipeStepId(uuid);
    }

    @JsonCreator
    public static RecipeStepId of(String uuid) {
        return new RecipeStepId(UUID.fromString(uuid));
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
