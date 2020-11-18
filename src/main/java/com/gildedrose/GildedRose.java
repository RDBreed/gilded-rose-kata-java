package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFARAS = "Sulfuras, Hand of Ragnaros";
    private static final int MAX_DEFAULT_QUALITY = 50;
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
            if (!actualItem.name.equals(AGED_BRIE)
                    && !actualItem.name.equals(BACKSTAGE_PASSES)) {
                if (actualItem.quality > MINIMAL_QUALITY) {
                    if (!actualItem.name.equals(SULFARAS)) {
                        actualItem.quality = actualItem.quality - 1;
                    }
                }
            } else {
                if (actualItem.quality < MAX_DEFAULT_QUALITY) {
                    actualItem.quality = actualItem.quality + 1;

                    if (actualItem.name.equals(BACKSTAGE_PASSES)) {
                        if (actualItem.sellIn < BACKSTAGE_PASSES_SELL_DATE_FIRST_UPGRADE) {
                            if (actualItem.quality < MAX_DEFAULT_QUALITY) {
                                actualItem.quality = actualItem.quality + 1;
                            }
                        }

                        if (actualItem.sellIn < BACKSTAGE_PASSES_SELL_DATE_SECOND_UPGRADE) {
                            if (actualItem.quality < MAX_DEFAULT_QUALITY) {
                                actualItem.quality = actualItem.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!actualItem.name.equals(SULFARAS)) {
                actualItem.sellIn = actualItem.sellIn - 1;
            }

            if (actualItem.sellIn < SELL_DATE) {
                if (!actualItem.name.equals(AGED_BRIE)) {
                    if (!actualItem.name.equals(BACKSTAGE_PASSES)) {
                        if (actualItem.quality > MINIMAL_QUALITY) {
                            if (!actualItem.name.equals(SULFARAS)) {
                                actualItem.quality = actualItem.quality - 1;
                            }
                        }
                    } else {
                        actualItem.quality = MINIMAL_QUALITY;
                    }
                } else {
                    if (actualItem.quality < MAX_DEFAULT_QUALITY) {
                        actualItem.quality = actualItem.quality + 1;
                    }
                }
            }
        }
    }
}