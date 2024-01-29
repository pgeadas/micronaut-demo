package org.example

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.serde.ObjectMapper
import io.micronaut.serde.annotation.Serdeable
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification
import jakarta.inject.Inject
import org.example.other.NoteKind

@MicronautTest
class DemoSpec extends Specification {

    @Inject
    EmbeddedApplication<?> application

    void 'test it works'() {
        expect:
        application.running
    }

    @Inject
    ObjectMapper objectMapper

    void "NoteKind is render as lowercase when serialized as JSON"() {
        given:
        MockPojo pojo = new MockPojo(kind: NoteKind.TRIX)

        expect:
        objectMapper.writeValueAsString(pojo) == '{"kind":"trix"}'
    }

    @Serdeable
    static class MockPojo {
        NoteKind kind
    }

}
