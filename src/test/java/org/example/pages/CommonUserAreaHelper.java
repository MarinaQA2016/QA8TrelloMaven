package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonUserAreaHelper extends PageBase{
    @FindBy(xpath = "//span[contains(text(),'@')]")
    WebElement currentUserNameOnHeader;
    @FindBy(xpath = "//span[contains(text(),'@')]/../*")
    WebElement firstUserNameOnHeader;
    @FindBy(xpath = "//*[@aria-label='Open member menu']")
    WebElement iconButton;

    public CommonUserAreaHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsVisible(currentUserNameOnHeader,15);
        waitUntilElementIsVisible(firstUserNameOnHeader,15);
    }
    public String getFirstUserNameOnHeader(){
        return firstUserNameOnHeader.getText();
    }
    public String getIconButtonTitle(){
        return iconButton.getAttribute("title");
    }
}
