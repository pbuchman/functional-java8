package com.pbuchman.funcprog;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.text.MessageFormat.format;

/**
 * @author Piotr Buchman <kontakt@pbuchman.com>
 */
public class LazyEvaluation {

    private static int length(final String name) {
        System.out.println(format("Getting length for {0}", name));
        return name.length();
    }

    private static String toUpperCase(final String name) {
        System.out.println(format("Converting to UC: {0}", name));
        return name.toUpperCase();
    }

    public static void main(String[] args) {
        final List<String> ampera =
                Arrays.asList("Michal", "Adam", "Kasia", "Maciek", "Piotrek", "Michal", "Kuba", "Mirek", "Marek");

        Stream<String> namesWith5Letters =
                ampera.stream()
                        .filter(name -> length(name) == 5)
                        .map(name -> toUpperCase(name));

        System.out.println("Stream created, filtered, mapped...");
        System.out.println("Ready to call findFirst...");

        System.out.println(namesWith5Letters.findFirst().get());
    }
}
