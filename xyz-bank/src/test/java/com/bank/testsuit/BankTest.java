package com.bank.testsuit;

import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BankTest extends TestBase {
    HomePage homePage;
    AddCustomerPage addCustomerPage;
    BankManagerLogInpage bankManagerLogInpage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    CustomersPage customersPage;
    DepositeAccountPage accountPage;
    DepositeAccountPage depositeAccountPage;
    WithdrowAccountPage withdrowAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        addCustomerPage = new AddCustomerPage();
        bankManagerLogInpage = new BankManagerLogInpage();
        openAccountPage = new OpenAccountPage();
        customerLoginPage = new CustomerLoginPage();
        customersPage = new CustomersPage();
        accountPage = new DepositeAccountPage();
        depositeAccountPage = new DepositeAccountPage();
        withdrowAccountPage = new WithdrowAccountPage();


    }

    @Test(groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnManagerLogiNLink();
        bankManagerLogInpage.clickOnAddCustomer();
        addCustomerPage.enterFirstName("dhyani");
        addCustomerPage.enterLastName("patel");
        addCustomerPage.enterPostCode("23456");
        addCustomerPage.clickOnAddCustomerButton();
        String actualText = addCustomerPage.getAlertMessage();
        String expactedText = "Customer added successfully";
        Assert.assertTrue(actualText.contains(expactedText), "displayed message is wrong ");
        addCustomerPage.acceptAlertPopUp();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnManagerLogiNLink();
        bankManagerLogInpage.clickOnOpenAccount();
        openAccountPage.selectCustomerFromDropDown("Harry Potter");
        openAccountPage.selectCurrancyfromDropDown("Pound");
        openAccountPage.clickOnProcessButton();
        String actualText = openAccountPage.getTextFromPopUpWindow();
        String expactedText = "Account created successfully";
        //Assert.assertEquals(actualText,expactedText,"displayed message is wrong ");
        Assert.assertTrue(actualText.contains("Account created successfully"));
        openAccountPage.acceptPopUp();

    }

    @Test(groups = {"smoke", "regression"})
    public void customerShouldLoginAndLogoutSuceessfully() {
        SoftAssert softAssert = new SoftAssert();
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectYourName("Harry Potter");
        customerLoginPage.clickOnLogInButton();
        softAssert.assertTrue(customersPage.customerLogOutButtonIsDisplayed());
        customersPage.clickOnLOgOut();
        softAssert.assertTrue(customerLoginPage.getYourNameText().contains("Your Name"));
        softAssert.assertAll();
    }

    @Test(groups = {"smoke", "regression"})
    public void customerShouldDepositMoneySuccessfully() {
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectYourName("Hermoine Granger");
        customerLoginPage.clickOnLogInButton();
        customersPage.clickOnDepositLink();
        depositeAccountPage.enterAmount("100");
        depositeAccountPage.submitDeposit();
        Assert.assertTrue(depositeAccountPage.getSuccessfullDepositText().contains("Deposit Successful"));
    }

    @Test(groups = {"smoke", "regression"})
    public void customerShouldWithdrawMoneySuccessfully() {
        homePage.clickOnCustomerLoginButton();
        customerLoginPage.selectYourName("Hermoine Granger");
        customerLoginPage.clickOnLogInButton();
        customersPage.clickOnWithdrow();
        withdrowAccountPage.enterAmount("50");
        withdrowAccountPage.clickOnWithdrow();
        String actualText = withdrowAccountPage.getSuccessFullyWithdrowText();
        String expactedText = "Transaction Successful";
        Assert.assertEquals(actualText, expactedText, "displayed message is wrong ");


    }


}
