package org.example.pages;

import org.example.util.LogLog4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase{
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement logInIcon;
    @FindBy(id = "user")
    WebElement loginField;
    @FindBy(id = "login")
    WebElement loginButton;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(css = "#error >.error-message")
    WebElement errorMessageNotAttl;
    @FindBy(xpath = "//input[@value = 'Log in with Atlassian']")
    WebElement loginAsAttlButton;

    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public LoginPageHelper openLoginPage() {
                logInIcon.click();
                return this;
    }

    public LoginPageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(loginField,10);
        waitUntilElementIsClickable(loginButton,20);
        return this;
    }

    public LoginPageHelper enterLoginPassNotAttl(String login, String password) {
        log4j.info("  !!!  Method 'enterLoginPassNotAttl' was started  !!!  ");
        this.enterLoginNotAttl(login);
        log4j.info("Login value = " + login + "was entered");
        this.enterPasswordNotAttl(password);
        log4j.info("Password value = " + password + "was entered");
        this.clickLoginInButtonNotAttl();
        log4j.info("Click on the 'Login' button");
        log4j.info("  !!!  Method 'enterLoginPassNotAttl' was finished  !!!  ");
        return this;
    }

    public LoginPageHelper enterLoginPasswordAttl(String login, String password) {
        this.enterLoginNotAttl(login);
        this.clickLoginAttl();
        this.enterPasswordAttl(password);
        this.submitAttl();
        return this;
    }

    public LoginPageHelper enterLoginNotAttl(String value) {
        fillField(loginField,value);
        return this;
    }

    public LoginPageHelper enterPasswordNotAttl(String value) {
        waitUntilElementIsClickable(passwordField,10);
        fillField(passwordField,value);
        //to be sure that loginField and passwordField are already filled in
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public LoginPageHelper clickLoginInButtonNotAttl() {
        waitUntilElementIsClickable(loginButton,20);
        loginButton.click();
        return this;
    }

    public String getErrorNotAttlMessage(){
        waitUntilElementIsVisible(errorMessageNotAttl,20);
        return errorMessageNotAttl.getText();
    }

    public LoginPageHelper clickLoginAttl() {
        waitUntilElementIsClickable(loginAsAttlButton,10);
        loginAsAttlButton.click();
        return this;
    }

    public LoginPageHelper enterPasswordAttl(String value) {
        waitUntilElementIsClickable(By.id("password"),10);
        WebElement passwordField = driver.findElement(By.id("password"));
        fillField(passwordField,value);
        return this;

    }

    public LoginPageHelper submitAttl() {
        waitUntilElementIsClickable(By.id("login-submit"),10);
        driver.findElement(By.id("login-submit")).click();
        return this;
    }

    public String getErrorAttlMessage() {
        waitUntilElementIsVisible(By.id("login-error"),10);
        return driver.findElement(By.id("login-error")).getText();
    }
}
