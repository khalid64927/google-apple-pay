@file:Suppress("MatchingDeclarationName")
package com.khalid.multiplatform.googleapple.payments


import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle

actual interface PaymentInterface {
    actual suspend fun canMakePayments(): Boolean
    actual suspend fun makePayments(
        amount: String,
        callback: (result: Result<String>) -> Unit
    )
    fun bind(lifecycle: Lifecycle, fragmentManager: FragmentManager)

    companion object {
        operator fun invoke(
            context: Context,
            config: PaymentConfig
        ): PaymentInterface {
            return GooglePayModelImpl(context, config)
        }
    }
}

