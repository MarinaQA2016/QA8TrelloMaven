package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPageHelper extends PageBase{
    @FindBy (xpath = "//h1")
    WebElement header;

    public HelpPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        this.waitUntilAllWindowsAreLoaded(2,15);
        String helpPageWindow = this.getAnotherWindowHandle();
        driver.switchTo().window(helpPageWindow);
    }

    public String getHeader(){
        return header.getText();
    }

    public void closeWindow() {
        String firstWindow = this.getAnotherWindowHandle();
        driver.close();
        driver.switchTo().window(firstWindow);


    }
}
