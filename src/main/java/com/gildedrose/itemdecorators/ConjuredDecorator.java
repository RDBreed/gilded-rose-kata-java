package com.gildedrose.itemdecorators;

import com.gildedrose.Item;

public class ConjuredDecorator extends ItemDecorator {
    public ConjuredDecorator(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        decreaseQuality();
        decreaseQuality();
        if (isSellInLowerThanSellDate()) {
            decreaseQuality();
            decreaseQuality();
        }
    }
}
