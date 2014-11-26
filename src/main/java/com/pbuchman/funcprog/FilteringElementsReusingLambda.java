package com.pbuchman.funcprog;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringElementsReusingLambda {

    /**
     * Example of filtering list elements - allows to pass any predicate as parameter.
     *
     * @param list      to be filtered
     * @param predicate used to filter elements
     * @return list containing only elements filtered by the given predicate
     */
    public List<String> functionalWithPredicate(List<String> list, Predicate<String> predicate) {
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    /**
     * Exercise 2.
     *
     * Method should return list of numbers that are selected by a given predicate.
     */
    public List<Integer> getMatchingNumbers(List<String> list, Predicate<Integer> predicate) {
        throw new UnsupportedOperationException();
    }

}
