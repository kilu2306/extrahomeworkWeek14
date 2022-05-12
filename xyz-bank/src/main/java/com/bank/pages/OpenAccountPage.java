package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customelistener.CustomListener;
import com.bank.utilities.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerDropDownMenu;
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyDropDown;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;


    public void selectCustomerFromDropDown(String name){
        CustomListener.node.log(Status.PASS,"select customer "+name+"<br>");
        Reporter.log("select customer "+name+"<br>");
        selectByVisibleTextFromDropDown(customerDropDownMenu,name);
    }
    public void selectCurrancyfromDropDown(String currency){
        CustomListener.node.log(Status.PASS,"select currancy "+currency+"<br>");
        Reporter.log("select currancy "+currency+"<br>");
        selectByVisibleTextFromDropDown(currencyDropDown,currency);
    }
    public void clickOnProcessButton(){
        CustomListener.node.log(Status.PASS,"click on process "+"<br>");
        Reporter.log("click on process "+"<br>");
        clickOnElement(processButton);
    }
    public String  getTextFromPopUpWindow(){
        CustomListener.node.log(Status.PASS,"get text frpm popup window "+"<br>");
        Reporter.log("get text frpm popup window "+"<br>");
        Alert alert= driver.switchTo().alert();
        return alert.getText();
    }
    public void acceptPopUp(){
        CustomListener.node.log(Status.PASS,"Accept popup"+"<br>");
        Reporter.log("Accept popup"+"<br>");
        Alert alert= driver.switchTo().alert();
        alert.accept();
    }
}
