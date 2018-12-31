package com.freecrm.qa.base;

import com.freecrm.qa.util.TestUtil;
import com.freecrm.qa.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;


    public TestBase(){

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\bolas\\IdeaProjects\\freeCRMTest\\" +
                    "src\\main\\java\\com\\freecrm\\qa\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\bolas\\Downloads\\" +
                    "chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\bolas\\Downloads\\" +
                    "geckodriver-v0.23.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (browserName.equals("IE")) {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\bolas\\Downloads\\" +
                    "IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }
}
