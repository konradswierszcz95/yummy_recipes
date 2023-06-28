package pl.konrad.swierszcz.model.id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.UUID;

public class IngredientConverterId extends DomainIdentity<UUID> {

    private IngredientConverterId() {super();}

    private IngredientConverterId(UUID id) {
        super(id);
    }

    public static IngredientConverterId of(UUID uuid) {
        return new IngredientConverterId(uuid);
    }

    @JsonCreator
    public static IngredientConverterId of(String uuid) {
        return new IngredientConverterId(UUID.fromString(uuid));
    }

    @Override
    @JsonGetter("ingredientConverterId")
    public String jsonRootGetter() {
        return valueAsString();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if(obj != null && !(obj instanceof IngredientConverterId))
            return false;
        return super.equals(obj);
    }
}
