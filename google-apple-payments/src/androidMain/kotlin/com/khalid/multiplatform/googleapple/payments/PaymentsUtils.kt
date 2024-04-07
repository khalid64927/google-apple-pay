package com.khalid.multiplatform.googleapple.payments

import android.content.Context
import com.google.android.gms.wallet.PaymentsClient
import com.google.android.gms.wallet.Wallet
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.math.BigDecimal
import java.math.RoundingMode

@Suppress("VariableNaming", "MagicNumber")
class PaymentsUtils(private val config: PaymentConfig) {

    private val CENTS = BigDecimal(100)
    /**
     * Gateway Integration: Identify your gateway and your app's
     * gateway merchant identifier.
     *
     *
     * The Google Pay API response will return an encrypted payment
     * method capable of being charged by a supported gateway after
     * payer authorization.
     *
     *
     * @return Payment data tokenization for the CARD payment method.
     * @throws JSONException
     * See [PaymentMethodTokenizationSpecification]
     * (https://developers.google.com/pay/api/android/
     * reference/object.PaymentMethodTokenizationSpecification)
     */
    private fun gatewayTokenizationSpecification(): JSONObject {
        return JSONObject().apply {
            put("type", "PAYMENT_GATEWAY")
            put("parameters", JSONObject(PAYMENT_GATEWAY_TOKENIZATION_PARAMETERS))
        }
    }

    /**
     * Custom parameters required by the processor/gateway.
     * In many cases, your processor / gateway will only require a gatewayMerchantId.
     * Please refer to your processor's documentation for more information. The number of parameters
     * required and their names vary depending on the processor.
     *
     * @value #PAYMENT_GATEWAY_TOKENIZATION_PARAMETERS
     */
    private val PAYMENT_GATEWAY_TOKENIZATION_PARAMETERS = mapOf(
        "gateway" to config.gateway,
        "gatewayMerchantId" to config.gatewayMerchantId
    )

    /**
     * Create a Google Pay API base request object with properties used in all requests.
     *
     * @return Google Pay API base request object.
     * @throws JSONException
     */
    private val baseRequest = JSONObject().apply {
        put("apiVersion", 2)
        put("apiVersionMinor", 0)
    }

    /**
     * Card networks supported by your app and your gateway.
     *
     *
     * @return Allowed card networks
     * See [CardParameters]
     * (https://developers.google.com/pay/api/android/reference/object.CardParameters)
     */
    private val allowedCardNetworks = JSONArray(config.allowedCards.map { it.name }.toString())

    /**
     * Card authentication methods supported by your app and your gateway.
     *
     * @return Allowed card authentication methods.
     * See [CardParameters](https://developers.google.com/pay/api/android/reference/object.CardParameters)
     */
    private val allowedCardAuthMethods = JSONArray(
        listOf(SupportedMethods.PAN_ONLY.name, SupportedMethods.CRYPTOGRAM_3DS.name))

    /**
     * Information about the merchant requesting payment information
     *
     * @return Information about the merchant.
     * @throws JSONException
     * See [MerchantInfo](https://developers.google.com/pay/api/android/reference/object.MerchantInfo)
     */
    private val merchantInfo: JSONObject =
        JSONObject().put("merchantName", config.merchantName)


    /**
     * Describe your app's support for the CARD payment method.
     *
     *
     * The provided properties are applicable to both an IsReadyToPayRequest and a
     * PaymentDataRequest.
     *
     * @return A CARD PaymentMethod object describing accepted cards.
     * @throws JSONException
     * See [PaymentMethod](https://developers.google.com/pay/api/android/reference/object.PaymentMethod)
     */
    // Optionally, you can add billing address/phone number associated with a CARD payment method.
    private fun baseCardPaymentMethod(): JSONObject {
        return JSONObject().apply {

            val parameters = JSONObject().apply {
                put("allowedAuthMethods", allowedCardAuthMethods)
                put("allowedCardNetworks", allowedCardNetworks)
                put("billingAddressRequired", null != config.shippingDetails)
                put("billingAddressParameters", JSONObject().apply {
                    put("format", "FULL")
                })
            }

            put("type", "CARD")
            put("parameters", parameters)
        }
    }

    /**
     * Describe the expected returned payment data for the CARD payment method
     *
     * @return A CARD PaymentMethod describing accepted cards and optional fields.
     * @throws JSONException
     * See [PaymentMethod](https://developers.google.com/pay/api/android/reference/object.PaymentMethod)
     */
    private fun cardPaymentMethod(): JSONObject {
        val cardPaymentMethod = baseCardPaymentMethod()
        cardPaymentMethod.put("tokenizationSpecification",
            gatewayTokenizationSpecification()
        )

        return cardPaymentMethod
    }

    /**
     * An object describing accepted forms of payment by your app, used to determine a viewer's
     * readiness to pay.
     *
     * @return API version and payment methods supported by the app.
     * See [IsReadyToPayRequest](https://developers.google.com/pay/api/android/reference/object.IsReadyToPayRequest)
     */
    fun isReadyToPayRequest(): JSONObject? {
        return try {
            baseRequest.apply {
                put("allowedPaymentMethods", JSONArray().put(baseCardPaymentMethod()))
            }
        } catch (e: JSONException) {
            println("exception in isReadyToPayRequest ${e.cause}")
            null
        }
    }



    /**
     * Creates an instance of [PaymentsClient] for use in an [Context] using the
     * environment and theme set in [Constants].
     *
     * @param context from the caller activity.
     */
    fun createPaymentsClient(context: Context): PaymentsClient {
        val walletOptions = Wallet.WalletOptions.Builder()
            .setEnvironment(config.paymentsEnvironment)
            .build()

        return Wallet.getPaymentsClient(context, walletOptions)
    }

    /**
     * Provide Google Pay API with a payment amount, currency, and amount status.
     *
     * @return information about the requested payment.
     * @throws JSONException
     * See [TransactionInfo](https://developers.google.com/pay/api/android/reference/object.TransactionInfo)
     */
    @Throws(JSONException::class)
    private fun getTransactionInfo(price: String): JSONObject {
        return JSONObject().apply {
            put("totalPrice", price)
            put("totalPriceStatus", "FINAL")
            put("countryCode", config.countryCode)
            put("currencyCode", config.currencyCode)
        }
    }

    /**
     * An object describing information requested in a Google Pay payment sheet
     *
     * @return Payment data expected by your app.
     * See [PaymentDataRequest](https://developers.google.com/pay/api/android/reference/object.PaymentDataRequest)
     */
    fun getPaymentDataRequest(priceCents: Long): JSONObject {
        val shippingDetails = config.shippingDetails
        val shippingCountryCodeList = shippingDetails?.shippingCountryCodeList.orEmpty()
        val phoneNumberRequired = shippingDetails?.phoneNumberRequired ?: false
        return baseRequest.apply {
            put("allowedPaymentMethods", JSONArray().put(cardPaymentMethod()))
            put("transactionInfo", getTransactionInfo(priceCents.centsToString()))
            put("merchantInfo", merchantInfo)

            // An optional shipping address requirement is a top-level property of the
            // PaymentDataRequest JSON object.
            val shippingAddressParameters = JSONObject().apply {
                put("phoneNumberRequired", phoneNumberRequired)
                put("allowedCountryCodes", JSONArray(shippingCountryCodeList))
            }
            put("shippingAddressParameters", shippingAddressParameters)
            put("shippingAddressRequired", true)
        }
    }

    /**
     * Converts cents to a string format accepted by [getPaymentDataRequest].
     */
    private fun Long.centsToString() = BigDecimal(this)
        .divide(CENTS)
        .setScale(2, RoundingMode.HALF_EVEN)
        .toString()
}

