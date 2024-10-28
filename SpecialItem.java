

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
        if (sellIn < GildedRose.MIN_SELLIN)
            GildedRose.increaseQuality(this, 2);
        else
            GildedRose.increaseQuality(this);
    }
}

class BackstagePassItem extends SpecialItem {
    private final int SELLIN_BACKSTAGEPASS_TRIPLE = 5;
    private final int SELLIN_BACKSTAGEPASS_DOUBLE = 10;
    private final int TRIPLE_QUALITY_INCREASE = 3;
    private final int DOUBLE_QUALITY_INCREASE = 2;


    BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    private int checkSellIn() {
        if (sellIn < SELLIN_BACKSTAGEPASS_TRIPLE) 
            return TRIPLE_QUALITY_INCREASE;
        else if (sellIn < SELLIN_BACKSTAGEPASS_DOUBLE) 
            return DOUBLE_QUALITY_INCREASE;
        else
            return 1;
    }

    @Override
    public void updateSpecialItemQuality() {
        if (sellIn < 0) 
            quality = 0;        
        else {
            int amountToIncrease = checkSellIn();
            GildedRose.increaseQuality(this, amountToIncrease);
        }
    }

}

class SulfurasItem extends SpecialItem {
    SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateSpecialItemQuality() {} // Sulfuras doesn't degrade 
}