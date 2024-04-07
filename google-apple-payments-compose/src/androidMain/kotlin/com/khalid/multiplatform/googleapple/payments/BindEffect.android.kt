package com.khalid.multiplatform.googleapple.payments

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner

@Composable
@Suppress("FunctionNaming")
actual fun BindEffect(paymentInterface: PaymentInterface) {
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    val context: Context = LocalContext.current

    LaunchedEffect(paymentInterface, lifecycleOwner, context) {
        val fragmentManager: FragmentManager = (context as FragmentActivity).supportFragmentManager

        paymentInterface.bind(lifecycleOwner.lifecycle, fragmentManager)
    }
}
