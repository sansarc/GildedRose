package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}

class AgedBrieItem extends Item {
    AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
}

class BackstagePassesItem extends Item {
    BackstagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
}

class SulfurasItem extends Item {
    SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
}