package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public static final int MAX_QUALITY = 50;

    public static final int MIN_QUALITY = 0;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
