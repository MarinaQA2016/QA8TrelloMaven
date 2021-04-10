package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserMenuPanelPage extends PageBase{
    @FindBy(xpath = "//a[@data-test-id ='header-member-menu-profile']")
    WebElement profileAndVisibilityMenu;
    @FindBy(xpath = "//button[@aria-label='Open member menu']")
    WebElement userMenuButton;
    @FindBy(xpath = "//nav//span[contains(text(),'@')]")
    WebElement emailOnMenu;

    public UserMenuPanelPage(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(profileAndVisibilityMenu,10);
    }
    public void openUserMenu(){
        userMenuButton.click();
        waitUntilElementIsClickable(profileAndVisibilityMenu,10);
    }
    public String getEmailFromMenu(){
        return emailOnMenu.getText();
    }
}
