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

/* renamed from: mf3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class mf3 implements pf3 {
    public static final Map<Uri, mf3> g = new n2();
    public static final String[] h = {AnalyticsConstants.KEY, FirebaseAnalytics.Param.VALUE};

    /* renamed from: a  reason: collision with root package name */
    public final ContentResolver f2369a;
    public final Uri b;
    public final ContentObserver c;
    public final Object d = new Object();
    public volatile Map<String, String> e;
    public final List<nf3> f = new ArrayList();

    public mf3(ContentResolver contentResolver, Uri uri) {
        of3 of3 = new of3(this);
        this.c = of3;
        this.f2369a = contentResolver;
        this.b = uri;
        contentResolver.registerContentObserver(uri, false, of3);
    }

    public static synchronized void b() {
        Map<Uri, mf3> map = g;
        synchronized (mf3.class) {
            Iterator it = ((t2.e) ((n2) map).values()).iterator();
            while (it.hasNext()) {
                mf3 mf3 = (mf3) it.next();
                mf3.f2369a.unregisterContentObserver(mf3.c);
            }
            ((u2) map).clear();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.pf3
    public final Object a(String str) {
        Map<String, String> map;
        Map<String, String> map2 = this.e;
        if (map2 == null) {
            synchronized (this.d) {
                map2 = this.e;
                if (map2 == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        map = (Map) hd3.A3(new lf3(this));
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
        if (map2 == null) {
            map2 = Collections.emptyMap();
        }
        return map2.get(str);
    }
}
