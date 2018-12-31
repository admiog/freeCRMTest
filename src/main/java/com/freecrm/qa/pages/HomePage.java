package com.freecrm.qa.pages;

import com.freecrm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    // Page Factory or OR
    /*
    @FindBy(xpath = "/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a")
    WebElement Logout;

    @FindBy(xpath = "/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[3]/a")
    WebElement Help;

    @FindBy(xpath = "/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[2]/a")
    WebElement Setup;

     LoginPage loginPage;
    */

    @FindBy(xpath = "//td[contains(text(), 'User: Adebola Ogunmokun')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(), 'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[contains(text(), 'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(), 'Tasks')]")
    WebElement tasksLink;

    @FindBy(xpath = "//a[contains(text(), 'Setup')]")
    WebElement setupLink;

    @FindBy(xpath = "//a[contains(text(), 'Help')]")
    WebElement helpLink;

    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    WebElement logoutLink;

    @FindBy(xpath = "//a[contains(text(), 'New Contact')]")
    WebElement newContactLink;



    // Initializing the page objects
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    // Actions:
    public boolean verifyUserName() {
        return userNameLabel.isDisplayed();
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public ContactsPage clickOnContactsLink() {
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink() {
        tasksLink.click();
        return new TasksPage();
    }

    public SetupPage verifySetupLink(){
        setupLink.click();
        return new SetupPage();
    }

    public LoginPage verifyLogoutLink(){
        logoutLink.click();
        return new LoginPage();
    }

    public HelpPage verifyHelpLink(){
        helpLink.click();
        return new HelpPage();
    }

    public void clickOnNewContactLink(){
        Actions action = new Actions(driver);
        action.moveToElement(contactsLink).build().perform();
        newContactLink.click();
    }

}
