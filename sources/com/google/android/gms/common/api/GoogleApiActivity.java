package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.annotation.KeepName;
import java.util.Objects;

@KeepName
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    public static final /* synthetic */ int g = 0;
    public int f = 0;

    public final void onActivityResult(int i, int i2, @RecentlyNonNull Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                o32 e = o32.e(this);
                if (i2 == -1) {
                    Handler handler = e.n;
                    handler.sendMessage(handler.obtainMessage(3));
                } else if (i2 == 0) {
                    e.i(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i == 2) {
            this.f = 0;
            setResult(i2, intent);
        }
        finish();
    }

    public final void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        this.f = 0;
        setResult(0);
        finish();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f = bundle.getInt("resolution");
        }
        if (this.f != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                finish();
            } else if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.f = 1;
                } catch (ActivityNotFoundException unused) {
                    if (extras.getBoolean("notify_manager", true)) {
                        o32.e(this).i(new ConnectionResult(22, null), getIntent().getIntExtra("failing_client_id", -1));
                    } else {
                        String valueOf = String.valueOf(pendingIntent);
                        String b0 = hj1.b0(new StringBuilder(valueOf.length() + 36), "Activity not found while launching ", valueOf, ".");
                        if (Build.FINGERPRINT.contains("generic")) {
                            String.valueOf(b0).concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                        }
                    }
                    this.f = 1;
                    finish();
                } catch (IntentSender.SendIntentException unused2) {
                    finish();
                }
            } else {
                Objects.requireNonNull(num, "null reference");
                int intValue = num.intValue();
                Object obj = q22.c;
                q22 q22 = q22.d;
                Dialog d = q22.d(this, intValue, 2, this);
                if (d != null) {
                    q22.k(this, d, GooglePlayServicesUtil.GMS_ERROR_DIALOG, this);
                }
                this.f = 1;
            }
        }
    }

    public final void onSaveInstanceState(@RecentlyNonNull Bundle bundle) {
        bundle.putInt("resolution", this.f);
        super.onSaveInstanceState(bundle);
    }
}
