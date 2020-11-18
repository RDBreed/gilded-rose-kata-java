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
            if (isSellInLowerThanSellDate()) {
                //whoops, I introduced a bug here; the quality can never be below minimal quality! (see
                // fdcb2ce5f4519a290047a65c3440904c3cf4f5d0 for the introduction of it :) )
                increaseQuality();
            }
        }
    }
}
