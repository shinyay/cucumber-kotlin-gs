package com.google.shinyay

class Account(initialBalance: Double?) {
    private var balance: Double? = initialBalance

    fun credit(amount: Double?) {
        balance = balance?.plus(amount!!)
    }

    fun getBalance(): Double? {
        return balance
    }
}