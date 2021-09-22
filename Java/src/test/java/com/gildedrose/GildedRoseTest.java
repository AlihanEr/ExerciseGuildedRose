package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GildedRoseTest {

    @Test
    void normalItemDegradation() {
        Item[] items = new Item[] { new Item("normal", 15, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, items[0].sellIn);
        assertEquals(2, items[0].quality);
    }

    @Test
    void normalItemQualityMinDegradation() {
        Item[] items = new Item[] { new Item("normal", 15, Item.MIN_QUALITY) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void normalItemSellInNegativeDegradation() {
        Item[] items = new Item[] { new Item("normal", -2, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-3, items[0].sellIn);
        assertEquals(1, items[0].quality);
    }

    @Test
    void normalItemSellInZeroDegradation() {
        Item[] items = new Item[] { new Item("normal", 0, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(1, items[0].quality);
    }

    @Test
    void sulfurasItemDegradation() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void agedBrieItemDegradation() {
        Item[] items = new Item[] { new Item("Aged Brie", 11, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, items[0].sellIn);
        assertEquals(7, items[0].quality);
    }

    @Test
    void agedBrieItemQualityMaxDegradation() {
        Item[] items = new Item[] { new Item("Aged Brie", 11, Item.MAX_QUALITY) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void agedBrieItemSellInNegativeDegradation() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    void agedBrieItemSellInNegativeAndMaxQualityDegradation() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, Item.MAX_QUALITY) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void backStagePassItemDegradation() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, items[0].sellIn);
        assertEquals(21, items[0].quality);
    }

    @Test
    void backStagePassItemSellInLessThan10DaysDegradation() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, items[0].sellIn);
        assertEquals(22, items[0].quality);
    }

    @Test
    void backStagePassItemSellInLessThan5DaysDegradation() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, items[0].sellIn);
        assertEquals(23, items[0].quality);
    }

    @Test
    void backStagePassItemSellInPassedDegradation() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void conjuredItemDegradation() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 22, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, items[0].sellIn);
        assertEquals(3, items[0].quality);
    }

    @Test
    void conjuredItemSellInNegativeDegradation() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -2, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-3, items[0].sellIn);
        assertEquals(1, items[0].quality);
    }

    @Test
    void conjuredItemQualityMinDegradation() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -2, Item.MIN_QUALITY) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-3, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void multipleItemsDegradation() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Aged Brie", -2, 10),
            new Item("Aged Brie", -6, Item.MAX_QUALITY),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Philosophale stone", -20, Item.MAX_QUALITY),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, Item.MAX_QUALITY),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, Item.MAX_QUALITY),
            new Item("Conjured Mana Cake", 10, 10),
            new Item("Conjured Mana Cake", -2, 10),
            new Item("Conjured Mana Cake", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, items[0].quality);
        assertEquals(1, items[1].quality);
        assertEquals(12, items[2].quality);
        assertEquals(50, items[3].quality);
        assertEquals(6, items[4].quality);
        assertEquals(48, items[5].quality);
        assertEquals(80, items[6].quality);
        assertEquals(80, items[7].quality);
        assertEquals(11, items[8].quality);
        assertEquals(12, items[9].quality);
        assertEquals(13, items[10].quality);
        assertEquals(50, items[11].quality);
        assertEquals(0, items[12].quality);
        assertEquals(8, items[13].quality);
        assertEquals(6, items[14].quality);
        assertEquals(6, items[15].quality);
    }

    @Test()
    void multipleItemsWithNullDegradation() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Aged Brie", -2, 10),
            null,
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Philosophale stone", -20, Item.MAX_QUALITY),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, Item.MAX_QUALITY),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, Item.MAX_QUALITY),
            new Item("Conjured Mana Cake", 10, 10),
            new Item("Conjured Mana Cake", -2, 10),
            new Item("Conjured Mana Cake", 0, 10)};
        GildedRose app = new GildedRose(items);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> app.updateQuality());
        assertEquals("AN ITEM CANNOT BE NULL", exception.getMessage());
    }

    @Test()
    void nullItemListDegradation() {
        GildedRose app = new GildedRose(null);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> app.updateQuality());
        assertEquals("THE LIST OF ITEMS CANNOT BE NULL", exception.getMessage());
    }
}
