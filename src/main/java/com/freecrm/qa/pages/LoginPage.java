package com.freecrm.qa.pages;

import com.freecrm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory - OR:
    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginBtn;

    //@FindBy(linkText = "Sign Up")
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/ul/li[2]/a")
    //@FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
    WebElement SignUpBtn;

    @FindBy(xpath = "//img[contains(@alt, 'free crm logo')]")
    //@FindBy(xpath = "//img[contains(@class, 'img-responsive')]")
    WebElement crmLogo;

    // Initializing the Page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateCRMImage() {
        return crmLogo.isDisplayed();
    }

    public HomePage login(String uname, String pword) {
        username.sendKeys(uname);
        password.sendKeys(pword);
        loginBtn.submit();

        return new HomePage();
    }

    public String validateSignUp() {

        SignUpBtn.click();
        return driver.getCurrentUrl();
    }

    public String validateCRMLogoLink() {
        crmLogo.click();
        return driver.getCurrentUrl();
    }



}
