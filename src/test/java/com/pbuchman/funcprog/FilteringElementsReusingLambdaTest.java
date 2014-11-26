package com.pbuchman.funcprog;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

public class FilteringElementsReusingLambdaTest {

    private final FilteringElementsReusingLambda filtering = new FilteringElementsReusingLambda();

    private final List<String> teams = asList("Enigma", "Speedster", "Signum", "Mokka", "Cascada", "Monza", "Ampera",
            "AA", "Frontera");

    private final Function<String, Predicate<String>> startsWithChar = (String letter) -> {
        Predicate<String> checkStartsWith = name -> name.startsWith(letter);
        return checkStartsWith;
    };

    private final Function<String, Predicate<String>> endsWithChar = (String letter) -> {
        Predicate<String> checkStartsWith = name -> name.endsWith(letter);
        return checkStartsWith;
    };

    @Test
    public void shouldReturnStartingWithM() {
        List<String> startingWithM = filtering.functionalWithPredicate(teams, startsWithChar.apply("M"));

        assertThat(startingWithM).hasSize(2);
        assertThat(startingWithM).isEqualTo(asList("Mokka", "Monza"));
    }

    @Test
    public void shouldReturnEndingWithR() {
        List<String> endingWithR = filtering.functionalWithPredicate(teams, endsWithChar.apply("r"));

        assertThat(endingWithR).isEqualTo(asList("Speedster"));
    }
}