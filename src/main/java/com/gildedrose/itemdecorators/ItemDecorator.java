package com.gildedrose.itemdecorators;

import com.gildedrose.Item;

public abstract class ItemDecorator extends Item {
    private static final int MAXIMAL_DEFAULT_QUALITY = 50;
    private static final int MINIMAL_QUALITY = 0;
    private static final int SELL_DATE = 0;

    private final Item item;

    public ItemDecorator(Item item) {
        super(item.name, item.sellIn, item.quality);
        this.item = item;
    }

    public abstract void update();

    public int getSellIn() {
        return item.sellIn;
    }

    void decreaseQuality() {
        item.quality = item.quality - 1;
    }

    void setQualityToMinimalQuality() {
        item.quality = MINIMAL_QUALITY;
    }

    void increaseQuality() {
        item.quality = item.quality + 1;
    }

    void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    boolean isSellInLowerThanSellDate() {
        return item.sellIn < SELL_DATE;
    }

    boolean isQualityLowerThanMaximalQuality() {
        return item.quality < MAXIMAL_DEFAULT_QUALITY;
    }

    boolean isQualityHigherThanMinimalQuality() {
        return item.quality > MINIMAL_QUALITY;
    }
}
