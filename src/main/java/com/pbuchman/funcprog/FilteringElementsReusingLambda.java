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

}
