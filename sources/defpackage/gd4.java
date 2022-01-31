package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.messaging.Constants;
import com.razorpay.AnalyticsConstants;

/* renamed from: gd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class gd4 implements Runnable {
    public final /* synthetic */ dd4 f;

    public gd4(dd4 dd4) {
        this.f = dd4;
    }

    public final void run() {
        zg4 zg4 = this.f.n;
        zg4.f4169a.f().b();
        if (zg4.c()) {
            if (zg4.b()) {
                zg4.f4169a.n().A.b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", AnalyticsConstants.INTENT);
                bundle.putLong("_cc", 1);
                zg4.f4169a.s().G("auto", "_cmpx", bundle);
            } else {
                String a2 = zg4.f4169a.n().A.a();
                if (TextUtils.isEmpty(a2)) {
                    zg4.f4169a.g().g.a("Cache still valid but referrer not found");
                } else {
                    long a3 = ((zg4.f4169a.n().B.a() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(a2);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String str : parse.getQueryParameterNames()) {
                        bundle2.putString(str, parse.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", a3);
                    zg4.f4169a.s().G((String) pair.first, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, (Bundle) pair.second);
                }
                zg4.f4169a.n().A.b(null);
            }
            zg4.f4169a.n().B.b(0);
        }
    }
}
