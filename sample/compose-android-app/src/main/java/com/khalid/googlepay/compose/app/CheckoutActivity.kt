/*
 * Copyright 2024 Mohammed Khalid Hamid.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.khalid.googlepay.compose.app

import android.os.Bundle
import androidx.activity.compose.setContent
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
