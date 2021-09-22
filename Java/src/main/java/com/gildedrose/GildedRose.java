package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        if (items != null) {
            for (Item item : items) {
                if (item != null) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.sellIn--;
                    }
                    switch (item.name) {
                        case "Sulfuras, Hand of Ragnaros":
                            break;
                        case "Aged Brie":
                            updateAgedBrie(item);
                            break;
                        case "Backstage passes to a TAFKAL80ETC concert":
                            updateBackStagePasses(item);
                            break;
                        case "Conjured Mana Cake":
                            updateNormalItem(item);
                        default:
                            updateNormalItem(item);
                    }
                } else {
                    throw new IllegalArgumentException("AN ITEM CANNOT BE NULL");
                }
            }
        } else {
            throw new IllegalArgumentException("THE LIST OF ITEMS CANNOT BE NULL");
        }
    }


    private void decreaseQuality(Item item) {
        if (item.quality > Item.MIN_QUALITY) {
            item.quality--;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < Item.MAX_QUALITY) {
            item.quality++;
        }
    }

    private void updateNormalItem(Item item) {
        decreaseQuality(item);
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void updateAgedBrie(Item item) {
        increaseQuality(item);
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void updateBackStagePasses(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
        if (item.sellIn < 0) {
            item.quality = Item.MIN_QUALITY;
        }
    }
}
