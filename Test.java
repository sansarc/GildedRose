public class Test {
    public static void main(String[] args) {
        Item[] items = new Item[] {
            new AgedBrieItem("Aged Brie", 0, 0),
            new AgedBrieItem("Aged Brie", 2, 50), 
            new Item("Elixir of the Mongoose", 5, 7),
            new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80),
            new SulfurasItem("Sulfuras, Hand of Ragnaros", -1, 80),
            new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 10, 20),
            new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 5, 20),
            new ConjuredItem("Conjured Mana Cake", 3, 6),
            new ConjuredItem("Conjured Mana Cake", 0, 6) 
        };

        GildedRose gildedRose = new GildedRose(items);

        int days = 2;
        if (args.length > 0)
            days = Integer.parseInt(args[0]) + 1;

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            gildedRose.print(); 
            gildedRose.updateQuality();
        }
    }
}
