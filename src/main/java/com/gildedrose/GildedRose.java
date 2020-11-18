package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFARAS = "Sulfuras, Hand of Ragnaros";
    private static final int MAXIMAL_DEFAULT_QUALITY = 50;
    private static final int MINIMAL_QUALITY = 0;
    private static final int SELL_DATE = 0;
    private static final int BACKSTAGE_PASSES_SELL_DATE_FIRST_UPGRADE = 11;
    private static final int BACKSTAGE_PASSES_SELL_DATE_SECOND_UPGRADE = 6;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = MINIMAL_QUALITY; i < items.length; i++) {
            Item actualItem = items[i];
            if (!isAgedBrie(actualItem)
                    && !isBackStagePasses(actualItem)) {
                if (isQualityHigherThanMinimalQuality(actualItem)) {
                    if (!isSulfaras(actualItem)) {
                        actualItem.quality = actualItem.quality - 1;
                    }
                }
            } else {
                if (isQualityLowerThanMaximalQuality(actualItem)) {
                    actualItem.quality = actualItem.quality + 1;

                    if (isBackStagePasses(actualItem)) {
                        if (actualItem.sellIn < BACKSTAGE_PASSES_SELL_DATE_FIRST_UPGRADE) {
                            if (isQualityLowerThanMaximalQuality(actualItem)) {
                                actualItem.quality = actualItem.quality + 1;
                            }
                        }

                        if (actualItem.sellIn < BACKSTAGE_PASSES_SELL_DATE_SECOND_UPGRADE) {
                            if (isQualityLowerThanMaximalQuality(actualItem)) {
                                actualItem.quality = actualItem.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!isSulfaras(actualItem)) {
                actualItem.sellIn = actualItem.sellIn - 1;
            }

            if (isSellInLowerThanSellDate(actualItem)) {
                if (!isAgedBrie(actualItem)) {
                    if (!isBackStagePasses(actualItem)) {
                        if (isQualityHigherThanMinimalQuality(actualItem)) {
                            if (!isSulfaras(actualItem)) {
                                actualItem.quality = actualItem.quality - 1;
                            }
                        }
                    } else {
                        actualItem.quality = MINIMAL_QUALITY;
                    }
                } else {
                    if (isQualityLowerThanMaximalQuality(actualItem)) {
                        actualItem.quality = actualItem.quality + 1;
                    }
                }
            }
        }
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