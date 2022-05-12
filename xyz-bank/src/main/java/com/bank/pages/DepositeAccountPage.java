package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customelistener.CustomListener;
import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DepositeAccountPage extends Utility {
    public DepositeAccountPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountField;
    @FindBy(xpath = "//div[@class=\"form-group\"]/following-sibling::button[@type=\"submit\"]")
    WebElement depositButton;
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement successfullDepositText;
    public  void enterAmount(String num){
        CustomListener.node.log(Status.PASS,"enter amount"+ num+ "to amount filed"+"<br>");
        Reporter.log("enter amount"+ num+ "to amount filed"+"<br>");
        sendTextToElement(amountField,num);
    }
    public  void submitDeposit(){
        CustomListener.node.log(Status.PASS,"click on deposit button"+"<br>");
        Reporter.log("click on deposit button"+"<br>");
        clickOnElement(depositButton);

    }
    public String getSuccessfullDepositText(){
        CustomListener.node.log(Status.PASS,"get succefful deposit text"+successfullDepositText.getText()+"<br>");
        Reporter.log("get succefful deposit text"+successfullDepositText.getText()+"<br>");
        return successfullDepositText.getText();
    }


}
