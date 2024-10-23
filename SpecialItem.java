public abstract class SpecialItem extends Item {
    SpecialItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    abstract void dropSpecialItemQuality();
    abstract void increaseSpecialItemQuality();
}

class AgedBrieItem extends SpecialItem {
    AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseSpecialItemQuality() {
        GildedRose.increaseQuality(this);
    }

    @Override
    public void dropSpecialItemQuality() {}
}

class BackstagePassesItem extends SpecialItem {
    private final int SELLIN_BACKSTAGEPASSES_TRIPLE = 5;
    private final int SELLIN_BACKSTAGEPASSES_DOUBLE = 10;

    BackstagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void dropSpecialItemQuality() {
        if (sellIn < 0) 
            quality = 0;        
    }

    @Override
    public void increaseSpecialItemQuality() {
        if (sellIn <= SELLIN_BACKSTAGEPASSES_DOUBLE) 
            quality++;
        if (sellIn <= SELLIN_BACKSTAGEPASSES_TRIPLE) 
            quality++;
    }

}

class SulfurasItem extends SpecialItem {
    private final int LEGENDARY_MAX_QUALITY = 80;

    SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseSpecialItemQuality() {
        quality = LEGENDARY_MAX_QUALITY;
    }

    @Override
    public void dropSpecialItemQuality() { /* Sulfuras doesn't degrade */ }
}