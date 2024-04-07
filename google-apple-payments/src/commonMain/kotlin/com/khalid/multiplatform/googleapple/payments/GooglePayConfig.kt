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

