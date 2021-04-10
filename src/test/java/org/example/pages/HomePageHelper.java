package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHelper extends PageBase{
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement logInIcon;


    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public HomePageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(logInIcon,40);
        return this;
    }

    public String getPageTitle(){
        System.out.println("text: " + driver.getTitle());
        return driver.getTitle();
    }



}
