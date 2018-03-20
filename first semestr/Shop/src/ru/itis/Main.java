package ru.itis;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ShopService shopService = new ShopService();

        shopService.addOwner("jnj", 56, "ghj");
        shopService.addOrder(56, "lkehUIGVSBOUIrgn", 1239845);
        shopService.currentHeight(1239845);
        shopService.currentCity("ghjaef");
        shopService.maxOrders();
    }
}
