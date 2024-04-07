package com.khalid.multiplatform.googleapple.payments



data class PaymentConfig(
    /**
     * The merchant’s two-letter ISO 3166 country code.
     *
     * required by Apple and Google Pay
     * */
    val countryCode: String,
    /**
     * The three-letter ISO 4217 currency code that determines the
     * currency the payment request uses.
     *
     * required by Apple and Google Pay
     * */
    val currencyCode: String,

    /**
     * required by Google Pay
     * */
    val allowBillingAddress: Boolean = false,

    /**
     *  required by Apple and Google Pay
     * */
    val allowedCards: List<AllowedCards>,

    /**
     *  required by Apple and Google Pay
     * */
    val supportedCards : List<SupportedCardMethods>,

    /**
     * required by Apple Pay
     * */
    val label: String = "",

    /**
     * sample : example
     *
     * required by Google Pay
     * */
    val gateway: String = "",
    /**
     * sample : exampleGatewayMerchantId
     *
     * required by Apple and Google Pay
     * */
    val gatewayMerchantId: String = "",
    /**
     * required by Google Pay
     * */
    val merchantName: String = "",


    /**
     * required by Google Pay
     * */
    val shippingDetails: ShippingDetails? = null,

    /**
     * required by Google Pay
     * */
    val paymentsEnvironment: Int = 3, // WalletConstants.ENVIRONMENT_TEST



)

enum class AllowedCards {
    VISA,
    MASTERCARD,
    AMEX,
    JCB, // Only supported by GooglePay
    DISCOVER
}

enum class SupportedCardMethods {
    PAN_ONLY,                   // supported only by GooglePay
    /**
     * supported by ApplePay with value Capability3DS
     * supported by GooglePay with value CRYPTOGRAM_3DS
     * */
    CRYPTOGRAM_3DS,             // supported by both Apple and Google Pay
    CapabilityInstantFundsOut,  // supported only by ApplePay
    /**
     * Chip based CC
     * */
    CapabilityEMV,              // supported only by ApplePay
    CapabilityCredit,           // supported only by ApplePay
    CapabilityDebit,            // supported only by ApplePay
}
