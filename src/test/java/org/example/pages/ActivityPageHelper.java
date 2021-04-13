package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActivityPageHelper extends CommonUserAreaHelper{
    @FindBy (css = ".action-card")
    List<WebElement> actionCardNameList;

    public ActivityPageHelper(WebDriver driver) {
        super(driver);
    }
    public void waitUntilPageIsLoaded(){
        waitUntilAllElementsAreVisible(actionCardNameList,15);
    }
    public String getLastActionCardNameInHistory(){
        return actionCardNameList.get(0).getText();
    }

}
