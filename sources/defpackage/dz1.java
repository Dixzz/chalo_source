package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: dz1  reason: default package */
public final class dz1 extends xb3 implements nz1 {
    public static DecimalFormat j;
    public final ac3 g;
    public final String h;
    public final Uri i;

    public dz1(ac3 ac3, String str) {
        super(ac3);
        gj1.j(str);
        this.g = ac3;
        this.h = str;
        this.i = j0(str);
    }

    public static String X(double d) {
        if (j == null) {
            j = new DecimalFormat("0.######");
        }
        return j.format(d);
    }

    public static void Z(Map<String, String> map, String str, double d) {
        if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            map.put(str, X(d));
        }
    }

    public static void a0(Map<String, String> map, String str, int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            StringBuilder sb = new StringBuilder(23);
            sb.append(i2);
            sb.append("x");
            sb.append(i3);
            map.put(str, sb.toString());
        }
    }

    public static void g0(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    public static void i0(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    public static Uri j0(String str) {
        gj1.j(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    public static Map<String, String> m0(gz1 gz1) {
        HashMap hashMap = new HashMap();
        se3 se3 = (se3) gz1.j.get(se3.class);
        if (se3 != null) {
            for (Map.Entry entry : Collections.unmodifiableMap(se3.f3207a).entrySet()) {
                Object value = entry.getValue();
                String str = null;
                if (value != null) {
                    if (value instanceof String) {
                        String str2 = (String) value;
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                    } else if (value instanceof Double) {
                        Double d = (Double) value;
                        if (d.doubleValue() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            str = X(d.doubleValue());
                        }
                    } else if (!(value instanceof Boolean)) {
                        str = String.valueOf(value);
                    } else if (value != Boolean.FALSE) {
                        str = "1";
                    }
                }
                if (str != null) {
                    hashMap.put((String) entry.getKey(), str);
                }
            }
        }
        xe3 xe3 = (xe3) gz1.j.get(xe3.class);
        if (xe3 != null) {
            g0(hashMap, "t", xe3.f3922a);
            g0(hashMap, "cid", xe3.b);
            g0(hashMap, "uid", xe3.c);
            g0(hashMap, "sc", xe3.f);
            Z(hashMap, "sf", xe3.h);
            i0(hashMap, "ni", xe3.g);
            g0(hashMap, "adid", xe3.d);
            i0(hashMap, "ate", xe3.e);
        }
        ob3 ob3 = (ob3) gz1.j.get(ob3.class);
        if (ob3 != null) {
            g0(hashMap, "cd", ob3.f2674a);
            Z(hashMap, "a", (double) ob3.b);
            g0(hashMap, "dr", ob3.e);
        }
        ve3 ve3 = (ve3) gz1.j.get(ve3.class);
        if (ve3 != null) {
            g0(hashMap, "ec", ve3.f3641a);
            g0(hashMap, "ea", ve3.b);
            g0(hashMap, "el", ve3.c);
            Z(hashMap, "ev", (double) ve3.d);
        }
        pe3 pe3 = (pe3) gz1.j.get(pe3.class);
        if (pe3 != null) {
            g0(hashMap, "cn", pe3.f2796a);
            g0(hashMap, "cs", pe3.b);
            g0(hashMap, "cm", pe3.c);
            g0(hashMap, "ck", pe3.d);
            g0(hashMap, "cc", pe3.e);
            g0(hashMap, "ci", pe3.f);
            g0(hashMap, "anid", pe3.g);
            g0(hashMap, "gclid", pe3.h);
            g0(hashMap, "dclid", pe3.i);
            g0(hashMap, FirebaseAnalytics.Param.ACLID, pe3.j);
        }
        we3 we3 = (we3) gz1.j.get(we3.class);
        if (we3 != null) {
            g0(hashMap, "exd", we3.f3768a);
            i0(hashMap, "exf", we3.b);
        }
        pb3 pb3 = (pb3) gz1.j.get(pb3.class);
        if (pb3 != null) {
            g0(hashMap, "sn", pb3.f2791a);
            g0(hashMap, "sa", pb3.b);
            g0(hashMap, "st", pb3.c);
        }
        qb3 qb3 = (qb3) gz1.j.get(qb3.class);
        if (qb3 != null) {
            g0(hashMap, "utv", qb3.f2924a);
            Z(hashMap, "utt", (double) qb3.b);
            g0(hashMap, "utc", qb3.c);
            g0(hashMap, "utl", qb3.d);
        }
        qe3 qe3 = (qe3) gz1.j.get(qe3.class);
        if (qe3 != null) {
            for (Map.Entry entry2 : Collections.unmodifiableMap(qe3.f2935a).entrySet()) {
                String U0 = gj1.U0("cd", ((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(U0)) {
                    hashMap.put(U0, (String) entry2.getValue());
                }
            }
        }
        re3 re3 = (re3) gz1.j.get(re3.class);
        if (re3 != null) {
            for (Map.Entry entry3 : Collections.unmodifiableMap(re3.f3073a).entrySet()) {
                String U02 = gj1.U0("cm", ((Integer) entry3.getKey()).intValue());
                if (!TextUtils.isEmpty(U02)) {
                    hashMap.put(U02, X(((Double) entry3.getValue()).doubleValue()));
                }
            }
        }
        ue3 ue3 = (ue3) gz1.j.get(ue3.class);
        if (ue3 != null) {
            int i2 = 1;
            for (bz1 bz1 : Collections.unmodifiableList(ue3.b)) {
                hashMap.putAll(bz1.a(gj1.U0("promo", i2)));
                i2++;
            }
            int i3 = 1;
            for (az1 az1 : Collections.unmodifiableList(ue3.f3493a)) {
                hashMap.putAll(az1.a(gj1.U0("pr", i3)));
                i3++;
            }
            int i4 = 1;
            for (Map.Entry<String, List<az1>> entry4 : ue3.c.entrySet()) {
                String U03 = gj1.U0("il", i4);
                int i5 = 1;
                for (az1 az12 : entry4.getValue()) {
                    String valueOf = String.valueOf(U03);
                    String valueOf2 = String.valueOf(gj1.U0("pi", i5));
                    hashMap.putAll(az12.a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i5++;
                }
                if (!TextUtils.isEmpty(entry4.getKey())) {
                    hashMap.put(String.valueOf(U03).concat("nm"), entry4.getKey());
                }
                i4++;
            }
        }
        te3 te3 = (te3) gz1.j.get(te3.class);
        if (te3 != null) {
            g0(hashMap, "ul", te3.f3340a);
            Z(hashMap, "sd", (double) te3.b);
            a0(hashMap, "sr", te3.c, te3.d);
            a0(hashMap, "vp", te3.e, te3.f);
        }
        oe3 oe3 = (oe3) gz1.j.get(oe3.class);
        if (oe3 != null) {
            g0(hashMap, "an", oe3.f2681a);
            g0(hashMap, "aid", oe3.c);
            g0(hashMap, "aiid", oe3.d);
            g0(hashMap, "av", oe3.b);
        }
        return hashMap;
    }

    @Override // defpackage.nz1
    public final Uri l() {
        return this.i;
    }

    @Override // defpackage.nz1
    public final void m(gz1 gz1) {
        gj1.c(gz1.c, "Can't deliver not submitted measurement");
        gj1.k("deliver should be called on worker thread");
        gz1 gz12 = new gz1(gz1);
        xe3 xe3 = (xe3) gz12.b(xe3.class);
        if (TextUtils.isEmpty(xe3.f3922a)) {
            t().j0(m0(gz12), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(xe3.b)) {
            t().j0(m0(gz12), "Ignoring measurement without client id");
        } else {
            Objects.requireNonNull(this.g.f());
            double d = xe3.h;
            if (ie3.c(d, xe3.b)) {
                o("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d));
                return;
            }
            Map<String, String> m0 = m0(gz12);
            HashMap hashMap = (HashMap) m0;
            hashMap.put("v", "1");
            hashMap.put("_v", zb3.b);
            hashMap.put("tid", this.h);
            if (this.g.f().i) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                }
                j(4, "Dry run is enabled. GoogleAnalytics would have sent", sb.toString(), null, null);
                return;
            }
            HashMap hashMap2 = new HashMap();
            ie3.e(hashMap2, "uid", xe3.c);
            oe3 oe3 = (oe3) gz1.j.get(oe3.class);
            if (oe3 != null) {
                ie3.e(hashMap2, "an", oe3.f2681a);
                ie3.e(hashMap2, "aid", oe3.c);
                ie3.e(hashMap2, "av", oe3.b);
                ie3.e(hashMap2, "aiid", oe3.d);
            }
            hashMap.put("_s", String.valueOf(A().i0(new dc3(xe3.b, this.h, !TextUtils.isEmpty(xe3.d), 0, hashMap2))));
            A().j0(new nd3(t(), m0, gz1.d, true));
        }
    }
}
