package main.java.pageEvents;

import main.java.Base.BaseConfigurations;
import main.java.actions.ActionRepo;
import main.java.pageObjects.ShopPageElements;
import main.java.utils.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShopPageEvents extends ActionRepo {

    /**
     *
     *  BuyProduct method execute over items array to purchase relevant items from the application considering quantity as well.
     *
     *
     * @param shoppedItems
     */
    public void selectItems(String shoppedItems, String quantity) {

        BaseConfigurations.logger.info("Added items to the cart");
        Map<String, String> shoppedItemMap = IntStream.range(0, Arrays.asList(shoppedItems.split(",")).size())
                .boxed()
                .collect(Collectors.toMap(i -> Arrays.asList(shoppedItems.split(",")).get(i), i -> Arrays.asList(quantity.split(",")).get(i)));

        shoppedItemMap.forEach((item,itemQty)->{
            for(int qty=0;qty<Integer.parseInt(itemQty);qty++){
                click("XPATH", ShopPageElements.label_Item(item));
            }
        });

    }

    /**
     *
     *  BuyProduct method execute over items array to store relevant items from the application.
     *
     *
     * @param shoppedItems
     */
    public void extractUnitPrice(String shoppedItems) {

        List<String> purchasedItems = Arrays.asList(shoppedItems.split(","));
        purchasedItems.forEach((item)->{
            Double actualPrice = Double.valueOf(getElementText("XPATH", ShopPageElements.label_Price(item), 50));
            Constants.unitPriceMap.put(item,actualPrice);
        });
    }
}
