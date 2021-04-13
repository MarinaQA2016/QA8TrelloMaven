package org.example.tests;

import org.example.pages.BoardsPageHelper;
import org.example.pages.CommonUserAreaHelper;
import org.example.pages.LoginPageHelper;
import org.example.pages.UserMenuPanelHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CommonUserAreaTests extends TestBase{

    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    UserMenuPanelHelper userMenuPanelPage;
    CommonUserAreaHelper commonUserArea;

    @BeforeMethod
    public void initTests()  {
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,BoardsPageHelper.class);
        userMenuPanelPage = PageFactory.initElements(driver, UserMenuPanelHelper.class);
        commonUserArea = PageFactory.initElements(driver, CommonUserAreaHelper.class);

        loginPage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLoginPasswordAttl(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        userMenuPanelPage.openUserMenu();
        userMenuPanelPage.waitUntilPageIsLoaded();
        userMenuPanelPage.openActivityPage();
        commonUserArea.waitUntilPageIsLoaded();


    }
    @Test
    public void firstUserNameTest(){
        Assert.assertTrue(commonUserArea.getIconButtonTitle()
                .contains(commonUserArea.getFirstUserNameOnHeader()));
    }
}
