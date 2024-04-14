import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(InstallPermissionPlugin)
public class InstallPermissionPlugin: CAPPlugin {
    private let implementation = InstallPermission()

    @objc func checkPermission(_ call: CAPPluginCall) {
        call.reject("Not implemented on iOS.")
    }

    @objc func requestPermission(_ call: CAPPluginCall) {
        call.reject("Not implemented on iOS.")
    }
}
