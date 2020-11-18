package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testShouldUpdateQualityBeforeSellDate() {
        final String name = "foo";
        Item[] items = new Item[] { new Item(name, 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(0, firstItem.sellIn);
        assertEquals(0, firstItem.quality);
    }

    @Test
    void testShouldUpdateQualityOfItemIsNeverNegative() {
        final String name = "foo";
        Item[] items = new Item[] { new Item(name, 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(-1, firstItem.sellIn);
        assertEquals(0, firstItem.quality);
    }

    @Test
    void testShouldUpdateQualityTwiceAsFastOfItem() {
        final String name = "foo";
        Item[] items = new Item[] { new Item(name, -1, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(-2, firstItem.sellIn);
        assertEquals(2, firstItem.quality);
    }

    @Disabled("Unsure how this requirement should be")
    @Test
    void testShouldNotUpdateQualityTooHigh() {
        final String name = "foo";
        Item[] items = new Item[] { new Item(name, 1, 51) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(0, firstItem.sellIn);
        assertEquals(50, firstItem.quality);
    }

    @Test
    void testShouldUpdateIncreaseQualityOfAgedBrie() {
        final String name = "Aged Brie";
        Item[] items = new Item[] { new Item(name, 1, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(0, firstItem.sellIn);
        assertEquals(5, firstItem.quality);
    }

    @Test
    void testShouldUpdateIncreaseQualityTwiceOfAgedBrie() {
        final String name = "Aged Brie";
        Item[] items = new Item[] { new Item(name, -1, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(-2, firstItem.sellIn);
        assertEquals(6, firstItem.quality);
    }

    @Test
    void testShouldUpdateIncreaseAgedBrieNotMoreThanFifty() {
        final String name = "Aged Brie";
        Item[] items = new Item[] { new Item(name, -1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(-2, firstItem.sellIn);
        assertEquals(50, firstItem.quality);
    }


    @Test
    void testShouldHaveImmutableSulfuras() {
        final String name = "Sulfuras, Hand of Ragnaros";
        Item[] items = new Item[] { new Item(name, 1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(1, firstItem.sellIn);
        assertEquals(80, firstItem.quality);
    }

    @Disabled("Unsure how this requirement should be")
    @Test
    void testSulfurasShouldHaveQualityEighty() {
        final String name = "Sulfuras, Hand of Ragnaros";
        Item[] items = new Item[] { new Item(name, 1, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(1, firstItem.sellIn);
        assertEquals(80, firstItem.quality);
    }

    @Test
    void testShouldUpdateQualityBackstagePass() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, 11, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(10, firstItem.sellIn);
        assertEquals(2, firstItem.quality);
    }

    @Test
    void testShouldUpdateQualityBackstagePassTwice() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, 10, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(9, firstItem.sellIn);
        assertEquals(3, firstItem.quality);
    }

    @Test
    void testShouldUpdateQualityBackstagePassWithThree() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, 5, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(4, firstItem.sellIn);
        assertEquals(4, firstItem.quality);
    }

    @Test
    void testShouldUpdateQualityBackstagePassAfterDateToZero() {
        final String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(-1, firstItem.sellIn);
        assertEquals(0, firstItem.quality);
    }

    @Disabled("Feature is not added yet")
    @Test
    void testShouldUpdateQualityTwiceAsFastAsDefaultItemForConjured() {
        final String name = "Conjured Mana Cake";
        Item[] items = new Item[] { new Item(name, 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(0, firstItem.sellIn);
        assertEquals(48, firstItem.quality);
    }

    @Disabled("Feature is not added yet")
    @Test
    void testShouldUpdateQualityTwiceAsFastAsDefaultItemAfterSellDateForConjured() {
        final String name = "Conjured Mana Cake";
        Item[] items = new Item[] { new Item(name, 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        final Item firstItem = app.items[0];
        assertEquals(name, firstItem.name);
        assertEquals(-1, firstItem.sellIn);
        assertEquals(46, firstItem.quality);
    }

}
