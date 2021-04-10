package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardsPageHelper extends PageBase{
    @FindBy(xpath = "//button[@aria-label = 'Open boards menu']")
    WebElement boardsButton;
    public BoardsPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(boardsButton,20);
    }

    public String getNameBoardsButton(){
        waitUntilElementIsClickable(boardsButton,5);
        return boardsButton.getText();
    }
}
