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

package com.khalid.multiplatform.googleapple.payments


data class ApplePayConfig(
    val productName: String,
    val merchantIdentifier: String,
    val countryCode: String,
    val currencyCode: String,

    /**
     * ios supported values : listOf( "AMEX", "MASTERCARD", "VISA")
     * */
    val allowedCards: List<String>,
)

/**
 * https://developer.apple.com/documentation/passkit_apple_pay_and_wallet/pkmerchantcapability?language=objc
 * 3DS, DEBIT, CREDIT, EMV, INSTANT_FUNDS_OUT
 * */
enum class MerchantCapabilities {
    CapabilityInstantFundsOut, Capability3DS, CapabilityEMV, CapabilityCredit, CapabilityDebit,
}


