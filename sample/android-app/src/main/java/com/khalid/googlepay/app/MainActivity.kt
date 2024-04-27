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

package com.khalid.googlepay.app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.wallet.button.ButtonOptions
import com.google.android.gms.wallet.button.PayButton
import com.icerockdev.library.PaymentUiState
import com.icerockdev.library.SampleViewModel
import com.khalid.googlepay.app.databinding.ActivityMainBinding
import com.khalid.multiplatform.googleapple.payments.AllowedCards
import com.khalid.multiplatform.googleapple.payments.GooglePayModelImpl
import com.khalid.multiplatform.googleapple.payments.PaymentConfig
import com.khalid.multiplatform.googleapple.payments.SupportedCardMethods
import dev.icerock.moko.mvvm.getViewModel
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    private lateinit var googlePayButton: PayButton
    private lateinit var layoutBinding: ActivityMainBinding
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
    private lateinit var viewModel: SampleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    private fun initializeUi() {
        // Use view binding to access the UI elements
        layoutBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layoutBinding.getRoot())

        viewModel = getViewModel {
            SampleViewModel(
                paymentInterface = GooglePayModelImpl(this, paymentConfig)
            )
        }.also {
            it.paymentInterface.bind(lifecycle, supportFragmentManager)
        }

        // The Google Pay button is a layout file – take the root view
        googlePayButton = layoutBinding.googlePayButton
        try {
            googlePayButton.initialize(
                ButtonOptions.newBuilder()
                    .setAllowedPaymentMethods(
                        JSONArray(listOf(
                        AllowedCards.AMEX.name,
                        AllowedCards.VISA.name,
                        AllowedCards.MASTERCARD.name,
                        AllowedCards.JCB.name,
                        AllowedCards.DISCOVER.name,

                    )).toString())
                    .build()
            )
            googlePayButton.setOnClickListener(this::requestPayment)
            lifecycleScope.launch {
                viewModel.paymentUiState.collect { state ->
                    handlePaymentUiState(state)
                }
            }
        } catch (e: JSONException) {
            println("exception ${e.cause}")
            // Keep Google Pay button hidden (consider logging this to your app analytics service)
        }
    }

    private fun handlePaymentUiState(state: PaymentUiState) {
        when (state) {
            is PaymentUiState.NotStarted -> {
                println("MA: NotStarted")
            }

            is PaymentUiState.Available -> {
                println("MA: Available")
                googlePayButton.visibility = View.VISIBLE
            }

            is PaymentUiState.PaymentCompleted -> {
                println("MA:PaymentCompleted")
            }

            is PaymentUiState.PaymentFailed -> {
                println("MA:PaymentFailed")
            }

            is PaymentUiState.Error -> {
                println("MA:Error")
                googlePayButton.visibility = View.INVISIBLE
            }
        }
    }

    private fun requestPayment(view: View?) {
        println("requestPayment ${view?.id}")
        viewModel.makePayments("10")
    }
}
