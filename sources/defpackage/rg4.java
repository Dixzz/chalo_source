package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.freshchat.consumer.sdk.beans.User;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzn;
import com.razorpay.AnalyticsConstants;
import defpackage.cr3;
import defpackage.ru3;
import defpackage.uq3;
import defpackage.wq3;
import defpackage.yq3;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: rg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class rg4 extends jg4 {
    public rg4(lg4 lg4) {
        super(lg4);
    }

    public static List<Long> A(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static List<wq3> C(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                wq3.a P = wq3.P();
                for (String str : bundle.keySet()) {
                    wq3.a P2 = wq3.P();
                    P2.o(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        P2.m(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        P2.p((String) obj);
                    } else if (obj instanceof Double) {
                        P2.l(((Double) obj).doubleValue());
                    }
                    if (P.h) {
                        P.i();
                        P.h = false;
                    }
                    wq3.w((wq3) P.g, (wq3) ((ru3) P2.k()));
                }
                if (((wq3) P.g).O() > 0) {
                    arrayList.add((wq3) ((ru3) P.k()));
                }
            }
        }
        return arrayList;
    }

    public static void D(uq3.a aVar, String str, Object obj) {
        List<wq3> s = aVar.s();
        int i = 0;
        while (true) {
            if (i >= s.size()) {
                i = -1;
                break;
            } else if (str.equals(s.get(i).A())) {
                break;
            } else {
                i++;
            }
        }
        wq3.a P = wq3.P();
        P.o(str);
        if (obj instanceof Long) {
            P.m(((Long) obj).longValue());
        } else if (obj instanceof String) {
            P.p((String) obj);
        } else if (obj instanceof Double) {
            P.l(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            List<wq3> C = C((Bundle[]) obj);
            if (P.h) {
                P.i();
                P.h = false;
            }
            wq3.x((wq3) P.g, C);
        }
        if (i >= 0) {
            if (aVar.h) {
                aVar.i();
                aVar.h = false;
            }
            uq3.x((uq3) aVar.g, i, (wq3) ((ru3) P.k()));
            return;
        }
        aVar.o(P);
    }

    public static void G(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    public static void I(StringBuilder sb, int i, String str, fq3 fq3) {
        if (fq3 != null) {
            G(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (fq3.t()) {
                K(sb, i, "comparison_type", fq3.u().name());
            }
            if (fq3.v()) {
                K(sb, i, "match_as_float", Boolean.valueOf(fq3.w()));
            }
            if (fq3.x()) {
                K(sb, i, "comparison_value", fq3.y());
            }
            if (fq3.z()) {
                K(sb, i, "min_comparison_value", fq3.A());
            }
            if (fq3.B()) {
                K(sb, i, "max_comparison_value", fq3.C());
            }
            G(sb, i);
            sb.append("}\n");
        }
    }

    public static void J(StringBuilder sb, int i, String str, ar3 ar3) {
        if (ar3 != null) {
            G(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (ar3.F() != 0) {
                G(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long l : ar3.D()) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l);
                    i2 = i3;
                }
                sb.append('\n');
            }
            if (ar3.y() != 0) {
                G(sb, 4);
                sb.append("status: ");
                int i4 = 0;
                for (Long l2 : ar3.u()) {
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l2);
                    i4 = i5;
                }
                sb.append('\n');
            }
            if (ar3.I() != 0) {
                G(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i6 = 0;
                for (tq3 tq3 : ar3.H()) {
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(tq3.v() ? Integer.valueOf(tq3.w()) : null);
                    sb.append(ProductDiscountsObject.KEY_DELIMITER);
                    sb.append(tq3.x() ? Long.valueOf(tq3.y()) : null);
                    i6 = i7;
                }
                sb.append("}\n");
            }
            if (ar3.K() != 0) {
                G(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i8 = 0;
                for (br3 br3 : ar3.J()) {
                    int i9 = i8 + 1;
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    sb.append(br3.w() ? Integer.valueOf(br3.x()) : null);
                    sb.append(": [");
                    int i10 = 0;
                    for (Long l3 : br3.y()) {
                        long longValue = l3.longValue();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue);
                        i10 = i11;
                    }
                    sb.append("]");
                    i8 = i9;
                }
                sb.append("}\n");
            }
            G(sb, 3);
            sb.append("}\n");
        }
    }

    public static void K(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            G(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append('\n');
        }
    }

    public static boolean N(zzaq zzaq, zzn zzn) {
        Objects.requireNonNull(zzaq, "null reference");
        return !TextUtils.isEmpty(zzn.g) || !TextUtils.isEmpty(zzn.w);
    }

    public static boolean O(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static boolean P(List<Long> list, int i) {
        if (i >= (((qv3) list).h << 6)) {
            return false;
        }
        return ((1 << (i % 64)) & ((Long) ((qv3) list).get(i / 64)).longValue()) != 0;
    }

    public static Object Q(uq3 uq3, String str) {
        wq3 v = v(uq3, str);
        if (v == null) {
            return null;
        }
        if (v.E()) {
            return v.F();
        }
        if (v.H()) {
            return Long.valueOf(v.I());
        }
        if (v.L()) {
            return Double.valueOf(v.M());
        }
        if (v.O() <= 0) {
            return null;
        }
        List<wq3> N = v.N();
        ArrayList arrayList = new ArrayList();
        for (wq3 wq3 : N) {
            if (wq3 != null) {
                Bundle bundle = new Bundle();
                for (wq3 wq32 : wq3.N()) {
                    if (wq32.E()) {
                        bundle.putString(wq32.A(), wq32.F());
                    } else if (wq32.H()) {
                        bundle.putLong(wq32.A(), wq32.I());
                    } else if (wq32.L()) {
                        bundle.putDouble(wq32.A(), wq32.M());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static int q(yq3.a aVar, String str) {
        for (int i = 0; i < ((yq3) aVar.g).O0(); i++) {
            if (str.equals(((yq3) aVar.g).g0(i).C())) {
                return i;
            }
        }
        return -1;
    }

    public static wq3 v(uq3 uq3, String str) {
        for (wq3 wq3 : uq3.u()) {
            if (wq3.A().equals(str)) {
                return wq3;
            }
        }
        return null;
    }

    public static <Builder extends bw3> Builder w(Builder builder, byte[] bArr) throws cv3 {
        eu3 eu3 = eu3.c;
        if (eu3 == null) {
            synchronized (eu3.class) {
                eu3 = eu3.c;
                if (eu3 == null) {
                    eu3 = pu3.b(eu3.class);
                    eu3.c = eu3;
                }
            }
        }
        if (eu3 != null) {
            kt3 kt3 = (kt3) builder;
            Objects.requireNonNull(kt3);
            ru3.b bVar = (ru3.b) kt3;
            bVar.h(bArr, bArr.length, eu3);
            return bVar;
        }
        kt3 kt32 = (kt3) builder;
        Objects.requireNonNull(kt32);
        ru3.b bVar2 = (ru3.b) kt32;
        bVar2.h(bArr, bArr.length, eu3.a());
        return bVar2;
    }

    public static String z(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    public final List<Long> B(List<Long> list, List<Integer> list2) {
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                g().i.b("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    g().i.c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            size = size2;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, size);
    }

    public final void E(wq3.a aVar, Object obj) {
        Objects.requireNonNull(obj, "null reference");
        if (aVar.h) {
            aVar.i();
            aVar.h = false;
        }
        wq3.t((wq3) aVar.g);
        if (aVar.h) {
            aVar.i();
            aVar.h = false;
        }
        wq3.B((wq3) aVar.g);
        if (aVar.h) {
            aVar.i();
            aVar.h = false;
        }
        wq3.D((wq3) aVar.g);
        if (aVar.h) {
            aVar.i();
            aVar.h = false;
        }
        wq3.G((wq3) aVar.g);
        if (obj instanceof String) {
            aVar.p((String) obj);
        } else if (obj instanceof Long) {
            aVar.m(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.l(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            List<wq3> C = C((Bundle[]) obj);
            if (aVar.h) {
                aVar.i();
                aVar.h = false;
            }
            wq3.x((wq3) aVar.g, C);
        } else {
            g().f.b("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void F(cr3.a aVar, Object obj) {
        Objects.requireNonNull(obj, "null reference");
        if (aVar.h) {
            aVar.i();
            aVar.h = false;
        }
        cr3.t((cr3) aVar.g);
        if (aVar.h) {
            aVar.i();
            aVar.h = false;
        }
        cr3.z((cr3) aVar.g);
        if (aVar.h) {
            aVar.i();
            aVar.h = false;
        }
        cr3.D((cr3) aVar.g);
        if (obj instanceof String) {
            String str = (String) obj;
            if (aVar.h) {
                aVar.i();
                aVar.h = false;
            }
            cr3.B((cr3) aVar.g, str);
        } else if (obj instanceof Long) {
            aVar.o(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (aVar.h) {
                aVar.i();
                aVar.h = false;
            }
            cr3.u((cr3) aVar.g, doubleValue);
        } else {
            g().f.b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void H(StringBuilder sb, int i, eq3 eq3) {
        if (eq3 != null) {
            G(sb, i);
            sb.append("filter {\n");
            if (eq3.y()) {
                K(sb, i, "complement", Boolean.valueOf(eq3.z()));
            }
            if (eq3.A()) {
                K(sb, i, "param_name", d().w(eq3.B()));
            }
            if (eq3.u()) {
                int i2 = i + 1;
                hq3 v = eq3.v();
                if (v != null) {
                    G(sb, i2);
                    sb.append("string_filter");
                    sb.append(" {\n");
                    if (v.t()) {
                        K(sb, i2, "match_type", v.u().name());
                    }
                    if (v.v()) {
                        K(sb, i2, "expression", v.w());
                    }
                    if (v.x()) {
                        K(sb, i2, "case_sensitive", Boolean.valueOf(v.y()));
                    }
                    if (v.A() > 0) {
                        G(sb, i2 + 1);
                        sb.append("expression_list {\n");
                        for (String str : v.z()) {
                            G(sb, i2 + 2);
                            sb.append(str);
                            sb.append("\n");
                        }
                        sb.append("}\n");
                    }
                    G(sb, i2);
                    sb.append("}\n");
                }
            }
            if (eq3.w()) {
                I(sb, i + 1, "number_filter", eq3.x());
            }
            G(sb, i);
            sb.append("}\n");
        }
    }

    public final void L(StringBuilder sb, int i, List<wq3> list) {
        if (list != null) {
            int i2 = i + 1;
            for (wq3 wq3 : list) {
                if (wq3 != null) {
                    G(sb, i2);
                    sb.append("param {\n");
                    Double d = null;
                    K(sb, i2, "name", wq3.z() ? d().w(wq3.A()) : null);
                    K(sb, i2, "string_value", wq3.E() ? wq3.F() : null);
                    K(sb, i2, "int_value", wq3.H() ? Long.valueOf(wq3.I()) : null);
                    if (wq3.L()) {
                        d = Double.valueOf(wq3.M());
                    }
                    K(sb, i2, "double_value", d);
                    if (wq3.O() > 0) {
                        L(sb, i2, wq3.N());
                    }
                    G(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    public final boolean M(long j, long j2) {
        if (j == 0 || j2 <= 0) {
            return true;
        }
        Objects.requireNonNull((db2) this.f3331a.n);
        return Math.abs(System.currentTimeMillis() - j) > j2;
    }

    public final byte[] R(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            g().f.b("Failed to ungzip content", e);
            throw e;
        }
    }

    public final byte[] S(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            g().f.b("Failed to gzip content", e);
            throw e;
        }
    }

    public final List<Integer> T() {
        Context context = this.b.j.f3627a;
        List<ka4<?>> list = q64.f2906a;
        vr3 a2 = vr3.a(context.getContentResolver(), fs3.a("com.google.android.gms.measurement"));
        Map<String, String> emptyMap = a2 == null ? Collections.emptyMap() : a2.b();
        if (emptyMap == null || emptyMap.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = q64.P.a(null).intValue();
        Iterator<Map.Entry<String, String>> it = emptyMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> next = it.next();
            if (next.getKey().startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt(next.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            g().i.b("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    g().i.b("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @Override // defpackage.jg4
    public final boolean n() {
        return false;
    }

    public final long s(byte[] bArr) {
        h().b();
        MessageDigest w0 = ug4.w0();
        if (w0 != null) {
            return ug4.v(w0.digest(bArr));
        }
        g().f.a("Failed to get MD5");
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        g().f.a("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends android.os.Parcelable> T t(byte[] r5, android.os.Parcelable.Creator<T> r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ l82 -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ l82 -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ l82 -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ l82 -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ l82 -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002b
        L_0x001c:
            ra4 r5 = r4.g()     // Catch:{ all -> 0x001a }
            ta4 r5 = r5.f     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.a(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002b:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rg4.t(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    public final uq3 u(n64 n64) {
        uq3.a L = uq3.L();
        long j = n64.e;
        if (L.h) {
            L.i();
            L.h = false;
        }
        uq3.D((uq3) L.g, j);
        zzap zzap = n64.f;
        Objects.requireNonNull(zzap);
        for (String str : zzap.f.keySet()) {
            wq3.a P = wq3.P();
            P.o(str);
            E(P, n64.f.l1(str));
            L.o(P);
        }
        return (uq3) ((ru3) L.k());
    }

    public final String x(gq3 gq3) {
        StringBuilder i0 = hj1.i0("\nproperty_filter {\n");
        if (gq3.u()) {
            K(i0, 0, "filter_id", Integer.valueOf(gq3.v()));
        }
        K(i0, 0, "property_name", d().x(gq3.w()));
        String z = z(gq3.y(), gq3.z(), gq3.B());
        if (!z.isEmpty()) {
            K(i0, 0, "filter_type", z);
        }
        H(i0, 1, gq3.x());
        i0.append("}\n");
        return i0.toString();
    }

    public final String y(xq3 xq3) {
        StringBuilder i0 = hj1.i0("\nbatch {\n");
        for (yq3 yq3 : xq3.u()) {
            if (yq3 != null) {
                G(i0, 1);
                i0.append("bundle {\n");
                if (yq3.D()) {
                    K(i0, 1, "protocol_version", Integer.valueOf(yq3.f0()));
                }
                K(i0, 1, "platform", yq3.x1());
                if (yq3.H1()) {
                    K(i0, 1, "gmp_version", Long.valueOf(yq3.E()));
                }
                if (yq3.G()) {
                    K(i0, 1, "uploading_gmp_version", Long.valueOf(yq3.H()));
                }
                if (yq3.o0()) {
                    K(i0, 1, "dynamite_version", Long.valueOf(yq3.p0()));
                }
                if (yq3.Z()) {
                    K(i0, 1, "config_version", Long.valueOf(yq3.a0()));
                }
                K(i0, 1, "gmp_app_id", yq3.R());
                K(i0, 1, "admob_app_id", yq3.n0());
                K(i0, 1, "app_id", yq3.F1());
                K(i0, 1, User.DEVICE_META_APP_VERSION_NAME, yq3.G1());
                if (yq3.W()) {
                    K(i0, 1, "app_version_major", Integer.valueOf(yq3.X()));
                }
                K(i0, 1, "firebase_instance_id", yq3.V());
                if (yq3.M()) {
                    K(i0, 1, "dev_cert_hash", Long.valueOf(yq3.N()));
                }
                K(i0, 1, "app_store", yq3.E1());
                if (yq3.X0()) {
                    K(i0, 1, "upload_timestamp_millis", Long.valueOf(yq3.Y0()));
                }
                if (yq3.f1()) {
                    K(i0, 1, "start_timestamp_millis", Long.valueOf(yq3.g1()));
                }
                if (yq3.m1()) {
                    K(i0, 1, "end_timestamp_millis", Long.valueOf(yq3.n1()));
                }
                if (yq3.r1()) {
                    K(i0, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(yq3.s1()));
                }
                if (yq3.u1()) {
                    K(i0, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(yq3.v1()));
                }
                K(i0, 1, "app_instance_id", yq3.L());
                K(i0, 1, "resettable_device_id", yq3.I());
                K(i0, 1, "device_id", yq3.Y());
                K(i0, 1, "ds_id", yq3.d0());
                if (yq3.J()) {
                    K(i0, 1, "limited_ad_tracking", Boolean.valueOf(yq3.K()));
                }
                K(i0, 1, User.DEVICE_META_OS_VERSION_NAME, yq3.z1());
                K(i0, 1, AnalyticsConstants.DEVICE_MODEL, yq3.A1());
                K(i0, 1, "user_default_language", yq3.B1());
                if (yq3.C1()) {
                    K(i0, 1, "time_zone_offset_minutes", Integer.valueOf(yq3.D1()));
                }
                if (yq3.O()) {
                    K(i0, 1, "bundle_sequential_index", Integer.valueOf(yq3.P()));
                }
                if (yq3.S()) {
                    K(i0, 1, "service_upload", Boolean.valueOf(yq3.T()));
                }
                K(i0, 1, "health_monitor", yq3.Q());
                if (!this.f3331a.g.l(q64.y0) && yq3.b0() && yq3.c0() != 0) {
                    K(i0, 1, AnalyticsConstants.ANDROID_ID, Long.valueOf(yq3.c0()));
                }
                if (yq3.e0()) {
                    K(i0, 1, "retry_counter", Integer.valueOf(yq3.m0()));
                }
                if (yq3.r0()) {
                    K(i0, 1, "consent_signals", yq3.s0());
                }
                List<cr3> J0 = yq3.J0();
                if (J0 != null) {
                    for (cr3 cr3 : J0) {
                        if (cr3 != null) {
                            G(i0, 2);
                            i0.append("user_property {\n");
                            Double d = null;
                            K(i0, 2, "set_timestamp_millis", cr3.x() ? Long.valueOf(cr3.y()) : null);
                            K(i0, 2, "name", d().x(cr3.C()));
                            K(i0, 2, "string_value", cr3.F());
                            K(i0, 2, "int_value", cr3.G() ? Long.valueOf(cr3.H()) : null);
                            if (cr3.I()) {
                                d = Double.valueOf(cr3.J());
                            }
                            K(i0, 2, "double_value", d);
                            G(i0, 2);
                            i0.append("}\n");
                        }
                    }
                }
                List<sq3> U = yq3.U();
                if (U != null) {
                    for (sq3 sq3 : U) {
                        if (sq3 != null) {
                            G(i0, 2);
                            i0.append("audience_membership {\n");
                            if (sq3.w()) {
                                K(i0, 2, "audience_id", Integer.valueOf(sq3.x()));
                            }
                            if (sq3.C()) {
                                K(i0, 2, "new_audience", Boolean.valueOf(sq3.D()));
                            }
                            J(i0, 2, "current_data", sq3.z());
                            if (sq3.A()) {
                                J(i0, 2, "previous_data", sq3.B());
                            }
                            G(i0, 2);
                            i0.append("}\n");
                        }
                    }
                }
                List<uq3> x0 = yq3.x0();
                if (x0 != null) {
                    for (uq3 uq3 : x0) {
                        if (uq3 != null) {
                            G(i0, 2);
                            i0.append("event {\n");
                            K(i0, 2, "name", d().t(uq3.E()));
                            if (uq3.F()) {
                                K(i0, 2, "timestamp_millis", Long.valueOf(uq3.G()));
                            }
                            if (uq3.H()) {
                                K(i0, 2, "previous_timestamp_millis", Long.valueOf(uq3.I()));
                            }
                            if (uq3.J()) {
                                K(i0, 2, "count", Integer.valueOf(uq3.K()));
                            }
                            if (uq3.C() != 0) {
                                L(i0, 2, uq3.u());
                            }
                            G(i0, 2);
                            i0.append("}\n");
                        }
                    }
                }
                G(i0, 1);
                i0.append("}\n");
            }
        }
        i0.append("}\n");
        return i0.toString();
    }
}
