package com.khalid.multiplatform.googleapple.payments

import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.wallet.PaymentData
import kotlinx.coroutines.launch


@Suppress("")
internal class ResolverFragment : Fragment() {

    init {
        retainInstance = true
    }

    private var callback: (Result<String>) -> Unit = {}

    @Suppress("MaxLineLength")
    private val resolveGooglePayLauncher = registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) {
            result: ActivityResult ->
        when (result.resultCode) {
            RESULT_OK -> {
                runCatching {
                    result.data?.let { intent ->
                        PaymentData.getFromIntent(intent)?.let {
                            callback(Result.Success(it.toJson()))
                        }
                    }
                }.onFailure {
                    callback(Result.Failure(it))
                }
            }
            RESULT_CANCELED -> {
                callback(Result.Failure(Exception("RESULT_CANCELED")))
            }
        }
    }

    fun resolvePayment(resolvableApiException: ResolvableApiException, callback: (Result<String>) -> Unit) {
        this.callback = callback
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                resolveGooglePayLauncher.launch(
                    IntentSenderRequest.Builder(resolvableApiException.resolution).build())
            }
        }


    }
}
