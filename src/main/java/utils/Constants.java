package main.java.utils;

import main.java.pageEvents.CartPageEvents;
import main.java.pageEvents.ContactPageEvents;
import main.java.pageEvents.HomePageEvents;
import main.java.pageEvents.ShopPageEvents;

import java.util.HashMap;
import java.util.Map;

public interface Constants {
    String url = "https://jupiter.cloud.planittesting.com";
    enum IdentifierTypes{
        ID,
        CSS,
        TAGNAME,
        XPATH
    }
    HomePageEvents homepageEvents = new HomePageEvents();
    ContactPageEvents contactPageEvents = new ContactPageEvents();
    CartPageEvents cartPageEvent = new CartPageEvents();
    ShopPageEvents shopPageEvent = new ShopPageEvents();
    DataTableGenerator dataTableGenerator = new DataTableGenerator();
    Map<String,Double> unitPriceMap = new HashMap<>();
}
