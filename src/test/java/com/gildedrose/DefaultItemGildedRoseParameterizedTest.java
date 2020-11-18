package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DefaultItemGildedRoseParameterizedTest extends AbstractGildedRoseParameterizedTest{

    @ParameterizedTest
    @DisplayName("Test default item behaviour")
    @MethodSource("defaultItemProvider")
    void testDefaultItemBehaviour(Parameterized parameterized) {
        assertSingleItem(parameterized.updateDays, parameterized.actual, parameterized.expected[0]);
    }

    private static Stream<Arguments> defaultItemProvider() {
        final String defaultName = "foo";
        return Stream.of(
                Arguments.of(
                        new Parameterized(
                                defaultName, 20, 20,
                                defaultName, 19, 19,
                                1,
                                "Test should decrease quality before selldate")
                ),
                Arguments.of(
                        new Parameterized(
                                defaultName, 20, 20,
                                defaultName, 18, 18,
                                2,
                                "Test should decrease quality before selldate")
                ),
                Arguments.of(
                        new Parameterized(
                                defaultName, 0, 20,
                                defaultName, -1, 18,
                                1,
                                "Test should decrease quality twice as fast after selldate")),

                Arguments.of(
                        new Parameterized(
                                defaultName, 1, 0,
                                defaultName, 0, 0,
                                1,
                                "Test should not decrease quality below zero before selldate")),

                Arguments.of(
                        new Parameterized(
                                defaultName, 0, 0,
                                defaultName, -1, 0,
                                1,
                                "Test should not decrease quality below zero after selldate"))
        );
    }
}
