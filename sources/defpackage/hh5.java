package defpackage;

import android.os.Handler;
import android.telephony.PhoneStateListener;
import com.truecaller.android.sdk.TrueException;
import java.util.Objects;

/* renamed from: hh5  reason: default package */
/* compiled from: IncomingCallListener */
public class hh5 extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final oh5 f1373a;

    public hh5(oh5 oh5) {
        this.f1373a = oh5;
    }

    public void onCallStateChanged(int i, String str) {
        super.onCallStateChanged(i, str);
        if (i == 1) {
            oh5 oh5 = this.f1373a;
            Objects.requireNonNull(oh5);
            if (str == null || str.length() == 0) {
                Handler handler = oh5.i;
                if (handler != null) {
                    handler.removeCallbacks(oh5.h);
                    oh5.i = null;
                }
                oh5.f2221a.onRequestFailure(4, new TrueException(4, TrueException.TYPE_MISSING_PERMISSIONS_MESSAGE));
                return;
            }
            oh5.k = str;
            oh5.d(false);
        }
    }
}
