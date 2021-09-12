package main.java.pageEvents;

import main.java.Base.BaseConfigurations;
import main.java.actions.ActionRepo;
import main.java.pageObjects.ContactPageElements;
import main.java.utils.ElementFetch;

public class ContactPageEvents extends ActionRepo {

    public void validateMandatoryFieldsError() {

        BaseConfigurations.logger.info("Validate Mandatory fields Error Message");
        waitTillElementToLoad("XPATH", ContactPageElements.btn_Submit,10);
        click("XPATH", ContactPageElements.btn_Submit);
        isElementPresent("XPATH",ContactPageElements.ele_lblForeNameError,true,  30);
        isElementPresent("XPATH",ContactPageElements.ele_lblEmailError,true,  30);
        isElementPresent("XPATH",ContactPageElements.ele_lblMessageError,true,  30);
    }

    public void populateMandatoryFields(String foreName, String email, String message) {

        BaseConfigurations.logger.info("Populate Mandatory fields");
        ElementFetch elementFetch = new ElementFetch();
        type("XPATH", ContactPageElements.tf_ForeName,foreName);
        type("XPATH", ContactPageElements.tf_Email,email);
        type("XPATH", ContactPageElements.tf_Message,message);
    }

    public void validateSuccessFeedbackMessage() {

        BaseConfigurations.logger.info("Validate Success Feedback message");
        waitTillElementToLoad("XPATH", ContactPageElements.ele_lblMessageSuccess,50);
        isElementPresent("XPATH", ContactPageElements.ele_lblMessageSuccess,true,30);
    }

    public void validateErrorMessageVisibility() {

        BaseConfigurations.logger.info("Validate Error message visibility");
        isElementPresent("XPATH", ContactPageElements.ele_lblForeNameError,false,10);
        isElementPresent("XPATH", ContactPageElements.ele_lblEmailError,false,10);
        isElementPresent("XPATH", ContactPageElements.ele_lblMessageError,false,10);

    }

    public void clickOnSubmitButton() {
        BaseConfigurations.logger.info("Click on submit button");
        click("XPATH",ContactPageElements.btn_Submit);
    }

}
