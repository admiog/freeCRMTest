package com.freecrm.qa.testcases;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactsPageTest extends TestBase {

    ContactsPage contactsPage;
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    String sheetName = "contacts";

    public ContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        testUtil = new TestUtil();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }

    @Test(priority = 1)
    public void verifyContactsPageLabelTest(){
        assertTrue(contactsPage.verifyContactsPageLabel(), "Contacts label missing.");
    }

    @Test(priority = 2)
    public void selectSingleContactsByNameTest(){
        contactsPage.selectContactsByName("Kehinde Afolabi");
    }

    @Test(priority = 3)
    public void selectMultipleContactsByNameTest(){
        contactsPage.selectContactsByName("Irene Ogunmokun");
        contactsPage.selectContactsByName("Olivia Ogunmokun");
    }

    @DataProvider
    public Object[][] getCRMTestData(){
        Object[][] data =TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 4, dataProvider = "getCRMTestData")
    public void validateCreateNewContactTest(String title, String firstName, String lastName, String company){
        homePage.clickOnNewContactLink();
        contactsPage.createNewContact(title, firstName, lastName, company);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
