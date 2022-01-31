package defpackage;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzz;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* renamed from: ug4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ug4 extends sc4 {
    public static final String[] g = {"firebase_", "google_", "ga_"};
    public static final String[] h = {"_err"};
    public SecureRandom c;
    public final AtomicLong d = new AtomicLong(0);
    public int e;
    public Integer f = null;

    public ug4(vb4 vb4) {
        super(vb4);
    }

    public static String D(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    public static void E(Bundle bundle, int i, String str, Object obj) {
        if (k0(bundle, i)) {
            bundle.putString("_ev", D(str, 40, true));
            if (obj == null) {
                return;
            }
            if ((obj instanceof String) || (obj instanceof CharSequence)) {
                bundle.putLong("_el", (long) String.valueOf(obj).length());
            }
        }
    }

    public static boolean T(Context context) {
        Objects.requireNonNull(context, "null reference");
        if (Build.VERSION.SDK_INT >= 24) {
            return j0(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return j0(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean U(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static boolean V(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static boolean W(String str) {
        gj1.j(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    public static boolean c0(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public static boolean d0(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (p0(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] f0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static ArrayList<Bundle> i0(List<zzz> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzz zzz : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzz.f);
            bundle.putString(FirebaseAnalytics.Param.ORIGIN, zzz.g);
            bundle.putLong("creation_timestamp", zzz.i);
            bundle.putString("name", zzz.h.g);
            hd3.L3(bundle, zzz.h.l1());
            bundle.putBoolean("active", zzz.j);
            String str = zzz.k;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzaq zzaq = zzz.l;
            if (zzaq != null) {
                bundle.putString("timed_out_event_name", zzaq.f);
                zzap zzap = zzz.l.g;
                if (zzap != null) {
                    bundle.putBundle("timed_out_event_params", zzap.m1());
                }
            }
            bundle.putLong("trigger_timeout", zzz.m);
            zzaq zzaq2 = zzz.n;
            if (zzaq2 != null) {
                bundle.putString("triggered_event_name", zzaq2.f);
                zzap zzap2 = zzz.n.g;
                if (zzap2 != null) {
                    bundle.putBundle("triggered_event_params", zzap2.m1());
                }
            }
            bundle.putLong("triggered_timestamp", zzz.h.h);
            bundle.putLong("time_to_live", zzz.o);
            zzaq zzaq3 = zzz.p;
            if (zzaq3 != null) {
                bundle.putString("expired_event_name", zzaq3.f);
                zzap zzap3 = zzz.p.g;
                if (zzap3 != null) {
                    bundle.putBundle("expired_event_params", zzap3.m1());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean j0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean k0(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    public static boolean p0(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static boolean q0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static long t(long j, long j2) {
        return ((j2 * DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL) + j) / 86400000;
    }

    public static long u(zzap zzap) {
        long j = 0;
        if (zzap == null) {
            return 0;
        }
        for (String str : zzap.f.keySet()) {
            Object l1 = zzap.l1(str);
            if (l1 instanceof Parcelable[]) {
                j += (long) ((Parcelable[]) l1).length;
            }
        }
        return j;
    }

    public static long v(byte[] bArr) {
        Objects.requireNonNull(bArr, "null reference");
        int i = 0;
        gj1.n(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    public static MessageDigest w0() {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static Bundle z(List<zzku> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzku zzku : list) {
            String str = zzku.j;
            if (str != null) {
                bundle.putString(zzku.g, str);
            } else {
                Long l = zzku.i;
                if (l != null) {
                    bundle.putLong(zzku.g, l.longValue());
                } else {
                    Double d2 = zzku.l;
                    if (d2 != null) {
                        bundle.putDouble(zzku.g, d2.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    public final zzaq A(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (s(str2, z2) == 0) {
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            bundle2.putString(CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY, str3);
            Bundle y = y(str, str2, bundle2, Collections.singletonList(CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY), false);
            if (z) {
                y = x(y);
            }
            return new zzaq(str2, new zzap(y), str3, j);
        }
        g().f.b("Invalid conditional property event name", d().x(str2));
        throw new IllegalArgumentException();
    }

    public final Object B(int i, Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return D(String.valueOf(obj), i, z);
            }
            if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            for (Parcelable parcelable : parcelableArr) {
                if (parcelable instanceof Bundle) {
                    Bundle x = x((Bundle) parcelable);
                    if (!x.isEmpty()) {
                        arrayList.add(x);
                    }
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    public final Object C(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            return B(256, obj, true, true);
        }
        if (!q0(str)) {
            i = 100;
        }
        return B(i, obj, false, true);
    }

    public final void F(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            g().i.b("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    public final void G(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                if (!bundle.containsKey(str)) {
                    h().H(bundle, str, bundle2.get(str));
                }
            }
        }
    }

    public final void H(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                g().k.c("Not putting event parameter. Invalid value type. name, type", d().w(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void I(g24 g24, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            g24.zza(bundle);
        } catch (RemoteException e2) {
            this.f3331a.g().i.b("Error returning int value to wrapper", e2);
        }
    }

    public final void J(g24 g24, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            g24.zza(bundle);
        } catch (RemoteException e2) {
            this.f3331a.g().i.b("Error returning long value to wrapper", e2);
        }
    }

    public final void K(g24 g24, Bundle bundle) {
        try {
            g24.zza(bundle);
        } catch (RemoteException e2) {
            this.f3331a.g().i.b("Error returning bundle value to wrapper", e2);
        }
    }

    public final void L(g24 g24, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            g24.zza(bundle);
        } catch (RemoteException e2) {
            this.f3331a.g().i.b("Error returning string value to wrapper", e2);
        }
    }

    public final void M(g24 g24, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            g24.zza(bundle);
        } catch (RemoteException e2) {
            this.f3331a.g().i.b("Error returning bundle list to wrapper", e2);
        }
    }

    public final void N(g24 g24, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            g24.zza(bundle);
        } catch (RemoteException e2) {
            this.f3331a.g().i.b("Error returning boolean value to wrapper", e2);
        }
    }

    public final void O(g24 g24, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            g24.zza(bundle);
        } catch (RemoteException e2) {
            this.f3331a.g().i.b("Error returning byte array to wrapper", e2);
        }
    }

    public final void P(va4 va4, int i) {
        Iterator it = new TreeSet(va4.d.keySet()).iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (W(str) && (i2 = i2 + 1) > i) {
                StringBuilder sb = new StringBuilder(48);
                sb.append("Event can't contain more than ");
                sb.append(i);
                sb.append(" params");
                g().h.c(sb.toString(), d().t(va4.f3625a), d().q(va4.d));
                k0(va4.d, 5);
                va4.d.remove(str);
            }
        }
    }

    public final void Q(wg4 wg4, int i, String str, String str2, int i2) {
        R(wg4, null, i, str, str2, i2);
    }

    public final void R(wg4 wg4, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        k0(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        if (!((hy3) iy3.g.zza()).zza() || !this.f3331a.g.l(q64.O0)) {
            this.f3331a.s().G("auto", "_err", bundle);
        } else {
            wg4.a(str, bundle);
        }
    }

    public final void S(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z) {
        int i;
        String str4;
        int i2;
        if (bundle != null) {
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i3 = 0;
            while (it.hasNext()) {
                String str5 = (String) it.next();
                if (list == null || !list.contains(str5)) {
                    i = z ? t0(str5) : 0;
                    if (i == 0) {
                        i = v0(str5);
                    }
                } else {
                    i = 0;
                }
                if (i != 0) {
                    E(bundle, i, str5, i == 3 ? str5 : null);
                    bundle.remove(str5);
                } else {
                    if (V(bundle.get(str5))) {
                        g().k.d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                        i2 = 22;
                        str4 = str5;
                    } else {
                        str4 = str5;
                        i2 = q(str, str2, str5, bundle.get(str5), bundle, list, z, false);
                    }
                    if (i2 != 0 && !"_ev".equals(str4)) {
                        E(bundle, i2, str4, bundle.get(str4));
                        bundle.remove(str4);
                    } else if (W(str4) && !d0(str4, vc4.d) && (i3 = i3 + 1) > 0) {
                        g().h.c("Item cannot contain custom parameters", d().t(str2), d().q(bundle));
                        k0(bundle, 23);
                        bundle.remove(str4);
                    }
                }
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public final boolean X(String str, double d2) {
        try {
            SharedPreferences.Editor edit = this.f3331a.f3627a.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString("deeplink", str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d2));
            return edit.commit();
        } catch (Exception e2) {
            g().f.b("Failed to persist Deferred Deep Link. exception", e2);
            return false;
        }
    }

    public final boolean Y(String str, int i, String str2) {
        if (str2 == null) {
            g().h.b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            g().h.d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    public final boolean Z(String str, String str2) {
        if (str2 == null) {
            g().h.b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            g().h.b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                g().h.c("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    g().h.c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean a0(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i) {
                g().k.d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    public final boolean b0(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            Objects.requireNonNull(str, "null reference");
            if (str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                return true;
            }
            if (this.f3331a.v()) {
                g().h.b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", ra4.q(str));
            }
            return false;
        } else if (e04.a() && this.f3331a.g.l(q64.j0) && !TextUtils.isEmpty(str3)) {
            return true;
        } else {
            if (!TextUtils.isEmpty(str2)) {
                Objects.requireNonNull(str2, "null reference");
                if (str2.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                    return true;
                }
                g().h.b("Invalid admob_app_id. Analytics disabled.", ra4.q(str2));
                return false;
            }
            if (this.f3331a.v()) {
                g().h.a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
    }

    public final boolean e0(String str, String[] strArr, String[] strArr2, String str2) {
        boolean z;
        if (str2 == null) {
            g().h.b("Name is required and can't be null. Type", str);
            return false;
        }
        String[] strArr3 = g;
        int length = strArr3.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (str2.startsWith(strArr3[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            g().h.c("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (strArr == null || !d0(str2, strArr) || (strArr2 != null && d0(str2, strArr2))) {
            return true;
        } else {
            g().h.c("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public final int g0(String str) {
        if (!l0("user property", str)) {
            return 6;
        }
        if (!e0("user property", yc4.f4031a, null, str)) {
            return 15;
        }
        if (!Y("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    public final int h0(String str, Object obj) {
        boolean z;
        if ("_ldl".equals(str)) {
            z = a0("user property referrer", str, y0(str), obj);
        } else {
            z = a0("user property", str, y0(str), obj);
        }
        return z ? 0 : 7;
    }

    @Override // defpackage.sc4
    public final void j() {
        b();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                g().i.a("Utils falling back to Random for random id");
            }
        }
        this.d.set(nextLong);
    }

    public final boolean l0(String str, String str2) {
        if (str2 == null) {
            g().h.b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            g().h.b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        g().h.c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            g().h.c("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public final Object m0(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return B(y0(str), obj, true, false);
        }
        return B(y0(str), obj, false, false);
    }

    public final boolean n0(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = ob2.a(context).f2531a.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e2) {
            g().f.b("Error obtaining certificate", e2);
            return true;
        } catch (PackageManager.NameNotFoundException e3) {
            g().f.b("Package name not found", e3);
            return true;
        }
    }

    public final boolean o0(String str) {
        b();
        if (ob2.a(this.f3331a.f3627a).f2531a.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        g().m.b("Permission not granted", str);
        return false;
    }

    @Override // defpackage.sc4
    public final boolean p() {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int q(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.Object r20, android.os.Bundle r21, java.util.List<java.lang.String> r22, boolean r23, boolean r24) {
        /*
        // Method dump skipped, instructions count: 354
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ug4.q(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final boolean r0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f3331a.g.zza("debug.firebase.analytics.app", "").equals(str);
    }

    public final int s(String str, boolean z) {
        String[] strArr = wc4.f3761a;
        if (!l0("event", str)) {
            return 2;
        }
        if (z) {
            if (!e0("event", strArr, wc4.b, str)) {
                return 13;
            }
        } else if (!e0("event", strArr, null, str)) {
            return 13;
        }
        if (!Y("event", 40, str)) {
            return 2;
        }
        return 0;
    }

    public final long s0() {
        long andIncrement;
        long j;
        if (this.d.get() == 0) {
            synchronized (this.d) {
                long nanoTime = System.nanoTime();
                Objects.requireNonNull((db2) this.f3331a.n);
                long nextLong = new Random(nanoTime ^ System.currentTimeMillis()).nextLong();
                int i = this.e + 1;
                this.e = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.d) {
            this.d.compareAndSet(-1, 1);
            andIncrement = this.d.getAndIncrement();
        }
        return andIncrement;
    }

    public final int t0(String str) {
        if (!Z("event param", str)) {
            return 3;
        }
        if (!e0("event param", null, null, str)) {
            return 14;
        }
        if (!Y("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    public final SecureRandom u0() {
        b();
        if (this.c == null) {
            this.c = new SecureRandom();
        }
        return this.c;
    }

    public final int v0(String str) {
        if (!l0("event param", str)) {
            return 3;
        }
        if (!e0("event param", null, null, str)) {
            return 14;
        }
        if (!Y("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    public final Bundle w(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str4 = uri.getQueryParameter("utm_campaign");
                str3 = uri.getQueryParameter("utm_source");
                str2 = uri.getQueryParameter("utm_medium");
                str = uri.getQueryParameter("gclid");
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("campaign", str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("source", str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("medium", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("gclid", str);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e2) {
            g().i.b("Install referrer url isn't a hierarchical URI", e2);
            return null;
        }
    }

    public final Bundle x(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object C = C(str, bundle.get(str));
                if (C == null) {
                    g().k.b("Param value can't be null", d().w(str));
                } else {
                    H(bundle2, str, C);
                }
            }
        }
        return bundle2;
    }

    public final int x0() {
        if (this.f == null) {
            r22 r22 = r22.b;
            Context context = this.f3331a.f3627a;
            Objects.requireNonNull(r22);
            this.f = Integer.valueOf(u22.getApkVersion(context) / Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
        }
        return this.f.intValue();
    }

    /* JADX WARN: Incorrect args count in method signature: (Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/List<Ljava/lang/String;>;ZZ)Landroid/os/Bundle; */
    public final Bundle y(String str, String str2, Bundle bundle, List list, boolean z) {
        Set<String> set;
        int i;
        int i2;
        ug4 ug4 = this;
        boolean d0 = d0(str2, wc4.d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int s = ug4.f3331a.g.s();
        if (ug4.f3331a.g.t(str, q64.Z)) {
            set = new TreeSet<>(bundle.keySet());
        } else {
            set = bundle.keySet();
        }
        int i3 = 0;
        for (String str3 : set) {
            if (list == null || !list.contains(str3)) {
                i = z ? ug4.t0(str3) : 0;
                if (i == 0) {
                    i = ug4.v0(str3);
                }
            } else {
                i = 0;
            }
            if (i != 0) {
                E(bundle2, i, str3, i == 3 ? str3 : null);
                bundle2.remove(str3);
                i2 = s;
            } else {
                i2 = s;
                int q = q(str, str2, str3, bundle.get(str3), bundle2, list, z, d0);
                if (q == 17) {
                    E(bundle2, q, str3, Boolean.FALSE);
                } else if (q != 0 && !"_ev".equals(str3)) {
                    E(bundle2, q, q == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (W(str3)) {
                    int i4 = i3 + 1;
                    if (i4 > i2) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Event can't contain more than ");
                        sb.append(i2);
                        sb.append(" params");
                        g().h.c(sb.toString(), d().t(str2), d().q(bundle));
                        k0(bundle2, 5);
                        bundle2.remove(str3);
                        i3 = i4;
                        s = i2;
                        ug4 = this;
                    } else {
                        i3 = i4;
                    }
                }
            }
            s = i2;
            ug4 = this;
        }
        return bundle2;
    }

    public final int y0(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return (!this.f3331a.g.l(q64.h0) || !"_lgclid".equals(str)) ? 36 : 100;
    }
}
