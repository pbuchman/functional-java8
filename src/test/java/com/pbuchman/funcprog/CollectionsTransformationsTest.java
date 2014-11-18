package com.pbuchman.funcprog;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class CollectionsTransformationsTest {

    private final List<String> ampera =
            Arrays.asList("Michal", "Adam", "Kasia", "Maciek", "Piotrek", "Michal", "Kuba", "Miroslaw", "Marek");

    private final List<String> ucAmpera =
            Arrays.asList("MICHAL", "ADAM", "KASIA", "MACIEK", "PIOTREK", "MICHAL", "KUBA", "MIROSLAW", "MAREK");

    private final CollectionsTransformations transformations = new CollectionsTransformations();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGetStartingWithKIter() throws Exception {
        List<String> startingWithK = transformations.getStartingWithKIter(ampera);

        assertStrartingWithK(startingWithK);
    }

    @Test
    public void testGetStartingWithK() throws Exception {
        List<String> startingWithK = transformations.getStartingWithK(ampera);

        assertStrartingWithK(startingWithK);
    }

    private void assertStrartingWithK(List<String> startingWithK) {
        assertThat(startingWithK).hasSize(2);
        assertThat(startingWithK).isEqualTo(Arrays.asList("Kasia", "Kuba"));
    }


    @Test
    public void testGetUppercasedIter() throws Exception {
        List<String> uppercased = transformations.getUppercasedIter(ampera);

        assertUppercased(uppercased);
    }

    @Test
    public void testGetUppercased() throws Exception {
        List<String> uppercased = transformations.getUppercased(ampera);

        assertUppercased(uppercased);

    }

    private void assertUppercased(List<String> uppercased) {
        assertThat(uppercased).hasSize(9);
        assertThat(uppercased).isEqualTo(ucAmpera);
    }

    @Test
    public void testGetCharsCount() throws Exception {
        int count = transformations.getCharsCount(ampera);

        assertThat(count).isEqualTo(51);
    }

    @Test
    public void testGetLongestName() throws Exception {
        String longest = transformations.getLongestName(ampera);

        assertThat(longest).isEqualTo("Miroslaw");
    }

    @Test
    public void testGetLongestNameWithEmptyList() throws Exception {
        thrown.expect(IllegalArgumentException.class);

        transformations.getLongestName(Collections.EMPTY_LIST);
    }
}