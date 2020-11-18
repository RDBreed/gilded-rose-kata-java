package com.gildedrose.itemdecorators;

import com.gildedrose.Item;

/**
 * Decorator to wrap around an item to perform an proper update.
 */
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

    /**
     * Decrease quality by 1 when quality is not lower than the minimal quality
     */
    void decreaseQuality() {
        item.quality = Math.max(item.quality - 1, MINIMAL_QUALITY);
    }

    void setQualityToMinimalQuality() {
        item.quality = MINIMAL_QUALITY;
    }

    /**
     * Increase quality by 1 when quality is not higher than the maximal quality
     */
    void increaseQuality() {
        item.quality = Math.min(item.quality + 1, MAXIMAL_DEFAULT_QUALITY);
    }

    void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    boolean isSellInLowerThanSellDate() {
        return item.sellIn < SELL_DATE;
    }

}
