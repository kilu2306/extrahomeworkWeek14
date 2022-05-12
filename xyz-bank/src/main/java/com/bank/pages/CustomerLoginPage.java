package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customelistener.CustomListener;
import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {
    public CustomerLoginPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement yourNameDropDownMenu;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement logInButton;
    @FindBy(xpath = "//label[normalize-space()='Your Name :']")
    WebElement yourNametextFeild;


    public void selectYourName(String name){
        Reporter.log("select Your name "+name +"<br>");
        CustomListener.node.log(Status.PASS,"select Your name "+name +"<br>");
        selectByVisibleTextFromDropDown(yourNameDropDownMenu,name);

    }
    public void clickOnLogInButton(){
        CustomListener.node.log(Status.PASS,"click on log in button"+ "br");
        Reporter.log("click on log in button"+ "br");
        clickOnElement(logInButton);
    }
    public String getYourNameText(){
        CustomListener.node.log(Status.PASS,"get text from your name tetx field"+yourNametextFeild.getText()+"br");
        Reporter.log("get text from your name tetx field"+yourNametextFeild.getText()+"br");
        return getTextFromElement(yourNametextFeild);
    }
}
