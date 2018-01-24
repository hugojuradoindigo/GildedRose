package com.gildedrose;

class GildedRose<by> {

    private final int MIN_QUALITY = 0;
    private final int MAX_QUALITY = 50;

    public final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!isAgedBrie(item) && !isBackstagePasses(item)) {
                decreaseQuality(item);
            } else {
                increaseQuality(item);
            }

            if (!isSulfuras(item)) {
                decreaseSellIn(item);
            }

            if (sellInPassed(item)) {
                if (!isAgedBrie(item)) {
                    if (!isBackstagePasses(item)) {
                        decreaseQuality(item);
                    } else {
                        setZeroQuality(item);
                    }
                } else {
                    increaseQuality(item);
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            if (!isSulfuras(item)) {
                item.quality--;
            }
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
            
            if (isBackstagePasses(item)) {
                if (isMinorOrEqualTen(item)) {
                    item.quality++;
                }
                if (isMinorOrEqualFive(item)) {
                    item.quality++;
                }
            }
        }
    }

    private void setZeroQuality(Item item) {
        item.quality = 0;
    }
    
    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
    
    private boolean isMinorOrEqualTen(Item item) {
        return item.sellIn <= 10; 
    }
    
    private boolean isMinorOrEqualFive(Item item) {
        return item.sellIn <= 5; 
    }
    
    private boolean sellInPassed(Item item) {
        return item.sellIn < 0;
    }

    public Item getItem(String name) {
        Item itemResult = null;
        
        for (Item item : items) {
            if (item.name.equalsIgnoreCase(name)) {
                itemResult = item;
            }
        }
        return itemResult;
    }
}
