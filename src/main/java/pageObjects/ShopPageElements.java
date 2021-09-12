package main.java.pageObjects;

public interface ShopPageElements {

    String label_NavShop = "//li[@id='nav-shop\"";

    //Element path are parametrized inorder to support expanding
    static String label_Item(String itemName){
        String itemXpath = "//h4[text()='" + itemName + "']/..//a";
        return itemXpath;
    }

    //Element path are parametrized inorder to support expanding
    static String label_Price(String itemName){
        String itemXpath = "//h4[text()='"+itemName+"']/..//span";
        return itemXpath;
    }
}
