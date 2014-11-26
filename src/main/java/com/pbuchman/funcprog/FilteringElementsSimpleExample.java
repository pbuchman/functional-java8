package com.pbuchman.funcprog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringElementsSimpleExample {

    /**
     * Example of filtering list elements - starting with "K" - imperative approach.
     *
     * @param list to be filtered
     * @return list containing only elements that starts with "K"
     */
    public List<String> imperativeFiltering(List<String> list) {
        List<String> result = new ArrayList<>();

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.startsWith("K")) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Example of filtering list elements - starting with "K" - declarative approach.
     *
     * @param list to be filtered
     * @return list containing only elements that starts with "K"
     */
    public List<String> functionalFiltering(List<String> list) {
        return list.stream()
                .filter(item -> item.startsWith("K"))
                .collect(Collectors.toList());
    }

    /**
     * Exercise 1.
     *
     * Method should return list of even numbers.
     */
    public List<Integer> filterEvenNumbers(List<Integer> list) {
        throw new UnsupportedOperationException();
    }



}
