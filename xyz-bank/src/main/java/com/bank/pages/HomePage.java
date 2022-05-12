package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customelistener.CustomListener;
import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    WebElement bankManagerLoginField;
    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement customerLoginButton;

    public void clickOnManagerLogiNLink(){
        CustomListener.node.log(Status.PASS,"click on manager link"+bankManagerLoginField.toString()+"<br>");
        Reporter.log("click on manager link"+bankManagerLoginField.toString()+"<br>");
        clickOnElement(bankManagerLoginField);
    }
    public void clickOnCustomerLoginButton(){
        CustomListener.node.log(Status.PASS,"click on log in button"+"<br>");
        Reporter.log("click on log in button"+"<br>");
        clickOnElement(customerLoginButton);
    }
}
