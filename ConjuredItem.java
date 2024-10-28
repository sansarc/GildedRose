public class ConjuredItem extends SpecialItem {
    private int CONJURED_ITEM_QUALITY_DROP = 2;
    private int CONJURED_ITEM_DOUBLE_QUALITY_DROP = 4;

    ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    private int checkSellIn() {
        if (sellIn < GildedRose.MIN_SELLIN)
            return CONJURED_ITEM_DOUBLE_QUALITY_DROP;
        else
            return CONJURED_ITEM_QUALITY_DROP;
    }

    @Override
    void updateSpecialItemQuality() {
        int amountToDrop = checkSellIn();
        GildedRose.dropQuality(this, amountToDrop);
    }
    
}
