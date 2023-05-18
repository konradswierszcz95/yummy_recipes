package pl.konrad.swierszcz.model.id;

import lombok.Data;

import java.util.UUID;

@Data(staticConstructor = "of")
public class UserId implements DomainIdentity {

   private final UUID id;

    @Override
    public UUID value() {
        return this.id;
    }

    @Override
    public String valueAsString() {
        return this.id.toString();
    }
}
