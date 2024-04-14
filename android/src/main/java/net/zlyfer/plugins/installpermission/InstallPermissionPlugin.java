package net.zlyfer.plugins.installpermission;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "InstallPermission")
public class InstallPermissionPlugin extends Plugin {

    private static final int REQUEST_CODE = 1;

    @PluginMethod
    public void checkPermission(PluginCall call) {
        JSObject ret = new JSObject();
        // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        boolean hasPermission = getActivity().getPackageManager().canRequestPackageInstalls();
        ret.put("granted", hasPermission);
        // } else {
        //     ret.put("granted", true);
        // }
        call.resolve(ret);
    }

    @PluginMethod
    public void requestPermission(PluginCall call) {
        saveCall(call);

        Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
        intent.setData(Uri.parse("package:" + getActivity().getPackageName()));
        startActivityForResult(call, intent, REQUEST_CODE);

        JSObject ret = new JSObject();
        ret.put("action", "Opened App Settings");
        call.resolve(ret);
    }

    @Override
    protected void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        super.handleOnActivityResult(requestCode, resultCode, data);
        PluginCall call = getSavedCall();
        if (call == null) {
            return;
        }
        if (requestCode == REQUEST_CODE) {
            if (
                getActivity().getApplicationContext().checkSelfPermission(android.Manifest.permission.REQUEST_INSTALL_PACKAGES) ==
                PackageManager.PERMISSION_GRANTED
            ) {
                JSObject ret = new JSObject();
                ret.put("granted", true);
                call.resolve(ret);
            } else {
                JSObject ret = new JSObject();
                ret.put("granted", false);
                call.resolve(ret);
            }
        }
    }
}
