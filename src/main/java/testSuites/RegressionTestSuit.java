package main.java.testSuites;

import main.java.Base.BaseConfigurations;
import main.java.utils.Constants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegressionTestSuit extends BaseConfigurations implements Constants {

    //Technical Assignment Test case 1 ---------------------------------------------------------------------------------

    @Test(dataProvider = "test001")
    public void test001(final String foreName, final String Email, final String Message){
        homepageEvents.goToContactPage();
        contactPageEvents.MandatoryFieldsErrorVerification();
        contactPageEvents.FillMandatoryFields(foreName,Email,Message);
        contactPageEvents.ErrorMessageVisibilityVerification();
    }

    @DataProvider(name = "test001")
    public Object[][] test001_data(){
        return dataTableGenerator.populateDataTable("test001");
    }

    //Technical Assignment Test case 2 ---------------------------------------------------------------------------------

    @Test(dataProvider = "test002")
    public void test002(final String foreName, final String Email, final String Message){
        homepageEvents.goToContactPage();
        contactPageEvents.MandatoryFieldsErrorVerification();
        contactPageEvents.FillMandatoryFields(foreName,Email,Message);
        contactPageEvents.Submit();
        contactPageEvents.SuccessMessageVerification();
    }

    @DataProvider(name = "test002")
    public Object[][] test002_data(){
       return dataTableGenerator.populateDataTable("test002");
    }

    //Technical Assignment Test case 3 ---------------------------------------------------------------------------------

    @Test(dataProvider = "test003")
    public void test003(final String shoppedItems,final  String quantity){
        homepageEvents.goToShopPage();
        shopPageEvent.selectItems(shoppedItems,quantity);
        homepageEvents.goToCartPage();
        cartPageEvent.VerifyCartItems(shoppedItems,quantity);
    }

    @DataProvider(name = "test003")
    public Object[][] test003_data(){
        return dataTableGenerator.populateDataTable("test003");
    }

    //Technical Assignment Test case 4 ---------------------------------------------------------------------------------

    @Test(dataProvider = "test004")
    public void test004(final String shoppedItems,final  String quantity,final  String unitPrice){
        homepageEvents.goToShopPage();
        shopPageEvent.selectItems(shoppedItems,quantity);
        homepageEvents.goToCartPage();
        cartPageEvent.verifyUnitPrice(shoppedItems,unitPrice);
        cartPageEvent.verifyItemSubTotal(shoppedItems,quantity,unitPrice);
        cartPageEvent.verifyGrandTotal(shoppedItems,quantity,unitPrice);
    }

    @DataProvider(name = "test004")
    public Object[][] test004_data(){
        return dataTableGenerator.populateDataTable("test004");
    }
}
