package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customelistener.CustomListener;
import com.bank.utilities.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    public AddCustomerPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerButton;




    public void enterFirstName(String name){
        Reporter.log("Enter first Name"+name+firstNameField.toString()+"<br>");
        CustomListener.node.log(Status.PASS,"Enter first Name"+name+firstNameField.toString()+"<br>" );
        sendTextToElement(firstNameField,name);
    }
    public void enterLastName(String lName){
        Reporter.log("Enter last name"+lName+lastName.toString()+"<br>");
        sendTextToElement(lastName,lName);
    }
    public void enterPostCode(String code){
        Reporter.log("Enter Last name "+ code+postCode.toString()+"<br>");
        CustomListener.node.log(Status.PASS,"Enter Last name "+ code+postCode.toString()+"<br>");
        sendTextToElement(postCode,code);
    }
    public  void clickOnAddCustomerButton(){
        Reporter.log("click on customerButton "+addCustomerButton.toString()+"<br>");
        CustomListener.node.log(Status.PASS,"click on customerButton"+addCustomerButton.toString()+"<brb>");
        clickOnElement(addCustomerButton);
    }
    public String getAlertMessage(){
        Reporter.log("get text from pop up window "+"<br>");
        CustomListener.node.log(Status.PASS,"get text from pop up window "+"<br>");
        Alert alert= driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlertPopUp(){
        Reporter.log("closing popUP box" +"<br>");
        CustomListener.node.log(Status.PASS,"closing popUP box"+"<br>");
        Alert alert= driver.switchTo().alert();
        alert.accept();
    }
}
