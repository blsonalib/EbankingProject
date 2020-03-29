package com.ebanking.testcase;

import com.ebanking.pageobject.LoginPage;
import com.ebanking.utility.JsonReader;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TC_LoginJson_002 extends BaseClass {

   @Test(dataProvider = "LoginData")
    public void LoginData(String userName,String password) throws IOException {
       LoginPage loginPage = new LoginPage(driver);
       loginPage.setUserName(userName);
       logger.info("user name provided");
       loginPage.setPassword(password);
       logger.info("password is provided");
       loginPage.clickButton();
       //captureScreen(driver,"LoginData");
       if(isAlertPresent()==true){
           driver.switchTo().alert().accept();
           driver.switchTo().defaultContent(); //switch to main page
           Assert.assertTrue(false);
           logger.warn("login failed");

       }else{
           Assert.assertTrue(true);
           logger.info("login passed");
           loginPage.ClickLogOut();
           driver.switchTo().alert().accept();//log out alert
           driver.switchTo().defaultContent();
       }
   }

   public boolean isAlertPresent(){
       try {
           driver.switchTo().alert();
           return true;
       }catch (NoAlertPresentException e){
           return false;
       }
   }
    @DataProvider(name = "LoginData")
    public Object[][]passDAta() throws FileNotFoundException {
        return JsonReader.getdata(readCofig.getJsonPath(),"LoginData",4,2);
   }
}
