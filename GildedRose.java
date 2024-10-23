package com.gildedrose;

class GildedRose {
    Item[] items;
    // I'll add it here since I'm not supposed to modify the Item class
    final int GENERAL_MAX_QUALITY = 50; 
    final int MIN_QUALITY = 0;
    final int LEGENDARY_MAX_QUALITY = 80;
    final int SELLIN_BACKSTAGEPASSES_TRIPLE = 5;
    final int SELLIN_BACKSTAGEPASSES_DOUBLE = 10;
    
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > MIN_QUALITY) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < GENERAL_MAX_QUALITY) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn <= SELLIN_BACKSTAGEPASSES_DOUBLE) {
                            if (item.quality < GENERAL_MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn <= SELLIN_BACKSTAGEPASSES_TRIPLE) {
                            if (item.quality < GENERAL_MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < MIN_QUALITY) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > MIN_QUALITY) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = MIN_QUALITY;
                    }
                } else {
                    if (item.quality < GENERAL_MAX_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}