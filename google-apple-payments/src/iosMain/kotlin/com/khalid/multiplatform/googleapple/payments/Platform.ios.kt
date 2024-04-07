package com.khalid.multiplatform.googleapple.payments

@Suppress("MatchingDeclarationName")
actual interface PaymentInterface {
    actual suspend fun canMakePayments(): Boolean
    actual suspend fun makePayments(
        amount: String,
        callback: (result: Result<String>) -> Unit
    )
}
