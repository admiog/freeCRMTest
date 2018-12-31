package com.freecrm.qa.testcases;
/*
* Author
 */
import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.*;
import com.freecrm.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    SetupPage setupPage;
    HelpPage helpPage;

    public HomePageTest() {
        super();
    }

    // test cases should be independent
    // before each test case launch the browser and login
    // after each test case close the browser

    @BeforeMethod
    public void setUP() {
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        setupPage = new SetupPage();
        helpPage = new HelpPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String pageTitle = homePage.verifyHomePageTitle();
        assertEquals(pageTitle, "CRMPRO", "Home page title not matched.");
    }

    @Test(priority = 2)
    public void verifyUserNameTest() {
        testUtil.switchToFrame();
        assertTrue(homePage.verifyUserName());
    }

    @Test(priority = 3)
    public void clickOnContactsLinkTest() {
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }

    @Test(priority = 4)
    public void verifySetupLinkTest(){
        testUtil.switchToFrame();
        setupPage = homePage.verifySetupLink();
    }

    @Test(priority = 5)
    public void verifyLogoutLinkTest(){
        testUtil.switchToFrame();
        loginPage = homePage.verifyLogoutLink();
    }

    @Test(priority = 6)
    public void verifyHelpLinkTest(){
        testUtil.switchToFrame();
        helpPage = homePage.verifyHelpLink();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
