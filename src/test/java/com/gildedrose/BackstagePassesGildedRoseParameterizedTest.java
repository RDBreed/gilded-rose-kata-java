package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BackstagePassesGildedRoseParameterizedTest extends AbstractGildedRoseParameterizedTest {

    @ParameterizedTest
    @DisplayName("Test backstage pass behaviour")
    @MethodSource("backstagePassItemProvider")
    void testBackstagePassItemBehaviour(Parameterized parameterized) {
        assertSingleItem(parameterized.updateDays, parameterized.actual, parameterized.expected[0]);
    }

    private static Stream<Arguments> backstagePassItemProvider() {
        final String defaultName = "Backstage passes to a TAFKAL80ETC concert";
        return Stream.of(
                Arguments.of(
                        new Parameterized(
                                defaultName, 20, 20,
                                defaultName, 19, 21,
                                1,
                                "Test should decrease quality by one with > 10 selldays")),

                Arguments.of(
                        new Parameterized(
                                defaultName, 10, 20,
                                defaultName, 9, 22,
                                1,
                                "Test should increase quality twice with <= 10 & > 5 selldays")),

                Arguments.of(
                        new Parameterized(
                                defaultName, 5, 20,
                                defaultName, 4, 23,
                                1,
                                "Test should increase quality by three with <= 5 selldays")),

                Arguments.of(
                        new Parameterized(
                                defaultName, 0, 20,
                                defaultName, -1, 0,
                                1,
                                "Test should have quality zero after selldate")

                ));
    }

}
