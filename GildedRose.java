class GildedRose {
    Item[] items;

    // I'll add it here since I'm not supposed to modify the Item class
    final static int MAX_QUALITY = 50; 
    final static int MIN_QUALITY = 0, MIN_SELLIN = 0;
    
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateSellIn(Item item) {
        if (!(item instanceof SulfurasItem))
            item.sellIn--;
    }

    public static void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY)
            item.quality++;
    }    

    public static void dropQuality(Item item) {
        if (item.sellIn > MIN_QUALITY)
            item.quality--;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateSellIn(item);
            if (item instanceof SpecialItem) 
                ((SpecialItem)item).dropSpecialItemQuality();
            else 
                dropQuality(item);
        }
    }
}