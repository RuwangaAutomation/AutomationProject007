package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import main.java.Base.BaseConfigurations;

import java.util.List;

/*
Return the WebElement base on the given identifier Type
 */
public class ElementFetch {

    public WebElement getWebElement(String identifierType,String identifierValue){
        switch (identifierType){
            case "ID":
                return BaseConfigurations.driver.findElement(By.id(identifierValue));
            case "CSS":
                return BaseConfigurations.driver.findElement(By.cssSelector(identifierValue));
            case "TAGNAME":
                return BaseConfigurations.driver.findElement(By.tagName(identifierValue));
            case "XPATH":
                return BaseConfigurations.driver.findElement(By.xpath(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return BaseConfigurations.driver.findElements(By.id(identifierValue));
            case "CSS":
                return BaseConfigurations.driver.findElements(By.cssSelector(identifierValue));
            case "TAGNAME":
                return BaseConfigurations.driver.findElements(By.tagName(identifierValue));
            case "XPATH":
                return BaseConfigurations.driver.findElements(By.xpath(identifierValue));
            default:
                return null;
        }
    }
}
