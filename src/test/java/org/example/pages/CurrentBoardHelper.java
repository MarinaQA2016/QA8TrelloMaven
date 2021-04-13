package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CurrentBoardHelper extends PageBase{
    @FindBy(css = ".mod-show-menu")
    WebElement showMenuIcon;
    @FindBy(css = ".list-header")
    List<WebElement> listHeaderLists;
    @FindBy(xpath = "//span[@class='placeholder']/..")
    WebElement addListButton;
    @FindBy(xpath = "//input[@name = 'name']")
    WebElement titleListField;
    @FindBy(css = ".js-save-edit")
    WebElement submitButton;
    @FindBy(css = ".js-cancel-edit")
    WebElement cancelEditList;
    @FindBy(css = ".js-card-details")
    List<WebElement> cardsList;
    @FindBy(css = ".open-card-composer")
    WebElement addNewCard;
    @FindBy(css = ".js-card-title")
    WebElement cardTitle;
    @FindBy(css = ".js-add-card")
    WebElement submitCard;
    @FindBy(css = ".js-cancel")
    WebElement xButton;
    @FindBy(css = ".js-open-list-menu")
    WebElement openListMenu;
    @FindBy(xpath = "//*[@class = 'js-close-list']/..")
    WebElement deleteListOption;

    String boardName;

    public CurrentBoardHelper(WebDriver driver, String boardName) {
        super(driver);
        this.boardName = boardName;
        PageFactory.initElements(driver,this);
    }

    public void openCurrentBoardPage(){
        WebElement qaHaifa8Board = driver.findElement(By
                .xpath("//a[@class = 'board-tile'][.//@title='" + boardName + "']"));
        qaHaifa8Board.click();
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(showMenuIcon,10);
    }

    public int getListsQuantity(){
        return listHeaderLists.size();
    }

    public void addNewList(String nameList) {
        addListButton.click();
        waitUntilElementIsClickable(titleListField,10);
        fillField(titleListField,nameList);
        submitButton.click();
        cancelEditList.click();
        waitUntilAllElementsAreVisible(listHeaderLists,10);
    }

    public int getCardsQuantity(){
        return cardsList.size();
    }

    public String getAddListButtonName(){
        return addListButton.getText();
    }

    public void changeLastListName(String listName) {
        // ----- Define the index of the last list --------------
        int lastList = getListsQuantity()-1;

        //-------- Click on the header--------------
        WebElement lastHeader = driver.findElements(By.cssSelector(".list-header")).get(lastList);

        lastHeader.click();
        waitUntilElementIsClickable(By.cssSelector(".js-list-name-input"),10);

        //------- Change the header -----------------
        WebElement lastNameList = driver.findElements(By.cssSelector(".js-list-name-input")).get(lastList);
        lastNameList.sendKeys(listName);
        lastNameList.sendKeys(Keys.ENTER);
        driver.navigate().refresh();
        waitUntilAllElementsArePresent(By.cssSelector(".list-header"),15);
    }


    public String getLastListName(){
        int listsQuantity = getListsQuantity();
        if (listsQuantity == 0) return "-- No lists --";
        else
            return listHeaderLists.get(listsQuantity-1).getText();
    }

    public void addNewCard(String nameCard) {
        //------ Define "Add Card" button and click it ------
        waitUntilElementIsClickable(addNewCard,10);
        addNewCard.click();

        //-------Define title field of the card and fill in it ----
        waitUntilElementIsClickable(cardTitle,10);
        fillField(cardTitle,nameCard);

        //----- Define 'Add Card' button and click it -----------
        submitCard.click();

        //------ Click X-button -----------
        waitUntilElementIsClickable(xButton,10);
        xButton.click();
    }

    public void deleteAnyList() {
        // ------ Define openListMenu and click -----------
        openListMenu.click();
        //-------- Wait and click 'Archive List' menu option ----
        waitUntilElementIsClickable(deleteListOption,10);
        deleteListOption.click();

        //------- Wait 'Archive List' option disappears ---------
        waitUntilElementDisappears(deleteListOption,10);
    }
}
