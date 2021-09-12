package main.java.pageEvents;

import main.java.Base.BaseConfigurations;
import main.java.actions.ActionRepo;
import main.java.pageObjects.HomePageElements;

public class HomePageEvents extends ActionRepo {

    public void goToContactPage() {
        BaseConfigurations.logger.info("Navigate to the Contact Page");
        click("XPATH", HomePageElements.label_NavContact);
    }

    public void goToShopPage() {
        BaseConfigurations.logger.info("Navigate to the Shop Page");
        click("XPATH", HomePageElements.label_NavShop);
    }

    public void goToCartPage() {
        BaseConfigurations.logger.info("Navigate to the Cart Page");
       click("XPATH", HomePageElements.label_NavCart);
    }

}
