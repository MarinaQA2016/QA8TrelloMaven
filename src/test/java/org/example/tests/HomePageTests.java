package org.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{
    @Test
    public void applicationTest(){
        log4j.info("Test - ApplicationTest was started");
        Assert.assertEquals(homePage.getPageTitle(),"Trello", "The title of the application is not 'Trello'");
        log4j.info("Test was finished");
    }
}
