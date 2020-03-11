package fr.slickteam.hostel;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

public class HostelTest {

    @Test
    public void updateQuality() throws Exception {

        CombinationApprovals.verifyAllCombinations(this::doUpdateQuality,
                new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros", "Sulfuras, Hand of Ragnaros"},
                new Integer[]{-1, 0, 1, 5, 6, 10, 11, 50},
                new Integer[]{0, 1, 49, 50}
        );
    }


    private String doUpdateQuality(String itemName, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(itemName, sellIn, quality)};
        Hostel app = new Hostel(items);
        app.updateQuality();
        return app.items[0].toString();
    }

}
