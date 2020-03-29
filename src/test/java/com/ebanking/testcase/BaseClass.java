package com.ebanking.testcase;

import com.ebanking.utility.JsonReader;
import com.ebanking.utility.ReadCofig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BaseClass {
    public static WebDriver driver;
    ReadCofig readCofig = new ReadCofig();
    String baseURL = readCofig.getBaseUrl();
    String userName = readCofig.getUserName();
    String password = readCofig.getPassword();
    public Logger logger;
    @Parameters("browser")
    @BeforeClass

    public void setUp(String br) {
        logger = Logger.getLogger("eBankingTest");
        PropertyConfigurator.configure("log4j.properties");
        if (br.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",readCofig.getChromePath()) ;
            driver = new ChromeDriver() ;
        }else if(br.equalsIgnoreCase("fireFox")){
            System.setProperty("webdriver.gecko.driver",readCofig.getGeckoPath()) ;
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(baseURL);
       // driver.get("http://demo.guru99.com/V4/manager/addcustomerpage.php");
        logger.info("opened page");
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
    public void captureScreen(WebDriver driver,String tcasenamename) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File (System.getProperty("user.dir")+"/ScreenShots/"+tcasenamename+".png");
        FileUtils.copyFile(source,target);
        System.out.println("Screenshot taken");
    }

}
