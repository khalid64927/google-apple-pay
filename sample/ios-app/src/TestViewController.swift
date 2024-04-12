//
//  Created by Aleksey Mikhailov on 23/06/2019.
//  Copyright © 2019 IceRock Development. All rights reserved.
//

import UIKit
import MultiPlatformLibrary

class TestViewController: UIViewController {
    
    @IBOutlet private var label: UILabel!
    
    private var viewModel: SampleViewModel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        label.text = "wait press..."
        
        viewModel = SampleViewModel(paymentInterface: ApplePayModelImpl(
            config: PaymentConfig(
                countryCode: "SG",
                currencyCode: "SGD",
                allowBillingAddress: false,
                allowedCards: [.amex, .visa, .discover, .mastercard, .jcb],
                supportedCards: [
                    .capabilitycredit, .capabilitydebit, .capabilityemv, .capabilityinstantfundsout, .cryptogram3ds],
                label: "msta",
                gateway: "gateway",
                gatewayMerchantId: "gatewayMerchantId",
                merchantName: "msta",
                shippingDetails: nil,
                paymentsEnvironment: 3) ))
    }
    
    @IBAction func onPermissionPressed() {
        viewModel.makePayments(amount: "100")
    }
}
