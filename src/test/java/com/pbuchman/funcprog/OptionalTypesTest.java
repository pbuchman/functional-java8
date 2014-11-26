package com.pbuchman.funcprog;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class OptionalTypesTest {

    private final OptionalTypes optionalTypes = new OptionalTypes();

    private final List<String> teams = asList("Enigma", "Speedster", "Signum", "Mokka", "Cascada", "Monza", "Ampera",
            "AA", "Frontera");

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void findOrThrowShouldThrow() {
        thrown.expect(IllegalArgumentException.class);

        optionalTypes.findOrThrow(Collections.EMPTY_LIST, 7);
    }

    @Test
    public void findOrThrowShouldReturnValue() {
        String longerThan8 = optionalTypes.findOrThrow(teams, 8);

        assertThat(longerThan8).isEqualTo("Speedster");
    }

    @Test
    public void findOrDefaultShouldReturnValue() {
        String longerThan8 = optionalTypes.findOrDefault(teams, 8);

        assertThat(longerThan8).isEqualTo("Speedster");
    }

    @Test
    public void findOrDefaultShouldReturnDefault() {
        String value = optionalTypes.findOrDefault(Collections.EMPTY_LIST, 7);

        assertThat(value).isEqualTo("no such long element");
    }

}