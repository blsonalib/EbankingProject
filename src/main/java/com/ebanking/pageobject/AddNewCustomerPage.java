package com.ebanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage{
    public static WebDriver lDriver;
    public AddNewCustomerPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver,this);
    }
    @FindBy( how = How.XPATH,using = "//a[@href='addcustomerpage.php']")
    private WebElement clickOnNewCustomer;
    @FindBy(how = How.NAME,using = "name")
    private WebElement customerName;
    @FindBy(how = How.NAME,using = "rad1")
    private WebElement gender;
    @FindBy(how = How.ID_OR_NAME,using = "dob")
    private WebElement dateOfBirth;
    @FindBy(how = How.NAME,using = "addr")
    private WebElement address;
    @FindBy(how = How.NAME,using = "city")
    private WebElement city;
    @FindBy(how = How.NAME,using = "state")
    private WebElement state;
    @FindBy(how = How.NAME,using = "pinno")
    private WebElement pinNumber;
    @FindBy (how = How.NAME,using = "telephoneno")
    private WebElement mobileNumber;
    @FindBy(how = How.NAME,using = "emailid")
    private WebElement email;
    @FindBy(how = How.NAME,using = "password")
    private WebElement password;
    @FindBy(how = How.NAME,using = "sub")
    private WebElement submitButton;

    public void clickOnNewCustomer(){
        clickOnNewCustomer.click();
    }
    public void setCustomeName(String customername){
        customerName.sendKeys(customername);
    }
   public void clickGender(){
        gender.click();
   }
   public void setDateOfbirth(String mm,String dd,String yy){
       Select dob = new Select(dateOfBirth);
       dob.selectByVisibleText(dd);
       dob.selectByVisibleText(mm);
       dob.selectByVisibleText(yy);
   }
   public void setAddress(String address1){
        address.sendKeys(address1);
   }
   public void setCity(String cityName){
        city.sendKeys(cityName);
   }
   public void setState(String stateName){
        state.sendKeys(stateName);
   }
   public void setPincode(String pincode){
        pinNumber.sendKeys(String.valueOf(pincode));
   }
   public void setMobileNumber(String mobileNo){
        mobileNumber.sendKeys(mobileNo);
   }
   public void setEmail(String emailId){
        email.sendKeys(emailId);
   }
   public void setPassword(String pass){
        password.sendKeys(pass);
   }
   public void clickSubmit(){
        submitButton.click();
   }
}
