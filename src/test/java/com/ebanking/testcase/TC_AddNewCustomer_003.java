package com.ebanking.testcase;

import com.ebanking.pageobject.AddNewCustomerPage;
import com.ebanking.pageobject.LoginPage;
import com.ebanking.utility.JsonReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TC_AddNewCustomer_003 extends BaseClass{

    @Test(dataProvider = "NewCustomer")
    public void addnewCustomer(String custName,String mm,String dd,String yy,String address,String city,String state,String pin,String mNo,String email,String pass) throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        logger.info("Entered user name");
        loginPage.setPassword(password);
        logger.info("Entered password");
        loginPage.clickButton();
        AddNewCustomerPage newCustomerPage;
        newCustomerPage = new AddNewCustomerPage(driver);
        newCustomerPage.clickOnNewCustomer();
        logger.info("customer page is opened");
        newCustomerPage.setCustomeName(custName);
        newCustomerPage.clickGender();
        newCustomerPage.setDateOfbirth(mm,dd,yy);
        newCustomerPage.setAddress(address);
        newCustomerPage.setCity(city);
        newCustomerPage.setState(state);
        newCustomerPage.setPincode(pin);
        newCustomerPage.setMobileNumber(mNo);
        newCustomerPage.setEmail(email);
        newCustomerPage.setPassword(pass);
        newCustomerPage.clickSubmit();
        boolean register = driver.getPageSource().contains("Customer Registered Successfully!!!");
        if(register==true){
            Assert.assertTrue(true);
            logger.info("customer test passed");
        }
        else {
            captureScreen(driver,"addnewCustomer");
            logger.info("customer test is failed");
            Assert.assertTrue(false);
        }
    }
    @DataProvider(name = "NewCustomer")
    public Object[][]passDAta() throws FileNotFoundException {
        return JsonReader.getdata(readCofig.getJsonPath(),"NewCustomer",1,2);

    }
}
