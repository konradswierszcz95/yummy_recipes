package pl.konrad.swierszcz.model.id;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DomainIdentity {
    private final UUID id;

    public static DomainIdentity of(UUID id) {
        return new DomainIdentity(id);
    }

    public static DomainIdentity of(String id) {
        return new DomainIdentity(UUID.fromString(id));
    }

    public UUID value() {
        return this.id;
    }

    public String valueAsString() {
        return this.id.toString();
    }
}
