package com.ebanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public static WebDriver ldriver;
    @FindBy(name = "uid")
    private WebElement userName;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "btnLogin")
    private WebElement loginButton;
    @FindBy(xpath = "//a[@href='Logout.php']")
    private WebElement logOutButton;
    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
    public void setUserName(String uname){
        userName.sendKeys(uname);
   }
    public void setPassword(String pass){
        password.sendKeys(pass);
   }
   public void clickButton(){
        loginButton.click();
   }
   public void ClickLogOut(){
        logOutButton.click();
   }
}
