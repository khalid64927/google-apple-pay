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


