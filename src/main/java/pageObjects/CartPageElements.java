package main.java.pageObjects;

public interface CartPageElements {

    //Element path are parametrized inorder to support expanding
    static String label_CardQty(String itemName, int itemQty){
        String itemXpath = "//td[contains(text(),'"+itemName+"')]/following-sibling::td/input[@value='"+itemQty+"']";
        return itemXpath;
    }

    //Element path are parametrized inorder to support expanding
    static  String label_Subtotal(String itemName, double subTotal){
        String xpathItem = "//td[contains(text(),'"+itemName+"')]/following-sibling::td[text()='$"+subTotal+"']";
        return xpathItem;
    }

    //Element path are parametrized inorder to support expanding
    static  String label_UnitPrice(String itemName, double unitPrice){
        String xpathItem = "//td[contains(text(),'"+itemName+"')]/following-sibling::td[text()='$"+unitPrice+"']";
        return xpathItem;
    }

    //Element path are parametrized inorder to support expanding
    static  String label_GrandTotal(String total){
        String xpathItem = "//strong[contains(text(),'Total: "+total+"')]";
        return xpathItem;
    }

}
