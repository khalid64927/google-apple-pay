package com.khalid.multiplatform.googleapple.payments

expect interface PaymentInterface {
    suspend fun canMakePayments(): Boolean
    suspend fun makePayments(amount: String, callback: (result: Result<String>) -> Unit)
}



