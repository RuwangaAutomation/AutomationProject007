package main.java.pageEvents;

import main.java.Base.BaseConfigurations;
import main.java.actions.ActionRepo;
import main.java.pageObjects.HomePageElements;

public class HomePageEvents extends ActionRepo {

    public void navigateToContactPage() {
        BaseConfigurations.logger.info("Navigate to the Contact Page");
        click("XPATH", HomePageElements.ele_lblNavContact);
    }

    public void navigateToShopPage() {
        BaseConfigurations.logger.info("Navigate to the Shop Page");
        click("XPATH", HomePageElements.ele_lblNavShop);
    }

    public void navigateToCartPage() {
        BaseConfigurations.logger.info("Navigate to the Cart Page");
       click("XPATH", HomePageElements.ele_lblNavCart);
    }

}
