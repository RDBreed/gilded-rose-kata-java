package com.gildedrose.itemdecorators;

import com.gildedrose.Item;

public class AgedBrieDecorator extends ItemDecorator {

    public AgedBrieDecorator(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        if (isQualityLowerThanMaximalQuality()) {
            increaseQuality();
            if (isSellInLowerThanSellDate() && isQualityLowerThanMaximalQuality()) {
                increaseQuality();
            }
        }
    }
}
