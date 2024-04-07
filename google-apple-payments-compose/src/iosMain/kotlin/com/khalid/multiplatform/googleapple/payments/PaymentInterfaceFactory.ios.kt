package com.khalid.multiplatform.googleapple.payments

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
actual fun rememberPaymentInterfaceFactory(): PaymentInterfaceFactory {
    return remember {
        PaymentInterfaceFactory { config ->
            ApplePayModelImpl(config = config)
        }
    }
}
