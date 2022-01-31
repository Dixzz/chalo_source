package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.truecaller.android.sdk.ITrueCallback;
import com.truecaller.android.sdk.R;
import defpackage.ch5;

/* renamed from: ah5  reason: default package */
/* compiled from: VerificationClient */
public final class ah5 extends xg5 implements ch5.a {
    public final ch5 h;
    public final eh5 i;
    public final boolean j;
    public hh5 k;
    public jh5 l;
    public Handler m;

    public ah5(Context context, String str, ITrueCallback iTrueCallback, boolean z) {
        super(context, str, iTrueCallback, 2);
        eh5 eh5;
        this.j = z;
        String string = context.getString(R.string.sdk_variant);
        String string2 = context.getString(R.string.sdk_variant_version);
        this.h = new dh5(this, (uh5) hd3.a0("https://outline.truecaller.com/v1/", uh5.class, string, string2), (vh5) hd3.a0("https://api4.truecaller.com/v1/otp/installation/", vh5.class, string, string2), iTrueCallback, new rh5(this.f3926a));
        if (Build.VERSION.SDK_INT >= 28) {
            eh5 = new gh5(context);
        } else {
            eh5 = new fh5(context);
        }
        this.i = eh5;
    }

    public boolean a() {
        boolean z;
        if (b("android.permission.READ_PHONE_STATE") && b("android.permission.READ_CALL_LOG")) {
            if (Build.VERSION.SDK_INT < 26) {
                z = b("android.permission.CALL_PHONE");
            } else {
                z = b("android.permission.ANSWER_PHONE_CALLS");
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str) {
        return this.f3926a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public boolean c() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f3926a.getSystemService("phone");
        return telephonyManager != null && telephonyManager.getSimState() == 5;
    }

    public void d() {
        ((TelephonyManager) this.f3926a.getSystemService("phone")).listen(this.k, 0);
    }
}
