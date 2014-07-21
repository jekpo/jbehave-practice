package org.aicer.jbehave.automation.steps;

import org.aicer.jbehave.automation.models.Customer;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.testng.Assert;

public class CustomerSteps extends BaseSteps {

    private Customer customer;

    public CustomerSteps() {
        this.customer = new Customer();
    }

    @Given("I am a customer")
    public void givenACustomer() {
        this.customer = new Customer();
    }

    @Given("I am a person")
    public void givenAPerson() {
        this.customer = new Customer();
    }

    @Given("Customer Name is Israel Ekpo")
    public void givenCustomerNameIsIsraelEkpo() {
        this.customer.setName("Israel Ekpo");
    }

    @When("The Customer Name is Set to 18")
    public void whenISetTheAgeTo18(){
        this.customer.setAge(18);
    }

    @Then("Will See that Customer is an Adult")
    public void thenCustomerIsAdult() {
        Assert.assertTrue(this.customer.isAdult());
    }
}
