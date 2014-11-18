package com.pbuchman.funcprog;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Piotr Buchman <kontakt@pbuchman.com>
 */
public class LazyEvaluation {
    public static void main(String[] args) {

        final List<String> ampera =
                Arrays.asList("Michal", "Adam", "Kasia", "Maciek", "Piotrek", "Michal", "Kuba", "Mirek", "Marek");
        // v2.0
        ampera.forEach(new Consumer<String>() {
            public void accept(final String name) {
                System.out.println(name);
            }
        });
        // v2.1
        ampera.forEach((final String name) -> System.out.println(name));
        // v2.2
        ampera.forEach((name) -> System.out.println(name));
        // v2.3
        ampera.forEach(name -> System.out.println(name));
        // v2.4
        ampera.forEach(System.out::println);

    }
}
