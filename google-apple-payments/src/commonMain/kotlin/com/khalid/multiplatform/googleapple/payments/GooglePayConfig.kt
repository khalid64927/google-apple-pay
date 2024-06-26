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

data class GooglePayConfig(
    /**
     * sample : example
     * */
    val gateway: String,
    /**
     * sample : exampleGatewayMerchantId
     * */
    val gatewayMerchantId: String,
    val merchantName: String,
    /**
     * sample : SG, US, GB
     * */
    val countryCode: String,
    /**
     * sample : SGD, USD, GBP
     * */
    val currencyCode: String,

    val shippingDetails: ShippingDetails?,

    /**
     * sample : listOf( "AMEX", "DISCOVER", "JCB", "MASTERCARD", "VISA")
     * */
    val allowedCards: List<String>,

    /**
     * sample :  listOf("PAN_ONLY", "CRYPTOGRAM_3DS")
     * */
    val supportedMethods: List<SupportedMethods>,
    val paymentsEnvironment: Int = 3 // WalletConstants.ENVIRONMENT_TEST
)

data class ShippingDetails(
    /**
     * sample: listOf("US", "GB", "SG")
     * **/
    val shippingCountryCodeList: List<String>,
    val phoneNumberRequired: Boolean)


enum class SupportedMethods {
    PAN_ONLY, CRYPTOGRAM_3DS
}

//enum class GPAY_ENV {
//    TEST, PROD
//}

