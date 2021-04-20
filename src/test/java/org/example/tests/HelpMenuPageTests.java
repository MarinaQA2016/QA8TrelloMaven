package org.example.tests;

import org.example.pages.BoardsPageHelper;
import org.example.pages.HelpPageHelper;
import org.example.pages.LoginPageHelper;
import org.example.pages.UserMenuPanelHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HelpMenuPageTests extends TestBase{
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    UserMenuPanelHelper userMenuPanelPage;
    HelpPageHelper helpPage;

    @BeforeMethod
    public void initTests()  {

        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,BoardsPageHelper.class);
        userMenuPanelPage = PageFactory.initElements(driver, UserMenuPanelHelper.class);
        helpPage = PageFactory.initElements(driver, HelpPageHelper.class);

        loginPage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLoginPasswordAttl(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        userMenuPanelPage.openUserMenu();
        userMenuPanelPage.waitUntilPageIsLoaded();
        userMenuPanelPage.openHelpPage();
        helpPage.waitUntilPageIsLoaded();
    }
    @Test
    public void helpPageTest(){
        Assert.assertEquals("Get help with Trello",helpPage.getHeader());
    }
    @Test
    public void closingHelpPageTest(){
        helpPage.closeWindow();
        boardsPage.waitUntilPageIsLoaded();
        Assert.assertEquals("Boards", boardsPage.getNameBoardsButton());
    }
}
