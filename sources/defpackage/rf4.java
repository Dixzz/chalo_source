package defpackage;

import android.os.SystemClock;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Objects;

/* renamed from: rf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class rf4 extends jg4 {
    public String d;
    public boolean e;
    public long f;

    public rf4(lg4 lg4) {
        super(lg4);
    }

    @Override // defpackage.jg4
    public final boolean n() {
        return false;
    }

    public final Pair<String, Boolean> q(String str, e64 e64) {
        if (!uy3.a() || !this.f3331a.g.l(q64.J0) || e64.j()) {
            return t(str);
        }
        return new Pair<>("", Boolean.FALSE);
    }

    @Deprecated
    public final String s(String str) {
        b();
        String str2 = (String) t(str).first;
        MessageDigest w0 = ug4.w0();
        if (w0 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, w0.digest(str2.getBytes())));
    }

    @Deprecated
    public final Pair<String, Boolean> t(String str) {
        b();
        Objects.requireNonNull((db2) this.f3331a.n);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.d != null && elapsedRealtime < this.f) {
            return new Pair<>(this.d, Boolean.valueOf(this.e));
        }
        d64 d64 = this.f3331a.g;
        Objects.requireNonNull(d64);
        this.f = elapsedRealtime + d64.k(str, q64.b);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f3331a.f3627a);
            if (advertisingIdInfo != null) {
                this.d = advertisingIdInfo.getId();
                this.e = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.d == null) {
                this.d = "";
            }
        } catch (Exception e2) {
            g().m.b("Unable to get advertising id", e2);
            this.d = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.d, Boolean.valueOf(this.e));
    }
}
