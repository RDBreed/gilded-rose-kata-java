package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ConjuredGildedRoseParameterizedTest extends AbstractGildedRoseParameterizedTest {

    @ParameterizedTest
    @DisplayName("Test conjured behaviour")
    @MethodSource("conjuredItemProvider")
    void testConjuredItemBehaviour(Parameterized parameterized) {
        assertSingleItem(parameterized.updateDays, parameterized.actual, parameterized.expected[0]);
    }

    private static Stream<Arguments> conjuredItemProvider() {
        final String defaultName = "Conjured Mana Cake";
        return Stream.of(
                Arguments.of(
                        new Parameterized(
                                defaultName, 20, 20,
                                defaultName, 19, 18,
                                1,
                                "Test should decrease quality twice as fast before selldate")
                ),
                Arguments.of(
                        new Parameterized(
                                defaultName, 20, 20,
                                defaultName, 18, 16,
                                2,
                                "Test should decrease quality twice as fast before selldate")
                ),
                Arguments.of(
                        new Parameterized(
                                defaultName, 0, 20,
                                defaultName, -1, 16,
                                1,
                                "Test should decrease quality twice as fast (=4x) after selldate")),

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
                                "Test should not decrease quality below zero after selldate")),

                Arguments.of(
                        new Parameterized(
                                defaultName, 20, 52,
                                defaultName, 19, 50,
                                1,
                                "Test item should never have a quality > 50"))
        );
    }
}
