package main.java.pageObjects;

public interface ShopPageElements {

    String ele_lblNavShop = "//li[@id='nav-shop\"";

    //Element path are parametrized inorder to support expanding
    static String ele_lblItem(String itemName){
        String itemXpath = "//h4[text()='" + itemName + "']/..//a";
        return itemXpath;
    }

    //Element path are parametrized inorder to support expanding
    static String ele_lblPrice(String itemName){
        String itemXpath = "//h4[text()='"+itemName+"']/..//span";
        return itemXpath;
    }
}
