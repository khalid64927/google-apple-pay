@file:Suppress("MatchingDeclarationName")
package com.khalid.multiplatform.googleapple.payments

actual interface PaymentInterface {
    actual suspend fun canMakePayments(): Boolean
    actual suspend fun makePayments(
        amount: String,
        callback: (result: Result<String>) -> Unit
    )
}
