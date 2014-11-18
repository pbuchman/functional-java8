package com.pbuchman.funcprog;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Piotr Buchman <kontakt@pbuchman.com>
 */
public class CollectionsTransformations {

    public List<String> getStartingWithKIter(List<String> list) {
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

    public List<String> getStartingWithK(List<String> list) {
        return list.stream()
                .filter(item -> item.startsWith("K"))
                .collect(Collectors.toList());
    }

    // final tion<String, Predicate<String>>  startsWithChar = (String letter) -> {
    //     Predicate<String> checkStartsWith =
    //             (String name) -> name.startsWith(letter);
    //     return checkStartsWith;
    // };

    final Function<String, Predicate<String>>  startsWithChar = letter -> name -> name.startsWith(letter);

    public List<String> getStartingWith(String firstChar, List<String> list, Set<String> set) {
        Predicate<String> predicate = item -> item.startsWith(firstChar);

        List<String> listResult = list.stream()
                .filter(predicate)
                .collect(Collectors.toList());

        List<String> setResult = set.stream()
                .filter(startsWithChar.apply(firstChar))
                .collect(Collectors.toList());

        return new ArrayList<String>() { { addAll(listResult); addAll(setResult); } };
    }

    public List<String> getUppercasedIter(List<String> list) {
        List<String> result = new ArrayList<>();

        for (String item: list) {
            result.add(item.toUpperCase());
        }

        return result;
    }

    public List<String> getUppercased(List<String> list) {
       return list.stream()
               .map(item -> item.toUpperCase())
               .collect(Collectors.toList());
    }

    public String getFirstLongerThan(List<String> list, int length) {
        Optional<String> result = list.stream()
                .filter(item -> item.length() > length)
                .findFirst();

        return result.orElseThrow(new Supplier<RuntimeException>() {
            @Override
            public RuntimeException get() {
                return new IllegalArgumentException(("no such long element"));
            }
        });
    }

    public Integer getCharsCount(List<String> list) {
       return list.stream()
               .mapToInt(item -> item.length())
               .sum();
    }

    public String getLongestName(List<String> list) {
        final Optional<String> longest = list.stream()
                        .reduce((name1, name2) ->
                                name1.length() >= name2.length() ? name1 : name2);

        Supplier<IllegalArgumentException> exceptionSupplier = IllegalArgumentException::new;
        return longest.orElseThrow(exceptionSupplier);
    }

    /**
     * Exercise 1 - filtering.
     *
     * Please implement test + this method.
     *
     * Assume list is non empty.
     */
    public Set<String> getStartingWithMUnique(List<String> list) {
        throw new UnsupportedOperationException();
    }

    /**
     * Exercise 2 - filtering.
     *
     * Assume list is non empty.
     */
    public List<String> getWithPrefix(List<String> list, String prefix) {
        throw new UnsupportedOperationException();
    }

    /**
     * Exercise 3 - filtering with predicate.
     *
     * Assume list and set are non empty.
     */
    public Set<Integer> getOnlySelectedNumbers(List<Integer> list, Set<Integer> set, boolean isOdd) {
        throw new UnsupportedOperationException();
    }

    /**
     * Exercise 4 - filtering with optional.
     *
     * Assume list can be empty.
     */
    public String getFirstStartingWith(List<Integer> list) {
        throw new UnsupportedOperationException();
    }

    /**
     * Exercise 5 - reducing with optional.
     *
     * Please take care of cases when list is null and empty.
     */
    public Double getAverageOfNumbers(List<Integer> list) {
        throw new UnsupportedOperationException();
    }

    /**
     * Exercise 6 - joining list.
     *
     * Assume list can be empty - then return "EMPTY LIST".
     */
    public String getConcatenatedList(List<Integer> list) {
        throw new UnsupportedOperationException();
    }

}
