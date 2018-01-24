package com.gildedrose;

class GildedRose {

    private final int MIN_QUALITY = 0;
    private final int MAX_QUALITY = 50;

    public final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!isAgedBrie(items[i]) && !isBackstagePasses(items[i])) {
                decreaseQuality(items[i]);
            } else {
                increaseQuality(items[i]);

                if (isBackstagePasses(items[i])) {
                    if (items[i].sellIn < 11) {
                        increaseQuality(items[i]);
                    }

                    if (items[i].sellIn < 6) {
                        increaseQuality(items[i]);
                    }
                }
            }

            if (!isSulfuras(items[i])) {
                decreaseSellIn(items[i]);
            }

            if (items[i].sellIn < 0) {
                if (!isAgedBrie(items[i])) {
                    if (!isBackstagePasses(items[i])) {
                        decreaseQuality(items[i]);
                    } else {
                        setZeroQuality(items[i]);
                    }
                } else {
                    increaseQuality(items[i]);
                }
            }
        }
    }

    public void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            if (!isSulfuras(item)) {
                item.quality--;
            }
        }
    }

    public void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
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

}
