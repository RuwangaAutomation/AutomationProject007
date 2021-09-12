package main.java.pageObjects;

import org.openqa.selenium.By;

public interface ContactPageElements {

    String btn_Submit = "//a[text()='Submit']";

    String ele_lblForeNameError = "//span[@id='forename-err']";

    String ele_lblEmailError = "//span[@id='email-err']";

    String ele_lblMessageError = "//span[@id='message-err']";

    String ele_lblMessageSuccess = "//div[@class='alert alert-success']";

    String tf_ForeName = "//input[@id='forename']";

    String tf_Email = "//input[@id='email']";

    String tf_Message = "//textarea[@id='message']";

}
