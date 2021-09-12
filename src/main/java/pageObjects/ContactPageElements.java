package main.java.pageObjects;

import org.openqa.selenium.By;

public interface ContactPageElements {

    String btn_Submit = "//a[text()='Submit']";

    String label_ForeNameError = "//span[@id='forename-err']";

    String label_EmailError = "//span[@id='email-err']";

    String label_MessageError = "//span[@id='message-err']";

    String label_MessageSuccess = "//div[@class='alert alert-success']";

    String text_ForeName = "//input[@id='forename']";

    String text_Email = "//input[@id='email']";

    String text_Message = "//textarea[@id='message']";

}
