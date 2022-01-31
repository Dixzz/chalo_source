package com.urbanairship.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.urbanairship.Autopilot;
import com.urbanairship.UAirship;

public class HelperActivity extends Activity {
    public static int g;
    public ResultReceiver f;

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.f != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.urbanairship.util.helperactivity.RESULT_INTENT_EXTRA", intent);
            this.f.send(i2, bundle);
        }
        super.onActivityResult(i, i2, intent);
        finish();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Autopilot.c(getApplication());
        if (UAirship.v || UAirship.u) {
            Intent intent = getIntent();
            if (intent == null) {
                yj5.c("HelperActivity - Started with null intent", new Object[0]);
                finish();
            } else if (bundle == null) {
                Intent intent2 = (Intent) intent.getParcelableExtra("com.urbanairship.util.START_ACTIVITY_INTENT_EXTRA");
                String[] stringArrayExtra = intent.getStringArrayExtra("com.urbanairship.util.helperactivity.PERMISSIONS_EXTRA");
                if (intent2 != null) {
                    this.f = (ResultReceiver) intent.getParcelableExtra("com.urbanairship.util.helperactivity.RESULT_RECEIVER_EXTRA");
                    int i = g + 1;
                    g = i;
                    startActivityForResult(intent2, i);
                } else if (Build.VERSION.SDK_INT < 23 || stringArrayExtra == null) {
                    yj5.c("HelperActivity - Started without START_ACTIVITY_INTENT_EXTRA or PERMISSIONS_EXTRA extra.", new Object[0]);
                    finish();
                } else {
                    this.f = (ResultReceiver) intent.getParcelableExtra("com.urbanairship.util.helperactivity.RESULT_RECEIVER_EXTRA");
                    int i2 = g + 1;
                    g = i2;
                    requestPermissions(stringArrayExtra, i2);
                }
            }
        } else {
            yj5.c("HelperActivity - unable to create activity, takeOff not called.", new Object[0]);
            finish();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.f != null) {
            Bundle bundle = new Bundle();
            bundle.putIntArray("com.urbanairship.util.helperactivity.RESULT_INTENT_EXTRA", iArr);
            this.f.send(-1, bundle);
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
        finish();
    }
}
