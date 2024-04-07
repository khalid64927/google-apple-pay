package com.icerockdev.library

import com.khalid.multiplatform.googleapple.payments.PaymentInterface
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import com.khalid.multiplatform.googleapple.payments.onFailure
import com.khalid.multiplatform.googleapple.payments.onSuccess
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
    ) */
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
abstract class PaymentUiState internal constructor(){
    object NotStarted : PaymentUiState()
    object Available : PaymentUiState()
    object PaymentCompleted : PaymentUiState()
    class PaymentFailed(val reason: String) : PaymentUiState()
    class Error(val message: String) : PaymentUiState()
}
