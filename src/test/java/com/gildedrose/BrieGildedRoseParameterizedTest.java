package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BrieGildedRoseParameterizedTest  extends AbstractGildedRoseParameterizedTest{

    @ParameterizedTest
    @DisplayName("Test aged brie behaviour")
    @MethodSource("brieItemProvider")
    void testBrieItemBehaviour(Parameterized parameterized) {
        assertSingleItem(parameterized.updateDays, parameterized.actual, parameterized.expected[0]);
    }

    private static Stream<Arguments> brieItemProvider() {
        final String defaultName = "Aged Brie";
        return Stream.of(
                Arguments.of(
                        new Parameterized(
                                defaultName, 20, 20,
                                defaultName, 19, 21,
                                1,
                                "Test should increase quality before selldate")),

                Arguments.of(
                        new Parameterized(
                                defaultName, 0, 20,
                                defaultName, -1, 22,
                                1,
                                "Test should increase quality twice as fast after selldate")),

                Arguments.of(
                        new Parameterized(
                                defaultName, 1, 50,
                                defaultName, 0, 50,
                                1,
                                "Test should not increase quality above fifty before selldate")),

                Arguments.of(
                        new Parameterized(
                                defaultName, 0, 50,
                                defaultName, -1, 50,
                                1,
                                "Test should not increase quality above fifty after selldate")));
    }
}
