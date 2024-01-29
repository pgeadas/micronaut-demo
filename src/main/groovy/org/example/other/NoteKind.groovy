package org.example.other

import com.fasterxml.jackson.annotation.JsonValue
import io.micronaut.serde.annotation.Serdeable

@Serdeable
enum NoteKind {
    TRIX

    @JsonValue
    @Override
    String toString() {
        return this.name().toLowerCase(Locale.ENGLISH)
    }
}
