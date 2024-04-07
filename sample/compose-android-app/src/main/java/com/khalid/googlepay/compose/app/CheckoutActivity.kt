package com.khalid.googlepay.compose.app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.appcompat.app.AppCompatActivity
import com.icerockdev.library.PaymentUiState
import com.icerockdev.library.SampleViewModel
import com.khalid.multiplatform.googleapple.payments.AllowedCards
import com.khalid.multiplatform.googleapple.payments.GooglePayModelImpl
import com.khalid.multiplatform.googleapple.payments.PaymentConfig
import com.khalid.multiplatform.googleapple.payments.SupportedCardMethods
import dev.icerock.moko.mvvm.getViewModel


class CheckoutActivity : AppCompatActivity() {


    private val paymentConfig = PaymentConfig(
        gateway = "example",
        gatewayMerchantId = "exampleGatewayMerchantId",
        merchantName = "MSTA",
        countryCode = "SG",
        currencyCode = "SDG",
        allowedCards = listOf(
            AllowedCards.AMEX,
            AllowedCards.VISA,
            AllowedCards.MASTERCARD,
            AllowedCards.JCB,
            AllowedCards.DISCOVER,
        ),
        supportedCards = listOf(
            SupportedCardMethods.PAN_ONLY,
            SupportedCardMethods.CRYPTOGRAM_3DS)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val model = getViewModel {
                SampleViewModel(
                    paymentInterface = GooglePayModelImpl(this, paymentConfig)
                )
            }.also {
                it.paymentInterface.bind(lifecycle, supportFragmentManager)
            }
            val payState: PaymentUiState by model.paymentUiState.collectAsStateWithLifecycle()
            ProductScreen(
                viewModel = model,
                productScreenData = ProductScreenData(
                    title = "Men's Tech Shell Full-Zip",
                    description = "A versatile full-zip that you can wear all day long and even...",
                    price = "$50.20",
                    image = R.drawable.ts_10_11019a
                ),
                payUiState = payState,
                onGooglePayButtonClick = {
                    model.makePayments("100")
                },
            )
        }
    }
}
