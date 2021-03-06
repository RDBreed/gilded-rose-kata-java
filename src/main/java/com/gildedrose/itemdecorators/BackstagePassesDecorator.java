package com.gildedrose.itemdecorators;

import com.gildedrose.Item;

public class BackstagePassesDecorator extends ItemDecorator {
    private static final int BACKSTAGE_PASSES_SELL_DATE_FIRST_UPGRADE = 10;
    private static final int BACKSTAGE_PASSES_SELL_DATE_SECOND_UPGRADE = 5;

    public BackstagePassesDecorator(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        if (isSellInLowerThanSellDate()) {
            setQualityToMinimalQuality();
        } else {
            increaseQuality();
            if (getSellIn() < BACKSTAGE_PASSES_SELL_DATE_FIRST_UPGRADE) {
                increaseQuality();
            }
            if (getSellIn() < BACKSTAGE_PASSES_SELL_DATE_SECOND_UPGRADE) {
                increaseQuality();
            }
        }
    }
}
