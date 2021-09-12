package main.java.pageObjects;

public interface CartPageElements {

    //Element path are parametrized inorder to support expanding
    static String ele_lblCardQty(String itemName,int itemQty){
        String itemXpath = "//td[contains(text(),'"+itemName+"')]/following-sibling::td/input[@value='"+itemQty+"']";
        return itemXpath;
    }

    //Element path are parametrized inorder to support expanding
    static  String ele_lblSubtotal(String itemName, double subTotal){
        String xpathItem = "//td[contains(text(),'"+itemName+"')]/following-sibling::td[text()='$"+subTotal+"']";
        return xpathItem;
    }

    //Element path are parametrized inorder to support expanding
    static  String ele_lblUnitPrice(String itemName, double unitPrice){
        String xpathItem = "//td[contains(text(),'"+itemName+"')]/following-sibling::td[text()='$"+unitPrice+"']";
        return xpathItem;
    }

    //Element path are parametrized inorder to support expanding
    static  String ele_lblGrandTotal(String total){
        String xpathItem = "//strong[contains(text(),'Total: "+total+"')]";
        return xpathItem;
    }

}
