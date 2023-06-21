package pl.konrad.swierszcz.model.id;

import java.io.Serializable;


public interface DomainIdentifiable<T> extends Serializable {

    String valueAsString();

    T value();
}
