package com.gildedrose.itemdecorators;

import com.gildedrose.Item;

public class DecoratorFactory {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFARAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

    private DecoratorFactory(){
        //not needed since this is a factory (with static methods)
    }

    public static ItemDecorator createDecorator(Item item){
        if (isSulfaras(item)) {
            return new SulfarasDecorator(item);
        } else if (isAgedBrie(item)) {
            return new AgedBrieDecorator(item);
        } else if (isBackStagePasses(item)) {
            return new BackstagePassesDecorator(item);
        } else if (isConjured(item)) {
            return new ConjuredDecorator(item);
        } else {
            return new DefaultItemDecorator(item);
        }
    }

    private static boolean isSulfaras(Item actualItem) {
        return actualItem.name.equals(SULFARAS);
    }

    private static boolean isBackStagePasses(Item actualItem) {
        return actualItem.name.equals(BACKSTAGE_PASSES);
    }

    private static boolean isAgedBrie(Item actualItem) {
        return actualItem.name.equals(AGED_BRIE);
    }

    private static boolean isConjured(Item item){
        return item.name.equals(CONJURED);
    }
}
