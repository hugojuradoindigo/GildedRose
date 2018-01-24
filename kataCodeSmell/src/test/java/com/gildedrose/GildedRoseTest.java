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
    
    @Test
    public void qualityOfAnItemIsNeverNegative() {
        Item[] items = new Item[] { 
                new Item("fixme", -1, 0) };
        
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        Item item = app.items[0];
        
        assertEquals(0, item.quality);
        assertEquals(-2, item.sellIn);
    }
    
    @Test
    public void agedBrieActuallyIncreaseInQualityTheOlderItGets() {
        Item[] items = new Item[] { 
                new Item("Aged Brie", 1, 4),
                new Item("Aged Brie", -1, 4)};
        
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        Item item = app.items[0];
        
        assertEquals("Aged Brie", item.name);
        assertEquals(0, item.sellIn);
        assertEquals(5, item.quality);
        
        Item item1 = app.items[1];
        
        assertEquals("Aged Brie", item1.name);
        assertEquals(-2, item1.sellIn);
        assertEquals(6, item1.quality);
    }
    
}
