package com.gildedrose;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void decrementsItemsQualityAndSellInBy1() {
        Item[] items = new Item[] { 
                new Item("fixme", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        Item item = app.items[0];
        
        assertEquals("fixme", item.name);
        assertEquals(9, item.sellIn);
        assertEquals(19, item.quality);
    }
    
    @Test
    public void sellByDateHasPassedQualityDegradesTwiceAsFast() {
        Item[] items = new Item[] { 
                new Item("fixme", -1, 20) };
        
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        Item item = app.items[0];
        
        assertEquals("fixme", item.name);
        assertEquals(-2, item.sellIn);
        assertEquals(18, item.quality);
    }
    
    
}
