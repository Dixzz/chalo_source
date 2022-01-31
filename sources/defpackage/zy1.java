package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import defpackage.vy1;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/* renamed from: zy1  reason: default package */
public class zy1 extends yb3 {
    public final Map<String, String> h;
    public final Map<String, String> i = new HashMap();
    public final qd3 j;
    public final a k;
    public uy1 l;
    public he3 m;

    /* renamed from: zy1$a */
    public class a extends yb3 implements vy1.a {
        public boolean h;
        public int i;
        public long j = -1;
        public boolean k;
        public long l;

        public a(ac3 ac3) {
            super(ac3);
        }

        @Override // defpackage.vy1.a
        public final void a(Activity activity) {
            String str;
            if (this.i == 0) {
                Objects.requireNonNull((db2) this.f.c);
                if (SystemClock.elapsedRealtime() >= Math.max(1000, this.j) + this.l) {
                    this.k = true;
                }
            }
            this.i++;
            if (this.h) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    zy1 zy1 = zy1.this;
                    Uri data = intent.getData();
                    Objects.requireNonNull(zy1);
                    if (data != null && !data.isOpaque()) {
                        String queryParameter = data.getQueryParameter("referrer");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            String valueOf = String.valueOf(queryParameter);
                            Uri parse = Uri.parse(valueOf.length() != 0 ? "http://hostname/?".concat(valueOf) : new String("http://hostname/?"));
                            String queryParameter2 = parse.getQueryParameter("utm_id");
                            if (queryParameter2 != null) {
                                zy1.i.put("&ci", queryParameter2);
                            }
                            String queryParameter3 = parse.getQueryParameter("anid");
                            if (queryParameter3 != null) {
                                zy1.i.put("&anid", queryParameter3);
                            }
                            String queryParameter4 = parse.getQueryParameter("utm_campaign");
                            if (queryParameter4 != null) {
                                zy1.i.put("&cn", queryParameter4);
                            }
                            String queryParameter5 = parse.getQueryParameter("utm_content");
                            if (queryParameter5 != null) {
                                zy1.i.put("&cc", queryParameter5);
                            }
                            String queryParameter6 = parse.getQueryParameter("utm_medium");
                            if (queryParameter6 != null) {
                                zy1.i.put("&cm", queryParameter6);
                            }
                            String queryParameter7 = parse.getQueryParameter("utm_source");
                            if (queryParameter7 != null) {
                                zy1.i.put("&cs", queryParameter7);
                            }
                            String queryParameter8 = parse.getQueryParameter("utm_term");
                            if (queryParameter8 != null) {
                                zy1.i.put("&ck", queryParameter8);
                            }
                            String queryParameter9 = parse.getQueryParameter("dclid");
                            if (queryParameter9 != null) {
                                zy1.i.put("&dclid", queryParameter9);
                            }
                            String queryParameter10 = parse.getQueryParameter("gclid");
                            if (queryParameter10 != null) {
                                zy1.i.put("&gclid", queryParameter10);
                            }
                            String queryParameter11 = parse.getQueryParameter(FirebaseAnalytics.Param.ACLID);
                            if (queryParameter11 != null) {
                                zy1.i.put("&aclid", queryParameter11);
                            }
                        }
                    }
                }
                HashMap m0 = hj1.m0("&t", "screenview");
                zy1 zy12 = zy1.this;
                he3 he3 = zy12.m;
                if (he3 != null) {
                    str = activity.getClass().getCanonicalName();
                    String str2 = he3.g.get(str);
                    if (str2 != null) {
                        str = str2;
                    }
                } else {
                    str = activity.getClass().getCanonicalName();
                }
                zy12.j0("&cd", str);
                if (TextUtils.isEmpty((CharSequence) m0.get("&dr"))) {
                    Intent intent2 = activity.getIntent();
                    String str3 = null;
                    if (intent2 != null) {
                        String stringExtra = intent2.getStringExtra("android.intent.extra.REFERRER_NAME");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            str3 = stringExtra;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        m0.put("&dr", str3);
                    }
                }
                zy1.this.i0(m0);
            }
        }

        @Override // defpackage.yb3
        public final void a0() {
        }

        @Override // defpackage.vy1.a
        public final void h(Activity activity) {
            int i2 = this.i - 1;
            this.i = i2;
            int max = Math.max(0, i2);
            this.i = max;
            if (max == 0) {
                Objects.requireNonNull((db2) this.f.c);
                this.l = SystemClock.elapsedRealtime();
            }
        }

        public final void i0() {
            if (this.j >= 0 || this.h) {
                vy1 x = x();
                x.g.add(zy1.this.k);
                Context context = x.d.f146a;
                if (context instanceof Application) {
                    Application application = (Application) context;
                    if (!x.h) {
                        application.registerActivityLifecycleCallbacks(new vy1.b());
                        x.h = true;
                        return;
                    }
                    return;
                }
                return;
            }
            vy1 x2 = x();
            x2.g.remove(zy1.this.k);
        }
    }

    public zy1(ac3 ac3, String str) {
        super(ac3);
        HashMap hashMap = new HashMap();
        this.h = hashMap;
        hashMap.put("useSecure", "1");
        hashMap.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        this.j = new qd3("tracking", this.f.c);
        this.k = new a(ac3);
    }

    public static String m0(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        if (!(key.startsWith("&") && key.length() >= 2)) {
            return null;
        }
        return entry.getKey().substring(1);
    }

    public static void q0(Map<String, String> map, Map<String, String> map2) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String m0 = m0(entry);
                if (m0 != null) {
                    map2.put(m0, entry.getValue());
                }
            }
        }
    }

    @Override // defpackage.yb3
    public final void a0() {
        this.k.Z();
        je3 D = D();
        D.g0();
        String str = D.i;
        if (str != null) {
            j0("&an", str);
        }
        je3 D2 = D();
        D2.g0();
        String str2 = D2.h;
        if (str2 != null) {
            j0("&av", str2);
        }
    }

    public void i0(Map<String, String> map) {
        Objects.requireNonNull((db2) this.f.c);
        long currentTimeMillis = System.currentTimeMillis();
        Objects.requireNonNull(x());
        boolean z = x().i;
        HashMap hashMap = new HashMap();
        q0(this.h, hashMap);
        q0(map, hashMap);
        String str = this.h.get("useSecure");
        int i2 = 1;
        boolean z2 = str == null || str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("1") || (!str.equalsIgnoreCase("false") && !str.equalsIgnoreCase("no") && !str.equalsIgnoreCase("0"));
        Map<String, String> map2 = this.i;
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String m0 = m0(entry);
                if (m0 != null && !hashMap.containsKey(m0)) {
                    hashMap.put(m0, entry.getValue());
                }
            }
        }
        this.i.clear();
        String str2 = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str2)) {
            t().j0(hashMap, "Missing hit type parameter");
            return;
        }
        String str3 = (String) hashMap.get("tid");
        if (TextUtils.isEmpty(str3)) {
            t().j0(hashMap, "Missing tracking id parameter");
            return;
        }
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str2) || "pageview".equalsIgnoreCase(str2) || "appview".equalsIgnoreCase(str2) || TextUtils.isEmpty(str2)) {
                int parseInt = Integer.parseInt(this.h.get("&a")) + 1;
                if (parseInt < Integer.MAX_VALUE) {
                    i2 = parseInt;
                }
                this.h.put("&a", Integer.toString(i2));
            }
        }
        w().b(new oz1(this, hashMap, false, str2, currentTimeMillis, z, z2, str3));
    }

    public void j0(String str, String str2) {
        gj1.l(str, "Key should be non-null");
        if (!TextUtils.isEmpty(str)) {
            this.h.put(str, str2);
        }
    }

    public final void o0(he3 he3) {
        M("Loading Tracker config values");
        this.m = he3;
        String str = he3.f1362a;
        boolean z = false;
        if (str != null) {
            j0("&tid", str);
            k("trackingId loaded", str);
        }
        double d = this.m.b;
        if (d >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            String d2 = Double.toString(d);
            j0("&sf", d2);
            k("Sample frequency loaded", d2);
        }
        int i2 = this.m.c;
        if (i2 >= 0) {
            a aVar = this.k;
            aVar.j = ((long) i2) * 1000;
            aVar.i0();
            k("Session timeout loaded", Integer.valueOf(i2));
        }
        int i3 = this.m.d;
        if (i3 != -1) {
            boolean z2 = i3 == 1;
            a aVar2 = this.k;
            aVar2.h = z2;
            aVar2.i0();
            k("Auto activity tracking loaded", Boolean.valueOf(z2));
        }
        int i4 = this.m.e;
        if (i4 != -1) {
            boolean z3 = i4 == 1;
            if (z3) {
                j0("&aip", "1");
            }
            k("Anonymize ip loaded", Boolean.valueOf(z3));
        }
        boolean z4 = this.m.f == 1;
        synchronized (this) {
            uy1 uy1 = this.l;
            if (uy1 != null) {
                z = true;
            }
            if (z != z4) {
                if (z4) {
                    uy1 uy12 = new uy1(this, Thread.getDefaultUncaughtExceptionHandler(), this.f.f146a);
                    this.l = uy12;
                    Thread.setDefaultUncaughtExceptionHandler(uy12);
                    M("Uncaught exceptions will be reported to Google Analytics");
                } else {
                    Thread.setDefaultUncaughtExceptionHandler(uy1.f3571a);
                    M("Uncaught exceptions will not be reported to Google Analytics");
                }
            }
        }
    }
}
