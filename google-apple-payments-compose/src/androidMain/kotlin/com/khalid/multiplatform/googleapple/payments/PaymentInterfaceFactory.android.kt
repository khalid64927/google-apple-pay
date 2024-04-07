package com.khalid.multiplatform.googleapple.payments

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun rememberPaymentInterfaceFactory(): PaymentInterfaceFactory {
    val context: Context = LocalContext.current
    return remember(context) {
        PaymentInterfaceFactory { config ->
            GooglePayModelImpl(context = context, config = config  )
        }
    }
}
