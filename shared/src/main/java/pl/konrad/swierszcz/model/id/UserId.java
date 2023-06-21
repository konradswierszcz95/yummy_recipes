package pl.konrad.swierszcz.model.id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.UUID;

public class UserId extends DomainIdentity<UUID> {

    private UserId() {super();}

    private UserId(UUID id) {
        super(id);
    }

    public static UserId of(UUID uuid) {
        return new UserId(uuid);
    }

    @JsonCreator
    public static UserId of(String uuid) {
        return new UserId(UUID.fromString(uuid));
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
        if(obj != null && !(obj instanceof UserId))
            return false;
        return super.equals(obj);
    }
}
