package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import defpackage.t2;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ps3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ps3 implements yr3 {
    public static final Map<String, ps3> e = new n2();

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f2844a;
    public final SharedPreferences.OnSharedPreferenceChangeListener b;
    public final Object c;
    public volatile Map<String, ?> d;

    public static ps3 a(Context context) {
        ps3 ps3;
        if (!tr3.a()) {
            synchronized (ps3.class) {
                ps3 = (ps3) ((u2) e).get(null);
                if (ps3 == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
            return ps3;
        }
        throw null;
    }

    public static synchronized void b() {
        Map<String, ps3> map = e;
        synchronized (ps3.class) {
            Iterator it = ((t2.e) ((n2) map).values()).iterator();
            while (it.hasNext()) {
                ps3 ps3 = (ps3) it.next();
                ps3.f2844a.unregisterOnSharedPreferenceChangeListener(ps3.b);
            }
            ((u2) map).clear();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.yr3
    public final Object zza(String str) {
        Map<String, ?> map = this.d;
        if (map == null) {
            synchronized (this.c) {
                map = this.d;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.f2844a.getAll();
                        this.d = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
