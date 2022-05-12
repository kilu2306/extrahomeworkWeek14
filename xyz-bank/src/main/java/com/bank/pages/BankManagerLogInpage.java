package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customelistener.CustomListener;
import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BankManagerLogInpage extends Utility {
    public BankManagerLogInpage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomer;
    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccount;




    public void clickOnAddCustomer(){

        Reporter.log("click on add customer"+addCustomer.toString()+"<br>");
        CustomListener.node.log(Status.PASS,"click on add customer "+addCustomer.toString()+"<br>");
        clickOnElement(addCustomer);
    }
    public void clickOnOpenAccount(){
        CustomListener.node.log(Status.PASS,"click on open account "+openAccount.toString()+"<br>");
        Reporter.log(("click on open account "+openAccount.toString()+"<br>"));
        clickOnElement(openAccount);
    }
}
