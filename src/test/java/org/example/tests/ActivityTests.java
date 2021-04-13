package org.example.tests;

import org.example.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActivityTests extends TestBase{
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardHelper qa8HaifaBoard;
    UserMenuPanelHelper userMenuPanelPage;
    CommonUserAreaHelper commonUserArea;
    ActivityPageHelper activityPage;

    @BeforeMethod
    public void initTests()  {
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,BoardsPageHelper.class);
        userMenuPanelPage = PageFactory.initElements(driver, UserMenuPanelHelper.class);
        commonUserArea = PageFactory.initElements(driver, CommonUserAreaHelper.class);
        qa8HaifaBoard = new CurrentBoardHelper(driver,"QA Haifa8");
        activityPage = PageFactory.initElements(driver,ActivityPageHelper.class);

        loginPage.openLoginPage()
                .waitUntilPageIsLoaded()
                .enterLoginPasswordAttl(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();}

    @Test
    public void newCardInActivity(){
        String cardName = "test_card";
        qa8HaifaBoard.openCurrentBoardPage();
        qa8HaifaBoard.waitUntilPageIsLoaded();

        if(qa8HaifaBoard.getAddListButtonName().equals("Add a list")){
            qa8HaifaBoard.addNewList("NewList");
        }

        qa8HaifaBoard.addNewCard(cardName);
        userMenuPanelPage.openUserMenu();
        userMenuPanelPage.waitUntilPageIsLoaded();
        userMenuPanelPage.openActivityPage();
        commonUserArea.waitUntilPageIsLoaded();

        Assert.assertEquals(cardName, activityPage.getLastActionCardNameInHistory());

    }
}
