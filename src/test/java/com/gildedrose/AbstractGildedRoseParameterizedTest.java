package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Make it possible to do a parameterized run of all item requirements.
 * <p>
 * Why I chose this test configuration?
 * - Because it is quite easy to add another scenario
 * - Each scenario is described properly / matching the described requirements
 * - Abstracting away the repeatability of the tests
 * <p>
 * One disadvantage I found (but not outweighing for me here the pro's):
 * - A specific test case could not be located directly by clicking on it (in IntelliJ); you have to find the related name of the test.
 */
public abstract class AbstractGildedRoseParameterizedTest {

    public static class Parameterized {
        Item[] actual;
        Item[] expected;
        int updateDays;
        String parameterizedName;

        public Parameterized(String actualName, int actualSellIn, int actualQuality, String expectedName, int expectedSellIn,
                             int expectedQuality, int updateDays, String parameterizedName) {
            this.actual = createSingleItemArray(actualName, actualSellIn, actualQuality);
            this.expected = createSingleItemArray(expectedName, expectedSellIn, expectedQuality);
            this.updateDays = updateDays;
            this.parameterizedName = parameterizedName;
        }

        @Override
        public String toString() {
            return parameterizedName;
        }
    }

    protected static Item[] createSingleItemArray(String name, int sellIn, int quality) {
        return new Item[]{new Item(name, sellIn, quality)};
    }

    protected void assertSingleItem(int updateDays, Item[] items, Item expectedItem) {
        GildedRose app = new GildedRose(items);
        for (int day = 0; day < updateDays; day++) {
            app.updateQuality();
        }
        final Item firstItem = app.items[0];
        assertEquals(expectedItem.name, firstItem.name, "name was not equal");
        assertEquals(expectedItem.sellIn, firstItem.sellIn, "sellIn was not equal");
        assertEquals(expectedItem.quality, firstItem.quality, "quality was not equal");
    }
}
