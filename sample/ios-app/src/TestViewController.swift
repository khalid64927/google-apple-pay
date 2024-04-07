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
        
        viewModel = SampleViewModel(paymentInterface: ApplePayImpl())
    }
    
    @IBAction func onPermissionPressed() {
        viewModel.makePayment("10")
    }
}
