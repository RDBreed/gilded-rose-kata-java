package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SulfarasGildedRoseParameterizedTest  extends AbstractGildedRoseParameterizedTest {

    @ParameterizedTest
    @DisplayName("Test sulfuras behaviour")
    @MethodSource("sulfurasItemProvider")
    void testSulfurasItemBehaviour(Parameterized parameterized) {
        assertSingleItem(parameterized.updateDays, parameterized.actual, parameterized.expected[0]);
    }

    private static Stream<Arguments> sulfurasItemProvider() {
        final String defaultName = "Sulfuras, Hand of Ragnaros";
        return Stream.of(
                Arguments.of(
                        new Parameterized(
                                defaultName, 20, 80,
                                defaultName, 20, 80,
                                1,
                                "Test (immutable) sulfuras should never mutate quality before selldate")),

                Arguments.of(
                        new Parameterized(
                                defaultName, 1, 50,
                                defaultName, 1, 50,
                                1,
                                "Test (immutable) sulfuras should never mutate quality before selldate, even with lower initial value than 80")),

                Arguments.of(
                        new Parameterized(
                                defaultName, 0, 80,
                                defaultName, 0, 80,
                                1,
                                "Test (immutable) sulfuras should never mutate quality after selldate")

                ));
    }

}
