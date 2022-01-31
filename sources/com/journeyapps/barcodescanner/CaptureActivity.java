package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.widget.ListPopupWindow;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import java.util.Objects;

public class CaptureActivity extends Activity {
    public w95 f;
    public CompoundBarcodeView g;

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x018c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r17) {
        /*
        // Method dump skipped, instructions count: 479
        */
        throw new UnsupportedOperationException("Method not decompiled: com.journeyapps.barcodescanner.CaptureActivity.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        super.onDestroy();
        w95 w95 = this.f;
        w95.e = true;
        w95.f.a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.g.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent);
    }

    public void onPause() {
        super.onPause();
        w95 w95 = this.f;
        w95.b.f.d();
        w95.f.a();
        w95.g.close();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w95 w95 = this.f;
        Objects.requireNonNull(w95);
        if (i != 250) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            w95.a();
        } else {
            w95.b.f.f();
        }
    }

    public void onResume() {
        super.onResume();
        w95 w95 = this.f;
        if (Build.VERSION.SDK_INT < 23) {
            w95.b.f.f();
        } else if (q5.a(w95.f3748a, "android.permission.CAMERA") == 0) {
            w95.b.f.f();
        } else if (!w95.k) {
            t4.c(w95.f3748a, new String[]{"android.permission.CAMERA"}, ListPopupWindow.EXPAND_LIST_TIMEOUT);
            w95.k = true;
        }
        w95.g.c();
        b45 b45 = w95.f;
        if (!b45.c) {
            b45.f377a.registerReceiver(b45.b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            b45.c = true;
        }
        b45.d.removeCallbacksAndMessages(null);
        if (b45.f) {
            b45.d.postDelayed(b45.e, DefaultRefreshIntervals.RESPONSE_TIME_EXPECTATIONS_FETCH_INTERVAL);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.f.c);
    }
}
