package main.java.pageEvents;

import main.java.Base.BaseConfigurations;
import main.java.actions.ActionRepo;
import main.java.pageObjects.ContactPageElements;
import main.java.utils.ElementFetch;

public class ContactPageEvents extends ActionRepo {

    public void MandatoryFieldsErrorVerification() {

        BaseConfigurations.logger.info("Validate Mandatory fields Error Message");
        waitTillElementToLoad("XPATH", ContactPageElements.btn_Submit,10);
        click("XPATH", ContactPageElements.btn_Submit);
        isElementPresent("XPATH",ContactPageElements.label_ForeNameError,true,  30);
        isElementPresent("XPATH",ContactPageElements.label_EmailError,true,  30);
        isElementPresent("XPATH",ContactPageElements.label_MessageError,true,  30);
    }

    public void FillMandatoryFields(String foreName, String email, String message) {

        BaseConfigurations.logger.info("Populate Mandatory fields");
        ElementFetch elementFetch = new ElementFetch();
        type("XPATH", ContactPageElements.text_ForeName,foreName);
        type("XPATH", ContactPageElements.text_Email,email);
        type("XPATH", ContactPageElements.text_Message,message);
    }

    public void SuccessMessageVerification() {

        BaseConfigurations.logger.info("Validate Success Feedback message");
        waitTillElementToLoad("XPATH", ContactPageElements.label_MessageSuccess,50);
        isElementPresent("XPATH", ContactPageElements.label_MessageSuccess,true,50);
    }

    public void ErrorMessageVisibilityVerification() {

        BaseConfigurations.logger.info("Validate Error message visibility");
        isElementPresent("XPATH", ContactPageElements.label_ForeNameError,false,1);
        isElementPresent("XPATH", ContactPageElements.label_EmailError,false,1);
        isElementPresent("XPATH", ContactPageElements.label_MessageError,false,1);

    }

    public void Submit() {
        BaseConfigurations.logger.info("Click on submit button");
        click("XPATH",ContactPageElements.btn_Submit);
    }

}
