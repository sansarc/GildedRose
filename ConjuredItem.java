public class ConjuredItem extends SpecialItem {
    ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void updateSpecialItemQuality() {
        GildedRose.dropQuality(this, 2);
    }
    
}
