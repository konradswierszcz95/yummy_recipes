package pl.konrad.swierszcz.model.id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.MappedSuperclass;
import lombok.ToString;

import java.util.Objects;

@MappedSuperclass
@ToString
@JsonSerialize(using = DomainIdentitySerializer.class)
public abstract class DomainIdentity<T> implements DomainIdentifiable {

    protected T id;

    protected DomainIdentity(){}

    protected DomainIdentity(T id){this.id = id;}

    @Override
    public String valueAsString() {
        return id.toString();
    }

    @Override
    public T value() {
        return id;
    }

    public abstract String jsonRootGetter();

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return this.id == null;
        if(!(obj instanceof DomainIdentity<?> other))
            return false;
        return Objects.equals(id, other.id);
    }
}
