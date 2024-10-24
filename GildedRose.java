class GildedRose {
    Item[] items;

    // I'm not supposed to modify the Item class
    final static int MAX_QUALITY = 50; 
    final static int MIN_QUALITY = 0, MIN_SELLIN = 0;
    
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void print() {
        for (Item item : items) 
            System.out.println(item);
    }

    public void updateSellIn(Item item) {
        if (!(item instanceof SulfurasItem))
            item.sellIn--;
    }

    public static void increaseQuality(Item item) {
        increaseQuality(item, 1);
    }

    public static void increaseQuality(Item item, int value) {
        item.quality = Math.min(MAX_QUALITY, item.quality + value);
    }    

    public static void dropQuality(Item item, int value) {
        item.quality = Math.max(MIN_QUALITY, item.quality - value);
    }

    public static void dropQuality(Item item) {
        dropQuality(item, 1);
    }

    public int checkSellIn(Item item) {
        return (item.sellIn < MIN_SELLIN) ? 2 : 1;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateSellIn(item);
            if (item instanceof SpecialItem) 
                ((SpecialItem)item).updateSpecialItemQuality();
            else 
                dropQuality(item, checkSellIn(item));
        }
    }
}