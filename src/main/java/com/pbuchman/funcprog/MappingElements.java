package com.pbuchman.funcprog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MappingElements {

    /**
     * Example of list mapping - imperative approach.
     */
    public List<String> imperativeMapEachElementToUpperCased(List<String> list) {
        List<String> result = new ArrayList<>();

        for (String item : list) {
            result.add(item.toUpperCase());
        }

        return result;
    }

    /**
     * Example of list mapping - functional approach.
     */
    public List<String> functionalMapEachElementToUpperCased(List<String> list) {
        return list.stream()
                .map(item -> item.toUpperCase())
                .collect(Collectors.toList());
    }

}
