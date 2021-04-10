package org.example.tests;

import java.io.IOException;
import java.net.URL;

import org.example.SuiteConfiguration;
import org.example.pages.HomePageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Base class for TestNG-based test classes
 */
public class TestBase {

  protected static URL gridHubUrl = null;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;
  public HomePageHelper homePage;
  public static final String LOGIN = "marinaqatest2019@gmail.com";
  public static final String PASSWORD = "marinaqa";

  @BeforeSuite
  public void initTestSuite() throws IOException {
    SuiteConfiguration config = new SuiteConfiguration();
    baseUrl = config.getProperty("site.url");
    if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
      gridHubUrl = new URL(config.getProperty("grid.url"));
    }
    capabilities = config.getCapabilities();
  }

  @BeforeMethod
  public void initWebDriver() {

    driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
    homePage = PageFactory.initElements(driver,HomePageHelper.class);
    driver.get(baseUrl);
    homePage.waitUntilPageIsLoaded();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    WebDriverPool.DEFAULT.dismissAll();
  }
}
