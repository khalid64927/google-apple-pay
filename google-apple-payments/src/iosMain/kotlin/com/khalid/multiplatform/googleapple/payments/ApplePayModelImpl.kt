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

import platform.Foundation.NSDecimalNumber
import platform.Foundation.NSLog
import platform.PassKit.PKMerchantCapability3DS
import platform.PassKit.PKPayment
import platform.PassKit.PKPaymentAuthorizationStatus
import platform.PassKit.PKPaymentAuthorizationViewController
import platform.PassKit.PKPaymentAuthorizationViewControllerDelegateProtocol
import platform.PassKit.PKPaymentNetworkAmex
import platform.PassKit.PKPaymentNetworkDiscover
import platform.PassKit.PKPaymentNetworkMasterCard
import platform.PassKit.PKPaymentNetworkVisa
import platform.PassKit.PKPaymentRequest
import platform.PassKit.PKPaymentSummaryItem
import platform.UIKit.UIApplication
import platform.darwin.NSObject

@Suppress("ForbiddenComment")
class ApplePayModelImpl(val config: PaymentConfig) : PaymentInterface {

    override suspend fun canMakePayments(): Boolean {
        return PKPaymentAuthorizationViewController.canMakePayments()
    }

    override suspend fun makePayments(amount: String, callback: (result: Result<String>) -> Unit) {
        val paymentRequest = PKPaymentRequest()
        paymentRequest.merchantIdentifier = config.gatewayMerchantId
        paymentRequest.countryCode = config.countryCode
        paymentRequest.currencyCode = config.currencyCode
        paymentRequest.supportedNetworks = listOf(
            PKPaymentNetworkVisa,
            PKPaymentNetworkMasterCard,
            PKPaymentNetworkAmex,
            PKPaymentNetworkDiscover
        )
        paymentRequest.merchantCapabilities = PKMerchantCapability3DS

        val paymentItem = PKPaymentSummaryItem()
        paymentItem.label = config.label
        paymentItem.amount = NSDecimalNumber(amount)

        paymentRequest.paymentSummaryItems = listOf(paymentItem)



        /**
         * TODO:
         * {"message":"This method does I/O on the main thread underneath that can lead to UI
         * responsiveness issues when called on main thread. Consider ways to optimize this
         * code path","antipattern trigger":"-[NSBundle bundleIdentifier]","message type":
         * "suppressable","show in console":"0"}
         * */
        val paymentController = PKPaymentAuthorizationViewController(paymentRequest = paymentRequest)
        paymentController.delegate = PaymentAuthorizationDelegate(callback)

        val window = UIApplication.sharedApplication.keyWindow
        window?.rootViewController?.presentViewController(paymentController, animated = true, completion = null)

    }

}

private class PaymentAuthorizationDelegate(private val callback: (result: Result<String>) -> Unit) : NSObject(),
    PKPaymentAuthorizationViewControllerDelegateProtocol {
    override fun paymentAuthorizationViewController(
        controller: PKPaymentAuthorizationViewController,
        didAuthorizePayment: PKPayment,
        completion: (PKPaymentAuthorizationStatus) -> Unit
    ) {
        NSLog("Payment authorized")
        // Handle payment authorization here
        completion(PKPaymentAuthorizationStatus.PKPaymentAuthorizationStatusSuccess)
        // Token will be empty on Simulator
        NSLog("Payment token ${didAuthorizePayment.token.paymentData}")
        callback(Result.Success(PKPaymentAuthorizationStatus.PKPaymentAuthorizationStatusSuccess.name))

    }

    override fun paymentAuthorizationViewControllerDidFinish(controller: PKPaymentAuthorizationViewController) {
        NSLog("Payment finished")
        controller.dismissViewControllerAnimated(true, completion = null)
    }
}
