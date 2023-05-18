package pl.konrad.swierszcz.model.id;

import lombok.Data;

import java.util.UUID;

@Data(staticConstructor = "of")
public class RecipeId implements DomainIdentity {

    private final UUID id;

    public RecipeId(UUID id) {
        this.id = id;
    }

    @Override
    public UUID value() {
        return this.id;
    }

    @Override
    public String valueAsString() {
        return this.id.toString();
    }
}
