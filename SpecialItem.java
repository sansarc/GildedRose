public abstract class SpecialItem extends Item {
    SpecialItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    abstract void updateSpecialItemQuality();
}

class AgedBrieItem extends SpecialItem {
    AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateSpecialItemQuality() {
        GildedRose.increaseQuality(this);
    }
}

class BackstagePassItem extends SpecialItem {
    private final int SELLIN_BACKSTAGEPASS_TRIPLE = 5;
    private final int SELLIN_BACKSTAGEPASS_DOUBLE = 10;

    BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    private int checkSellIn() {
        int value = 1;
        if (sellIn <= SELLIN_BACKSTAGEPASS_DOUBLE) 
            value++;
        if (sellIn <= SELLIN_BACKSTAGEPASS_TRIPLE) 
            value++;
        return value;
    }

    @Override
    public void updateSpecialItemQuality() {
        if (sellIn < 0) 
            quality = 0;        
        else
            GildedRose.increaseQuality(this, checkSellIn());
    }

}

class SulfurasItem extends SpecialItem {
    SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateSpecialItemQuality() {} // Sulfuras doesn't degrade 
}