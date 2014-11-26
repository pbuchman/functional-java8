package com.pbuchman.funcprog;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ReducingCollectionsTest {

    private final ReducingCollections reducing = new ReducingCollections();

    private final List<String> teams = asList("Enigma", "Speedster", "Signum", "Mokka", "Cascada", "Monza", "Ampera",
            "AA", "Frontera");

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldGetTotalCharsCount() {
        int count = reducing.getTotalCharsCount(teams);

        assertThat(count).isEqualTo(54);
    }

    @Test
    public void shouldGetLongestName() {
        String longestName = reducing.getLongestName(teams);

        assertThat(longestName).isEqualTo("Speedster");
    }

    @Test
    public void shouldThrowExceptionWhenGettingLongestElementFromEmptyList() {
        thrown.expect(IllegalArgumentException.class);

        reducing.getLongestName(Collections.EMPTY_LIST);
    }

}