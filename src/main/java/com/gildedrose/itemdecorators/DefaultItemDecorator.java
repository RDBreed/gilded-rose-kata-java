package com.gildedrose.itemdecorators;

import com.gildedrose.Item;

public class DefaultItemDecorator extends ItemDecorator {

    public DefaultItemDecorator(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        decreaseQuality();
        if (isSellInLowerThanSellDate()) {
            decreaseQuality();
        }
    }
}
