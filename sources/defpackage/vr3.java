package defpackage;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AnalyticsConstants;
import defpackage.t2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: vr3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class vr3 implements yr3 {
    public static final Map<Uri, vr3> g = new n2();
    public static final String[] h = {AnalyticsConstants.KEY, FirebaseAnalytics.Param.VALUE};

    /* renamed from: a  reason: collision with root package name */
    public final ContentResolver f3677a;
    public final Uri b;
    public final ContentObserver c;
    public final Object d = new Object();
    public volatile Map<String, String> e;
    public final List<wr3> f = new ArrayList();

    public vr3(ContentResolver contentResolver, Uri uri) {
        xr3 xr3 = new xr3(this);
        this.c = xr3;
        Objects.requireNonNull(contentResolver);
        Objects.requireNonNull(uri);
        this.f3677a = contentResolver;
        this.b = uri;
        contentResolver.registerContentObserver(uri, false, xr3);
    }

    public static vr3 a(ContentResolver contentResolver, Uri uri) {
        vr3 vr3;
        synchronized (vr3.class) {
            Map<Uri, vr3> map = g;
            vr3 = (vr3) ((u2) map).get(uri);
            if (vr3 == null) {
                try {
                    vr3 vr32 = new vr3(contentResolver, uri);
                    try {
                        ((u2) map).put(uri, vr32);
                    } catch (SecurityException unused) {
                    }
                    vr3 = vr32;
                } catch (SecurityException unused2) {
                }
            }
        }
        return vr3;
    }

    public static synchronized void c() {
        Map<Uri, vr3> map = g;
        synchronized (vr3.class) {
            Iterator it = ((t2.e) ((n2) map).values()).iterator();
            while (it.hasNext()) {
                vr3 vr3 = (vr3) it.next();
                vr3.f3677a.unregisterContentObserver(vr3.c);
            }
            ((u2) map).clear();
        }
    }

    /* JADX INFO: finally extract failed */
    public final Map<String, String> b() {
        Map<String, String> map;
        Map<String, String> map2 = this.e;
        if (map2 == null) {
            synchronized (this.d) {
                map2 = this.e;
                if (map2 == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        map = (Map) hd3.B3(new ur3(this));
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                    } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                    this.e = map;
                    map2 = map;
                }
            }
        }
        if (map2 != null) {
            return map2;
        }
        return Collections.emptyMap();
    }

    @Override // defpackage.yr3
    public final /* synthetic */ Object zza(String str) {
        return b().get(str);
    }
}
