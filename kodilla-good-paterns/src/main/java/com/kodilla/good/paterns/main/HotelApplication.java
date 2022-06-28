package com.kodilla.good.paterns.main;

import com.kodilla.good.paterns.enums.hotel.PriceList;
import com.kodilla.good.paterns.enums.hotel.Season;

public class HotelApplication {
    public static void main(String[] args) {
        System.out.println("Accommodation prices:");
        System.out.println("1. Single Bed rooms");
        System.out.println("   - low season: " + PriceList.getSingleBedPrice("LOW"));
        System.out.println("   - high season: " + PriceList.getSingleBedPrice("HIGH"));
        System.out.println("   - holiday season: " + PriceList.getSingleBedPrice("HOLIDAY"));
        System.out.println("2. Double Bed rooms");
        System.out.println("   - low season: " + PriceList.getDoubleBedPrice("LOW"));
        System.out.println("   - high season: " + PriceList.getDoubleBedPrice("HIGH"));
        System.out.println("   - holiday season: " + PriceList.getDoubleBedPrice("HOLIDAY"));

        Season season = Season.HOLIDAY;
        System.out.println(season);
    }
}
