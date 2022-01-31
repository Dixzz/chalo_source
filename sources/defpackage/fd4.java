package defpackage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

/* renamed from: fd4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final /* synthetic */ class fd4 implements Runnable {
    public final dd4 f;

    public fd4(dd4 dd4) {
        this.f = dd4;
    }

    public final void run() {
        Pair pair;
        NetworkInfo networkInfo;
        URL url;
        dd4 dd4 = this.f;
        dd4.b();
        if (dd4.i().x.b()) {
            dd4.g().m.a("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long a2 = dd4.i().y.a();
        dd4.i().y.b(a2 + 1);
        if (a2 >= 5) {
            dd4.g().i.a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            dd4.i().x.a(true);
            return;
        }
        vb4 vb4 = dd4.f3331a;
        vb4.f().b();
        vb4.p(vb4.l());
        oa4 z = vb4.z();
        z.s();
        String str = z.c;
        eb4 n = vb4.n();
        n.b();
        Objects.requireNonNull((db2) n.f3331a.n);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (n.m == null || elapsedRealtime >= n.o) {
            d64 d64 = n.f3331a.g;
            Objects.requireNonNull(d64);
            n.o = d64.k(str, q64.b) + elapsedRealtime;
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(n.f3331a.f3627a);
                if (advertisingIdInfo != null) {
                    n.m = advertisingIdInfo.getId();
                    n.n = advertisingIdInfo.isLimitAdTrackingEnabled();
                }
                if (n.m == null) {
                    n.m = "";
                }
            } catch (Exception e) {
                n.g().m.b("Unable to get advertising id", e);
                n.m = "";
            }
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
            pair = new Pair(n.m, Boolean.valueOf(n.n));
        } else {
            pair = new Pair(n.m, Boolean.valueOf(n.n));
        }
        if (!vb4.g.x().booleanValue() || ((Boolean) pair.second).booleanValue() || TextUtils.isEmpty((CharSequence) pair.first)) {
            vb4.g().m.a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        ee4 l = vb4.l();
        l.l();
        try {
            networkInfo = ((ConnectivityManager) l.f3331a.f3627a.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        if (!(networkInfo != null && networkInfo.isConnected())) {
            vb4.g().i.a("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        ug4 t = vb4.t();
        vb4.z();
        String str2 = (String) pair.first;
        long a3 = vb4.n().y.a() - 1;
        Objects.requireNonNull(t);
        try {
            gj1.j(str2);
            gj1.j(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 33025L, Integer.valueOf(t.x0())), str2, str, Long.valueOf(a3));
            if (str.equals(t.f3331a.g.zza("debug.deferred.deeplink", ""))) {
                format = format.concat("&ddl_test=1");
            }
            url = new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e2) {
            t.g().f.b("Failed to create BOW URL for Deferred Deep Link. exception", e2.getMessage());
            url = null;
        }
        ee4 l2 = vb4.l();
        yb4 yb4 = new yb4(vb4);
        l2.b();
        l2.l();
        Objects.requireNonNull(url, "null reference");
        l2.f().w(new ge4(l2, str, url, yb4));
    }
}
