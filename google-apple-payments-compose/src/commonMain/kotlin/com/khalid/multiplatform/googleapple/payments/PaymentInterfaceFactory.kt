/*
 * Copyright 2023 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.khalid.multiplatform.googleapple.payments

import androidx.compose.runtime.Composable

fun interface PaymentInterfaceFactory {
    fun createPaymentClient(config: PaymentConfig): PaymentInterface
}

@Composable
expect fun rememberPaymentInterfaceFactory(): PaymentInterfaceFactory
