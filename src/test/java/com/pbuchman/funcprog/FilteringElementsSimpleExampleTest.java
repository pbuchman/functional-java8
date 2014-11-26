package com.pbuchman.funcprog;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FilteringElementsSimpleExampleTest {

    private final FilteringElementsSimpleExample filtering = new FilteringElementsSimpleExample();

    private final List<String> ampera = asList("Michal", "Adam", "Kasia", "Maciek", "Piotrek", "Michal", "Kuba",
            "Miroslaw", "Marek");

    @Test
    public void imperativeShouldReturnOnlyStartingWithK() {
        List<String> startingWithK = filtering.imperativeFiltering(ampera);

        assertThat(startingWithK).hasSize(2);
        assertThat(startingWithK).isEqualTo(Arrays.asList("Kasia", "Kuba"));
    }

    @Test
    public void functionalShouldReturnOnlyStartingWithK() {
        List<String> startingWithK = filtering.functionalFiltering(ampera);

        assertThat(startingWithK).hasSize(2);
        assertThat(startingWithK).isEqualTo(Arrays.asList("Kasia", "Kuba"));
    }
}