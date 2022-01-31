package defpackage;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.perf.util.Constants;
import java.lang.reflect.InvocationTargetException;

/* renamed from: d64  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class d64 extends tc4 {
    public Boolean b;
    public f64 c = c64.f526a;
    public Boolean d;

    public d64(vb4 vb4) {
        super(vb4);
    }

    public static long A() {
        return q64.D.a(null).longValue();
    }

    public final boolean B() {
        if (this.b == null) {
            Boolean v = v("app_measurement_lite");
            this.b = v;
            if (v == null) {
                this.b = Boolean.FALSE;
            }
        }
        return this.b.booleanValue() || !this.f3331a.e;
    }

    public final Bundle C() {
        try {
            if (this.f3331a.f3627a.getPackageManager() == null) {
                g().f.a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo a2 = ob2.a(this.f3331a.f3627a).a(this.f3331a.f3627a.getPackageName(), 128);
            if (a2 != null) {
                return a2.metaData;
            }
            g().f.a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            g().f.b("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final int j(String str) {
        return Math.max(Math.min(o(str, q64.I), 100), 25);
    }

    public final long k(String str, ka4<Long> ka4) {
        if (str == null) {
            return ka4.a(null).longValue();
        }
        String zza = this.c.zza(str, ka4.f2039a);
        if (TextUtils.isEmpty(zza)) {
            return ka4.a(null).longValue();
        }
        try {
            return ka4.a(Long.valueOf(Long.parseLong(zza))).longValue();
        } catch (NumberFormatException unused) {
            return ka4.a(null).longValue();
        }
    }

    public final boolean l(ka4<Boolean> ka4) {
        return t(null, ka4);
    }

    public final int n(String str) {
        if (!py3.a() || !t(null, q64.w0)) {
            return 500;
        }
        return Math.max(Math.min(o(str, q64.H), (int) Constants.MAX_URL_LENGTH), 500);
    }

    public final int o(String str, ka4<Integer> ka4) {
        if (str == null) {
            return ka4.a(null).intValue();
        }
        String zza = this.c.zza(str, ka4.f2039a);
        if (TextUtils.isEmpty(zza)) {
            return ka4.a(null).intValue();
        }
        try {
            return ka4.a(Integer.valueOf(Integer.parseInt(zza))).intValue();
        } catch (NumberFormatException unused) {
            return ka4.a(null).intValue();
        }
    }

    public final double p(String str, ka4<Double> ka4) {
        if (str == null) {
            return ka4.a(null).doubleValue();
        }
        String zza = this.c.zza(str, ka4.f2039a);
        if (TextUtils.isEmpty(zza)) {
            return ka4.a(null).doubleValue();
        }
        try {
            return ka4.a(Double.valueOf(Double.parseDouble(zza))).doubleValue();
        } catch (NumberFormatException unused) {
            return ka4.a(null).doubleValue();
        }
    }

    public final int q(String str) {
        return o(str, q64.o);
    }

    public final int s() {
        if (!py3.a() || !this.f3331a.g.t(null, q64.x0)) {
            return 25;
        }
        ug4 h = h();
        Boolean bool = h.f3331a.x().e;
        return h.x0() >= 201500 || (bool != null && !bool.booleanValue()) ? 100 : 25;
    }

    public final boolean t(String str, ka4<Boolean> ka4) {
        if (str == null) {
            return ka4.a(null).booleanValue();
        }
        String zza = this.c.zza(str, ka4.f2039a);
        if (TextUtils.isEmpty(zza)) {
            return ka4.a(null).booleanValue();
        }
        return ka4.a(Boolean.valueOf(Boolean.parseBoolean(zza))).booleanValue();
    }

    public final boolean u(String str, ka4<Boolean> ka4) {
        return t(str, ka4);
    }

    public final Boolean v(String str) {
        gj1.j(str);
        Bundle C = C();
        if (C == null) {
            g().f.a("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!C.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(C.getBoolean(str));
        }
    }

    public final boolean w() {
        Boolean v = v("firebase_analytics_collection_deactivated");
        return v != null && v.booleanValue();
    }

    public final Boolean x() {
        Boolean v = v("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(v == null || v.booleanValue());
    }

    public final Boolean y() {
        if (!((p04) q04.g.zza()).zza() || !l(q64.u0)) {
            return Boolean.TRUE;
        }
        Boolean v = v("google_analytics_automatic_screen_reporting_enabled");
        return Boolean.valueOf(v == null || v.booleanValue());
    }

    public final boolean z(String str) {
        return "1".equals(this.c.zza(str, "measurement.event_sampling_enabled"));
    }

    public final String zza(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e) {
            g().f.b("Could not find SystemProperties class", e);
            return str2;
        } catch (NoSuchMethodException e2) {
            g().f.b("Could not find SystemProperties.get() method", e2);
            return str2;
        } catch (IllegalAccessException e3) {
            g().f.b("Could not access SystemProperties.get()", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            g().f.b("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }
}
