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

package com.icerockdev.library


import dev.icerock.moko.mvvm.viewmodel.ViewModel
import com.khalid.multiplatform.googleapple.payments.onFailure
import com.khalid.multiplatform.googleapple.payments.onSuccess
import com.khalid.multiplatform.googleapple.payments.PaymentInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SampleViewModel(
    val paymentInterface: PaymentInterface,
) : ViewModel() {

    private val _paymentUiState: MutableStateFlow<PaymentUiState> = MutableStateFlow(PaymentUiState.NotStarted)
    val paymentUiState: StateFlow<PaymentUiState> = _paymentUiState.asStateFlow()

    init {
        viewModelScope.launch {
            fetchCanUseGooglePay()
        }
    }

    /**
     * Determine the user's ability to pay with a payment method supported by your app and display
     * a Google Pay payment button.
    */
    @Suppress("TooGenericExceptionCaught")
    private suspend fun fetchCanUseGooglePay() {
        val result = paymentInterface.canMakePayments()
        val newUiState: PaymentUiState = try {
            if (result) {
                println("Available")
                PaymentUiState.Available
            } else {
                println("Error")
                PaymentUiState.Error("Payment not available")
            }
        } catch (exception: Exception) {
            PaymentUiState.Error(exception.message ?: "")
        }

        _paymentUiState.update { newUiState }
    }

    fun makePayments(amount: String) {
        viewModelScope.launch {
            paymentInterface.makePayments(amount) {
                it.onSuccess {
                    _paymentUiState.update { PaymentUiState.PaymentCompleted }
                }.onFailure { exception ->
                    _paymentUiState.update { PaymentUiState.PaymentFailed(exception.message ?: "") }
                }
            }
        }
    }
}

@Suppress("UnnecessaryAbstractClass")
abstract class PaymentUiState internal constructor() {
    object NotStarted : PaymentUiState()
    object Available : PaymentUiState()
    object PaymentCompleted : PaymentUiState()
    class PaymentFailed(val reason: String) : PaymentUiState()
    class Error(val message: String) : PaymentUiState()
}
