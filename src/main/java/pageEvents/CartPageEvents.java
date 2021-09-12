package main.java.pageEvents;

import com.google.common.util.concurrent.AtomicDouble;
import main.java.Base.BaseConfigurations;
import main.java.actions.ActionRepo;
import main.java.pageObjects.CartPageElements;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CartPageEvents extends ActionRepo {

    public void VerifyCartItems(String shoppedItems, String quantity) {

        BaseConfigurations.logger.info("Verify added Cart items");
        Map<String, String> shoppedItemMap = IntStream.range(0, Arrays.asList(shoppedItems.split(",")).size())
                .boxed()
                .collect(Collectors.toMap(i -> Arrays.asList(shoppedItems.split(",")).get(i), i -> Arrays.asList(quantity.split(",")).get(i)));

        shoppedItemMap.forEach((item,qty)->{
            isElementPresent("XPATH", CartPageElements.label_CardQty(item,Integer.parseInt(qty)),true, 50);
        });

    }

    public void verifyItemSubTotal(String shoppedItems, String quantity,String unitPrice) {

        BaseConfigurations.logger.info("Verify subtotal calculation");
        Map<String, String> shoppedItemMap = IntStream.range(0, Arrays.asList(shoppedItems.split(",")).size())
                .boxed()
                .collect(Collectors.toMap(i -> Arrays.asList(shoppedItems.split(",")).get(i), i -> Arrays.asList(quantity.split(",")).get(i)));

        Map<String, String> shoppedPriceMap = IntStream.range(0, Arrays.asList(shoppedItems.split(",")).size())
                .boxed()
                .collect(Collectors.toMap(i -> Arrays.asList(shoppedItems.split(",")).get(i), i -> Arrays.asList(unitPrice.split(",")).get(i)));
        shoppedItemMap.forEach((item,qty)->{
            Double subtotal = Double.parseDouble(qty)*Double.parseDouble(shoppedPriceMap.get(item));
            isElementPresent("XPATH", CartPageElements.label_Subtotal(item,subtotal),true, 50);
        });

    }

    public void verifyUnitPrice(String shoppedItems, String unitPrice){
        BaseConfigurations.logger.info("Verify display unit price");
        Map<String, String> shoppedItemMap = IntStream.range(0, Arrays.asList(shoppedItems.split(",")).size())
                .boxed()
                .collect(Collectors.toMap(i -> Arrays.asList(shoppedItems.split(",")).get(i), i -> Arrays.asList(unitPrice.split(",")).get(i)));

        shoppedItemMap.forEach((item,price)->{
                isElementPresent("XPATH", CartPageElements.label_UnitPrice(item,Double.parseDouble(price)),true,50);
        });
    }

    public void verifyGrandTotal(String shoppedItems, String quantity, String unitPrice){

        BaseConfigurations.logger.info("Verify grand total");
        AtomicDouble grandSum = new AtomicDouble(0.0);
        Map<String, String> shoppedItemMap = IntStream.range(0, Arrays.asList(shoppedItems.split(",")).size())
                .boxed()
                .collect(Collectors.toMap(i -> Arrays.asList(shoppedItems.split(",")).get(i), i -> Arrays.asList(quantity.split(",")).get(i)));

        Map<String, String> shoppedPriceMap = IntStream.range(0, Arrays.asList(shoppedItems.split(",")).size())
                .boxed()
                .collect(Collectors.toMap(i -> Arrays.asList(shoppedItems.split(",")).get(i), i -> Arrays.asList(unitPrice.split(",")).get(i)));


        shoppedItemMap.forEach((item,qty)->{
            Double subtotal = Double.parseDouble(qty)*Double.parseDouble(shoppedPriceMap.get(item));
            grandSum.getAndAdd(subtotal);
        });

        isElementPresent("XPATH", CartPageElements.label_GrandTotal(grandSum.toString()),true, 50);
    }

}
