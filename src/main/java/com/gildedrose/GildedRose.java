package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFARAS = "Sulfuras, Hand of Ragnaros";
    private static final int MAXIMAL_DEFAULT_QUALITY = 50;
    private static final int MINIMAL_QUALITY = 0;
    private static final int SELL_DATE = 0;
    private static final int BACKSTAGE_PASSES_SELL_DATE_FIRST_UPGRADE = 10;
    private static final int BACKSTAGE_PASSES_SELL_DATE_SECOND_UPGRADE = 5;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (!isSulfaras(item)) {

            decreaseSellIn(item);

            updateQuality(item);
        }
    }

    private void updateQuality(Item item) {
        if (isAgedBrie(item)) {
            updateAgedBrieQuality(item);
        } else if (isBackStagePasses(item)) {
            updateBackStagePassesQuality(item);
        } else {
            updateDefaultItemQuality(item);
        }
    }

    private void updateAgedBrieQuality(Item item) {
        if (isQualityLowerThanMaximalQuality(item)) {
            increaseQuality(item);
            if (isSellInLowerThanSellDate(item)) {
                increaseQuality(item);
            }
        }
    }

    private void updateBackStagePassesQuality(Item item) {
        if (isQualityLowerThanMaximalQuality(item)) {
            increaseQuality(item);

            if (item.sellIn < BACKSTAGE_PASSES_SELL_DATE_FIRST_UPGRADE) {
                increaseQuality(item);
            }

            if (item.sellIn < BACKSTAGE_PASSES_SELL_DATE_SECOND_UPGRADE) {
                increaseQuality(item);
            }

            if (isSellInLowerThanSellDate(item)) {
                setQualityToMinimalQuality(item);
            }
        }
    }

    private void updateDefaultItemQuality(Item item) {
        if (isQualityHigherThanMinimalQuality(item)) {
            decreaseQuality(item);
            if (isSellInLowerThanSellDate(item)) {
                decreaseQuality(item);
            }
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void setQualityToMinimalQuality(Item item) {
        item.quality = MINIMAL_QUALITY;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isSellInLowerThanSellDate(Item actualItem) {
        return actualItem.sellIn < SELL_DATE;
    }

    private boolean isQualityLowerThanMaximalQuality(Item actualItem) {
        return actualItem.quality < MAXIMAL_DEFAULT_QUALITY;
    }

    private boolean isQualityHigherThanMinimalQuality(Item actualItem) {
        return actualItem.quality > MINIMAL_QUALITY;
    }

    private boolean isSulfaras(Item actualItem) {
        return actualItem.name.equals(SULFARAS);
    }

    private boolean isBackStagePasses(Item actualItem) {
        return actualItem.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isAgedBrie(Item actualItem) {
        return actualItem.name.equals(AGED_BRIE);
    }
}