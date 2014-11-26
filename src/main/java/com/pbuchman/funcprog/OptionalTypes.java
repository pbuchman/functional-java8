package com.pbuchman.funcprog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class OptionalTypes {

    /**
     * Example that shows how to simply throw an exception when filtering fails.
     */
    public String findOrThrow(List<String> list, int length) {
        Optional<String> result = list.stream()
                .filter(item -> item.length() > length)
                .findFirst();

        return result.orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException();
            }
        });
    }

    /**
     * Returning default value when no satisfying elements found.
     */
    public String findOrDefault(List<String> list, int length) {
        Optional<String> result = list.stream()
                .filter(item -> item.length() > length)
                .findFirst();

        return result.orElse("no such long element");
    }

}
