package org.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{
    @Test
    public void applicationTest(){
        Assert.assertEquals(homePage.getPageTitle(),"Trello", "The title of the application is not 'Trello'");
    }
}
