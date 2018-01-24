package com.gildedrose;

class GildedRose {
    
    private final int MIN_QUALITY = 0;
    
    public final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if ( !isAgedBrie(items[i]) && !isBackstagePasses(items[i]) ) {
                decreaseQuality(items[i]);
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if ( isBackstagePasses(items[i]) ) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if ( !isSulfuras(items[i]) ) {
                decreaseSellIn(items[i]);
            }

            if (items[i].sellIn < 0) {
                if ( !isAgedBrie(items[i]) ) {
                    if ( !isBackstagePasses(items[i]) ) {
                        decreaseQuality(items[i]);
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
    
    public void decreaseQuality(final Item item) {
        if ( item.quality > MIN_QUALITY ) {
            if ( !isSulfuras(item) ) {
                item.quality --;
            }
        }
    }
    
    public void decreaseSellIn(final Item item) {
        item.sellIn --;
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

}
