package org.example.tests;




import org.example.pages.*;
import org.example.util.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;


    @BeforeMethod
    public void initTests()  {
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,BoardsPageHelper.class);
        loginPage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
    }

    @Test
    public void loginNegativeLoginIncorrect() {
        loginPage.enterLoginPassNotAttl("123","psw");

        Assert.assertTrue(loginPage.getErrorNotAttlMessage()
                .contains("There isn't an account"),"The error-message" +
                "doesn't contain 'There isn't an account'");

    }

    @Test
    public void loginNegativeLoginEmpty() {
        loginPage.enterLoginPassNotAttl("","psw");

        Assert.assertTrue(loginPage.getErrorNotAttlMessage()
                .contains("Missing"),"The error-message isn't correct");

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginNegative")
    public void loginNegativeParametric(String login, String password, String message) {
        loginPage.enterLoginPassNotAttl(login,password);

        Assert.assertTrue(loginPage.getErrorNotAttlMessage().equals(message),"The error-message isn't correct");

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "dataProviderSecond")
    public void loginNegativeParametricSecond(String login, String password) {
        loginPage.enterLoginPassNotAttl(login,password);

        Assert.assertTrue(loginPage.getErrorNotAttlMessage().equals("There isn't an account for this username"),"The error-message isn't correct");

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "dataProviderThird")
    public void loginNegativeParametricThird(String login, String password) {
        loginPage.enterLoginPassNotAttl(login,password);

        Assert.assertTrue(loginPage.getErrorNotAttlMessage().equals("There isn't an account for this email"),"The error-message isn't correct");

    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginPositive")
    public void loginPositive(String login, String password)  {
        //loginPage.enterLoginPasswordAttl(LOGIN,PASSWORD);
        loginPage.enterLoginPasswordAttl(login,password);
        boardsPage.waitUntilPageIsLoaded();

        Assert.assertEquals("Boards", boardsPage
                .getNameBoardsButton());
    }



    @Test
    public void negativePasswordIncorrect()  {
        loginPage.enterLoginPasswordAttl(LOGIN,"incorrect")
                 .getErrorAttlMessage();

        Assert.assertTrue(loginPage.getErrorAttlMessage()
                .contains("email"));
    }





}
