package com.google.shinyay

import com.google.shinyay.Account
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions.assertEquals


class StepDefinitions {
    private var account: Account? = null

    @Given("account balance is {double}")
    fun givenAccountBalance(initialBalance: Double?) {
        account = Account(initialBalance)
    }

    @When("the account is credited with {double}")
    fun whenAccountIsCredited(amount: Double?) {
        account!!.credit(amount)
    }

    @Then("account should have a balance of {double}")
    fun thenAccountShouldHaveBalance(expectedBalance: Double?) {
        assertEquals(expectedBalance, account!!.getBalance())
    }
}