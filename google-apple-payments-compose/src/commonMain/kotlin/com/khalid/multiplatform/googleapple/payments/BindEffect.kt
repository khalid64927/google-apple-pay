/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.khalid.multiplatform.googleapple.payments

import androidx.compose.runtime.Composable

@Suppress("FunctionNaming")
@Composable
expect fun BindEffect(paymentInterface: PaymentInterface)
