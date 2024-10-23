public abstract class ConjuredItem extends SpecialItem {
    ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    void updateQuality() {}
    
}
