package com.gildedrose;

import com.gildedrose.itemdecorators.DecoratorFactory;
import com.gildedrose.itemdecorators.ItemDecorator;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            final ItemDecorator decorator = DecoratorFactory.createDecorator(item);
            decorator.update();
        }
    }


}