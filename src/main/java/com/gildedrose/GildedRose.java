package com.gildedrose;

import com.gildedrose.itemdecorators.AgedBrieDecorator;
import com.gildedrose.itemdecorators.BackstagePassesDecorator;
import com.gildedrose.itemdecorators.DefaultItemDecorator;
import com.gildedrose.itemdecorators.SulfarasDecorator;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFARAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (isSulfaras(item)) {
            new SulfarasDecorator(item).update();
        } else if (isAgedBrie(item)) {
            new AgedBrieDecorator(item).update();
        } else if (isBackStagePasses(item)) {
            new BackstagePassesDecorator(item).update();
        } else {
            new DefaultItemDecorator(item).update();
        }
    }

    private boolean isSulfaras(Item actualItem) {
        return actualItem.name.equals(SULFARAS);
    }

    private boolean isBackStagePasses(Item actualItem) {
        return actualItem.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isAgedBrie(Item actualItem) {
        return actualItem.name.equals(AGED_BRIE);
    }
}