package com.pbuchman.funcprog;

import java.util.List;
import java.util.Optional;

public class ReducingCollections {

    /**
     * Example of reducing list - counting chars in list.
     */
    public int getTotalCharsCount(List<String> list) {
        return list.stream()
                .mapToInt(item -> item.length())
                .sum();
    }

    /**
     * Example of reducing list - finding longest element in given list.
     */
    public String getLongestName(List<String> list) {
        final Optional<String> longest = list.stream()
                .reduce((name1, name2) ->
                        name1.length() >= name2.length() ? name1 : name2);

        return longest.orElseThrow(IllegalArgumentException::new);
    }

}
