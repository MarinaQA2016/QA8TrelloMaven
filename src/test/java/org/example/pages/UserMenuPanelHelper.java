package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserMenuPanelHelper extends PageBase{
    @FindBy(xpath = "//a[@data-test-id ='header-member-menu-profile']")
    WebElement profileAndVisibilityMenu;
    @FindBy(xpath = "//button[@aria-label='Open member menu']")
    WebElement userMenuButton;
    @FindBy(xpath = "//nav//span[contains(text(),'@')]")
    WebElement emailOnMenu;
    @FindBy(css = "._1njv2a9PIrnydF")
    WebElement firstUserName;
    @FindBy(xpath = "//span[contains(text(),'Activity')]/..")
    List<WebElement> activityMenuList;

    public UserMenuPanelHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){

        waitUntilElementIsClickable(profileAndVisibilityMenu,10);
        int last = activityMenuList.size()-1;
        waitUntilElementIsClickable(activityMenuList.get(last),15);
    }
    public void openUserMenu(){
        userMenuButton.click();
        waitUntilElementIsClickable(profileAndVisibilityMenu,10);
    }
    public String getEmailFromMenu(){
        return emailOnMenu.getText();
    }

    public String getFirstUserName(){
        return firstUserName.getText();
    }
    public String getUserMenuButtonTitle(){
        return userMenuButton.getAttribute("title");
    }
    public void openActivityPage(){
        int last = activityMenuList.size()-1;
        activityMenuList.get(last).click();
    }
}
