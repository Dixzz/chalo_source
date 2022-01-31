package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import defpackage.t2;
import java.util.Iterator;
import java.util.Map;

/* renamed from: bg3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class bg3 implements pf3 {
    public static final Map<String, bg3> e = new n2();

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f428a;
    public final SharedPreferences.OnSharedPreferenceChangeListener b;
    public final Object c;
    public volatile Map<String, ?> d;

    public static bg3 b(Context context, String str) {
        bg3 bg3;
        if (!if3.a()) {
            synchronized (bg3.class) {
                bg3 = (bg3) ((u2) e).get(null);
                if (bg3 == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
            return bg3;
        }
        throw null;
    }

    public static synchronized void c() {
        Map<String, bg3> map = e;
        synchronized (bg3.class) {
            Iterator it = ((t2.e) ((n2) map).values()).iterator();
            while (it.hasNext()) {
                bg3 bg3 = (bg3) it.next();
                bg3.f428a.unregisterOnSharedPreferenceChangeListener(bg3.b);
            }
            ((u2) map).clear();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.pf3
    public final Object a(String str) {
        Map<String, ?> map = this.d;
        if (map == null) {
            synchronized (this.c) {
                map = this.d;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.f428a.getAll();
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
