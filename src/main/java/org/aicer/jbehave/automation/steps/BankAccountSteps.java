package org.aicer.jbehave.automation.steps;

import org.aicer.jbehave.automation.models.BankAccount;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.testng.Assert;

public class BankAccountSteps extends BaseSteps {

    private BankAccount bankAccount;

    @Given("I have a Bank Account")
    public void givenIHaveABankAccount() {
        this.bankAccount = new BankAccount();
    }

    @Given("I have a starting balance of $0.00")
    public void anIHaveADefaultStartingBalance() {
        this.bankAccount.setBalance(0.00);
    }

    @When("I make a $50.00 deposit")
    public void makeDepositOfFiftyDollars() {
        this.bankAccount.setBalance(50.00);
    }

    @Then("I will see that my balance is $50.00")
    public void verifyDepositIsFiftyDollars() {
        Assert.assertEquals(this.bankAccount.getBalance(), 50.00);
    }
}
