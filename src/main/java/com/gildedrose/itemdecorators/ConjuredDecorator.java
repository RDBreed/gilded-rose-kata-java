package com.gildedrose.itemdecorators;

import com.gildedrose.Item;

public class ConjuredDecorator extends ItemDecorator {
    public ConjuredDecorator(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();

        if (isQualityHigherThanMinimalQuality()) {
            decreaseQuality();
            if(isQualityHigherThanMinimalQuality()){
                decreaseQuality();
            }
            if (isSellInLowerThanSellDate() && isQualityHigherThanMinimalQuality()) {
                decreaseQuality();
                if (isQualityHigherThanMinimalQuality()) {
                    decreaseQuality();
                }
            }
        }
    }
}
