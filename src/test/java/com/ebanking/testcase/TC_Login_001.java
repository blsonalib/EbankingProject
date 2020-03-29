package com.ebanking.testcase;

import com.ebanking.pageobject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_Login_001 extends BaseClass{
    @Test
    public void loginTest() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        logger.info("Entered user name");
        loginPage.setPassword(password);
        logger.info("Entered password");
        loginPage.clickButton();
        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("login test is passed");
        }else {
            captureScreen( driver,"loginTest");
            Assert.assertTrue(false);
            logger.info("login test is failed");
        }
    }
}
