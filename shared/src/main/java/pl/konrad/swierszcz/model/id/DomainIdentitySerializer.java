package pl.konrad.swierszcz.model.id;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class DomainIdentitySerializer extends JsonSerializer<DomainIdentity<?>> {
    @Override
    public void serialize(DomainIdentity<?> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.valueAsString());
    }
}
