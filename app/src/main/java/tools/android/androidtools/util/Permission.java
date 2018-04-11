package tools.android.androidtools.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import static android.Manifest.permission.*;


public class Permission {

    public static void getSms(Activity activity) {
        getPermission(activity, READ_SMS);
    }

    public static void getCamera(Activity activity) {
        getPermission(activity, CAMERA);
    }

    public static void getContacts(Activity activity) {
        getPermission(activity, READ_CONTACTS);
    }

    public static void getLocation(Activity activity) {
        getPermission(activity, ACCESS_FINE_LOCATION);
    }

    public static void getMicrophone(Activity activity) {
        getPermission(activity, RECORD_AUDIO);
    }

    public static void getPhone(Activity activity) {
        getPermission(activity, READ_PHONE_STATE);
    }

    public static void getSensors(Activity activity) {
        getPermission(activity, BODY_SENSORS);
    }

    public static void getStorage(Activity activity) {
        getPermission(activity, READ_EXTERNAL_STORAGE);
    }

    private static void getPermission(Activity activity, String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int permissionCheck = ContextCompat.checkSelfPermission(activity,permission);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity,new String[]{permission},permissionCheck);
            }
        }
    }

}
