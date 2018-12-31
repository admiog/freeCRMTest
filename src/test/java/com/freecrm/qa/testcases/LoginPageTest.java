package com.freecrm.qa.testcases;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUP() {
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
    }

    @Test(priority = 2)
    public void crmLogoImageTest() {
        boolean flag =loginPage.validateCRMImage();
        assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
/*
    @Test(priority = 4)
    public void signUpTest() {
        //testUtil.switchToFrame();
        String signUpUrl = loginPage.validateSignUp();
        assertEquals(signUpUrl, "https://www.freecrm.com/register/");
    }

    @Test(priority = 5)
    public void crmLogoLinkTest() {
        //testUtil.switchToFrame();
        String crmLogoLink = loginPage.validateCRMLogoLink();
        assertEquals(crmLogoLink, "https://www.freecrm.com/index.html");
    }
*/
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
