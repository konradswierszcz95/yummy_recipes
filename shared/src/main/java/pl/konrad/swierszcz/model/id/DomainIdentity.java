package pl.konrad.swierszcz.model.id;

import java.util.UUID;


public interface DomainIdentity {

    UUID value();

    String valueAsString();
}
