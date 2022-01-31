package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.util.Constants;
import com.rabbitmq.client.ConnectionFactory;
import defpackage.al6;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: nk6  reason: default package */
/* compiled from: Hpack.kt */
public final class nk6 {

    /* renamed from: a  reason: collision with root package name */
    public static final mk6[] f2569a;
    public static final Map<zm6, Integer> b;
    public static final nk6 c = new nk6();

    /* renamed from: nk6$a */
    /* compiled from: Hpack.kt */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<mk6> f2570a;
        public final ym6 b;
        public mk6[] c;
        public int d;
        public int e;
        public int f;
        public final int g;
        public int h;

        public a(qn6 qn6, int i, int i2, int i3) {
            i2 = (i3 & 4) != 0 ? i : i2;
            n86.f(qn6, "source");
            this.g = i;
            this.h = i2;
            this.f2570a = new ArrayList();
            n86.f(qn6, "$this$buffer");
            this.b = new kn6(qn6);
            this.c = new mk6[8];
            this.d = 7;
        }

        public final void a() {
            y56.g(this.c, null, 0, 0, 6);
            this.d = this.c.length - 1;
            this.e = 0;
            this.f = 0;
        }

        public final int b(int i) {
            return this.d + 1 + i;
        }

        public final int c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.c.length;
                while (true) {
                    length--;
                    i2 = this.d;
                    if (length < i2 || i <= 0) {
                        mk6[] mk6Arr = this.c;
                        System.arraycopy(mk6Arr, i2 + 1, mk6Arr, i2 + 1 + i3, this.e);
                        this.d += i3;
                    } else {
                        mk6 mk6 = this.c[length];
                        if (mk6 != null) {
                            int i4 = mk6.f2393a;
                            i -= i4;
                            this.f -= i4;
                            this.e--;
                            i3++;
                        } else {
                            n86.k();
                            throw null;
                        }
                    }
                }
                mk6[] mk6Arr2 = this.c;
                System.arraycopy(mk6Arr2, i2 + 1, mk6Arr2, i2 + 1 + i3, this.e);
                this.d += i3;
            }
            return i3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x0010  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0019  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final defpackage.zm6 d(int r4) throws java.io.IOException {
            /*
                r3 = this;
                if (r4 < 0) goto L_0x000d
                nk6 r0 = defpackage.nk6.c
                mk6[] r0 = defpackage.nk6.f2569a
                int r0 = r0.length
                int r0 = r0 + -1
                if (r4 > r0) goto L_0x000d
                r0 = 1
                goto L_0x000e
            L_0x000d:
                r0 = 0
            L_0x000e:
                if (r0 == 0) goto L_0x0019
                nk6 r0 = defpackage.nk6.c
                mk6[] r0 = defpackage.nk6.f2569a
                r4 = r0[r4]
                zm6 r4 = r4.b
                goto L_0x0031
            L_0x0019:
                nk6 r0 = defpackage.nk6.c
                mk6[] r0 = defpackage.nk6.f2569a
                int r0 = r0.length
                int r0 = r4 - r0
                int r0 = r3.b(r0)
                if (r0 < 0) goto L_0x0037
                mk6[] r1 = r3.c
                int r2 = r1.length
                if (r0 >= r2) goto L_0x0037
                r4 = r1[r0]
                if (r4 == 0) goto L_0x0032
                zm6 r4 = r4.b
            L_0x0031:
                return r4
            L_0x0032:
                defpackage.n86.k()
                r4 = 0
                throw r4
            L_0x0037:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Header index too large "
                java.lang.StringBuilder r1 = defpackage.hj1.i0(r1)
                int r4 = r4 + 1
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.nk6.a.d(int):zm6");
        }

        public final void e(int i, mk6 mk6) {
            this.f2570a.add(mk6);
            int i2 = mk6.f2393a;
            if (i != -1) {
                mk6 mk62 = this.c[this.d + 1 + i];
                if (mk62 != null) {
                    i2 -= mk62.f2393a;
                } else {
                    n86.k();
                    throw null;
                }
            }
            int i3 = this.h;
            if (i2 > i3) {
                a();
                return;
            }
            int c2 = c((this.f + i2) - i3);
            if (i == -1) {
                int i4 = this.e + 1;
                mk6[] mk6Arr = this.c;
                if (i4 > mk6Arr.length) {
                    mk6[] mk6Arr2 = new mk6[(mk6Arr.length * 2)];
                    System.arraycopy(mk6Arr, 0, mk6Arr2, mk6Arr.length, mk6Arr.length);
                    this.d = this.c.length - 1;
                    this.c = mk6Arr2;
                }
                int i5 = this.d;
                this.d = i5 - 1;
                this.c[i5] = mk6;
                this.e++;
            } else {
                this.c[this.d + 1 + i + c2 + i] = mk6;
            }
            this.f += i2;
        }

        public final zm6 f() throws IOException {
            byte readByte = this.b.readByte();
            byte[] bArr = vi6.f3652a;
            int i = readByte & 255;
            int i2 = 0;
            boolean z = (i & 128) == 128;
            long g2 = (long) g(i, 127);
            if (!z) {
                return this.b.v(g2);
            }
            vm6 vm6 = new vm6();
            al6 al6 = al6.d;
            ym6 ym6 = this.b;
            al6.a aVar = al6.c;
            n86.f(ym6, "source");
            n86.f(vm6, "sink");
            al6.a aVar2 = aVar;
            int i3 = 0;
            for (long j = 0; j < g2; j++) {
                byte readByte2 = ym6.readByte();
                byte[] bArr2 = vi6.f3652a;
                i2 = (i2 << 8) | (readByte2 & 255);
                i3 += 8;
                while (i3 >= 8) {
                    int i4 = i3 - 8;
                    int i5 = (i2 >>> i4) & Constants.MAX_HOST_LENGTH;
                    al6.a[] aVarArr = aVar2.f179a;
                    if (aVarArr != null) {
                        aVar2 = aVarArr[i5];
                        if (aVar2 == null) {
                            n86.k();
                            throw null;
                        } else if (aVar2.f179a == null) {
                            vm6.A(aVar2.b);
                            i3 -= aVar2.c;
                            aVar2 = aVar;
                        } else {
                            i3 = i4;
                        }
                    } else {
                        n86.k();
                        throw null;
                    }
                }
            }
            while (i3 > 0) {
                int i6 = (i2 << (8 - i3)) & Constants.MAX_HOST_LENGTH;
                al6.a[] aVarArr2 = aVar2.f179a;
                if (aVarArr2 != null) {
                    al6.a aVar3 = aVarArr2[i6];
                    if (aVar3 != null) {
                        if (aVar3.f179a != null || aVar3.c > i3) {
                            break;
                        }
                        vm6.A(aVar3.b);
                        i3 -= aVar3.c;
                        aVar2 = aVar;
                    } else {
                        n86.k();
                        throw null;
                    }
                } else {
                    n86.k();
                    throw null;
                }
            }
            return vm6.v0();
        }

        public final int g(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                byte readByte = this.b.readByte();
                byte[] bArr = vi6.f3652a;
                int i5 = readByte & 255;
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }
    }

    /* renamed from: nk6$b */
    /* compiled from: Hpack.kt */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2571a;
        public boolean b;
        public int c;
        public mk6[] d;
        public int e;
        public int f;
        public int g;
        public int h;
        public final boolean i;
        public final vm6 j;

        public b(int i2, boolean z, vm6 vm6, int i3) {
            i2 = (i3 & 1) != 0 ? 4096 : i2;
            z = (i3 & 2) != 0 ? true : z;
            n86.f(vm6, "out");
            this.h = i2;
            this.i = z;
            this.j = vm6;
            this.f2571a = Integer.MAX_VALUE;
            this.c = i2;
            this.d = new mk6[8];
            this.e = 7;
        }

        public final void a() {
            y56.g(this.d, null, 0, 0, 6);
            this.e = this.d.length - 1;
            this.f = 0;
            this.g = 0;
        }

        public final int b(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.d.length;
                while (true) {
                    length--;
                    i3 = this.e;
                    if (length < i3 || i2 <= 0) {
                        mk6[] mk6Arr = this.d;
                        System.arraycopy(mk6Arr, i3 + 1, mk6Arr, i3 + 1 + i4, this.f);
                        mk6[] mk6Arr2 = this.d;
                        int i5 = this.e;
                        Arrays.fill(mk6Arr2, i5 + 1, i5 + 1 + i4, (Object) null);
                        this.e += i4;
                    } else {
                        mk6[] mk6Arr3 = this.d;
                        mk6 mk6 = mk6Arr3[length];
                        if (mk6 != null) {
                            i2 -= mk6.f2393a;
                            int i6 = this.g;
                            mk6 mk62 = mk6Arr3[length];
                            if (mk62 != null) {
                                this.g = i6 - mk62.f2393a;
                                this.f--;
                                i4++;
                            } else {
                                n86.k();
                                throw null;
                            }
                        } else {
                            n86.k();
                            throw null;
                        }
                    }
                }
                mk6[] mk6Arr4 = this.d;
                System.arraycopy(mk6Arr4, i3 + 1, mk6Arr4, i3 + 1 + i4, this.f);
                mk6[] mk6Arr22 = this.d;
                int i52 = this.e;
                Arrays.fill(mk6Arr22, i52 + 1, i52 + 1 + i4, (Object) null);
                this.e += i4;
            }
            return i4;
        }

        public final void c(mk6 mk6) {
            int i2 = mk6.f2393a;
            int i3 = this.c;
            if (i2 > i3) {
                a();
                return;
            }
            b((this.g + i2) - i3);
            int i4 = this.f + 1;
            mk6[] mk6Arr = this.d;
            if (i4 > mk6Arr.length) {
                mk6[] mk6Arr2 = new mk6[(mk6Arr.length * 2)];
                System.arraycopy(mk6Arr, 0, mk6Arr2, mk6Arr.length, mk6Arr.length);
                this.e = this.d.length - 1;
                this.d = mk6Arr2;
            }
            int i5 = this.e;
            this.e = i5 - 1;
            this.d[i5] = mk6;
            this.f++;
            this.g += i2;
        }

        public final void d(zm6 zm6) throws IOException {
            n86.f(zm6, "data");
            int i2 = 0;
            if (this.i) {
                al6 al6 = al6.d;
                n86.f(zm6, "bytes");
                int g2 = zm6.g();
                long j2 = 0;
                for (int i3 = 0; i3 < g2; i3++) {
                    byte j3 = zm6.j(i3);
                    byte[] bArr = vi6.f3652a;
                    j2 += (long) al6.b[j3 & 255];
                }
                if (((int) ((j2 + ((long) 7)) >> 3)) < zm6.g()) {
                    vm6 vm6 = new vm6();
                    al6 al62 = al6.d;
                    n86.f(zm6, "source");
                    n86.f(vm6, "sink");
                    int g3 = zm6.g();
                    long j4 = 0;
                    byte b2 = 0;
                    while (i2 < g3) {
                        byte j5 = zm6.j(i2);
                        byte[] bArr2 = vi6.f3652a;
                        int i4 = j5 & 255;
                        int i5 = al6.f178a[i4];
                        byte b3 = al6.b[i4];
                        j4 = (j4 << b3) | ((long) i5);
                        int i6 = b2 + b3;
                        while (i6 >= 8) {
                            i6 = (i6 == 1 ? 1 : 0) - 8;
                            vm6.S((int) (j4 >> i6));
                        }
                        i2++;
                        b2 = i6;
                    }
                    if (b2 > 0) {
                        vm6.S((int) ((255 >>> (b2 == 1 ? 1 : 0)) | (j4 << (8 - b2))));
                    }
                    zm6 v0 = vm6.v0();
                    f(v0.g(), 127, 128);
                    this.j.t(v0);
                    return;
                }
            }
            f(zm6.g(), 127, 0);
            this.j.t(zm6);
        }

        public final void e(List<mk6> list) throws IOException {
            int i2;
            int i3;
            n86.f(list, "headerBlock");
            if (this.b) {
                int i4 = this.f2571a;
                if (i4 < this.c) {
                    f(i4, 31, 32);
                }
                this.b = false;
                this.f2571a = Integer.MAX_VALUE;
                f(this.c, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                mk6 mk6 = list.get(i5);
                zm6 m = mk6.b.m();
                zm6 zm6 = mk6.c;
                nk6 nk6 = nk6.c;
                Integer num = nk6.b.get(m);
                if (num != null) {
                    i3 = num.intValue() + 1;
                    if (2 <= i3 && 7 >= i3) {
                        mk6[] mk6Arr = nk6.f2569a;
                        if (n86.a(mk6Arr[i3 - 1].c, zm6)) {
                            i2 = i3;
                        } else if (n86.a(mk6Arr[i3].c, zm6)) {
                            i2 = i3;
                            i3++;
                        }
                    }
                    i2 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                    i2 = -1;
                }
                if (i3 == -1) {
                    int i6 = this.e + 1;
                    int length = this.d.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        mk6 mk62 = this.d[i6];
                        if (mk62 != null) {
                            if (n86.a(mk62.b, m)) {
                                mk6 mk63 = this.d[i6];
                                if (mk63 == null) {
                                    n86.k();
                                    throw null;
                                } else if (n86.a(mk63.c, zm6)) {
                                    int i7 = i6 - this.e;
                                    nk6 nk62 = nk6.c;
                                    i3 = nk6.f2569a.length + i7;
                                    break;
                                } else if (i2 == -1) {
                                    nk6 nk63 = nk6.c;
                                    i2 = (i6 - this.e) + nk6.f2569a.length;
                                }
                            }
                            i6++;
                        } else {
                            n86.k();
                            throw null;
                        }
                    }
                }
                if (i3 != -1) {
                    f(i3, 127, 128);
                } else if (i2 == -1) {
                    this.j.A(64);
                    d(m);
                    d(zm6);
                    c(mk6);
                } else {
                    zm6 zm62 = mk6.d;
                    Objects.requireNonNull(m);
                    n86.f(zm62, "prefix");
                    if (!m.k(0, zm62, 0, zm62.g()) || !(!n86.a(mk6.i, m))) {
                        f(i2, 63, 64);
                        d(zm6);
                        c(mk6);
                    } else {
                        f(i2, 15, 0);
                        d(zm6);
                    }
                }
            }
        }

        public final void f(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.j.A(i2 | i4);
                return;
            }
            this.j.A(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.j.A(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.j.A(i5);
        }
    }

    static {
        mk6 mk6 = new mk6(mk6.i, "");
        zm6 zm6 = mk6.f;
        zm6 zm62 = mk6.g;
        zm6 zm63 = mk6.h;
        zm6 zm64 = mk6.e;
        mk6[] mk6Arr = {mk6, new mk6(zm6, FirebasePerformance.HttpMethod.GET), new mk6(zm6, FirebasePerformance.HttpMethod.POST), new mk6(zm62, ConnectionFactory.DEFAULT_VHOST), new mk6(zm62, "/index.html"), new mk6(zm63, "http"), new mk6(zm63, "https"), new mk6(zm64, "200"), new mk6(zm64, "204"), new mk6(zm64, "206"), new mk6(zm64, "304"), new mk6(zm64, "400"), new mk6(zm64, "404"), new mk6(zm64, "500"), new mk6("accept-charset", ""), new mk6("accept-encoding", "gzip, deflate"), new mk6("accept-language", ""), new mk6("accept-ranges", ""), new mk6("accept", ""), new mk6("access-control-allow-origin", ""), new mk6("age", ""), new mk6("allow", ""), new mk6("authorization", ""), new mk6("cache-control", ""), new mk6("content-disposition", ""), new mk6("content-encoding", ""), new mk6("content-language", ""), new mk6("content-length", ""), new mk6("content-location", ""), new mk6("content-range", ""), new mk6("content-type", ""), new mk6("cookie", ""), new mk6("date", ""), new mk6("etag", ""), new mk6("expect", ""), new mk6("expires", ""), new mk6(Constants.MessagePayloadKeys.FROM, ""), new mk6("host", ""), new mk6("if-match", ""), new mk6("if-modified-since", ""), new mk6("if-none-match", ""), new mk6("if-range", ""), new mk6("if-unmodified-since", ""), new mk6("last-modified", ""), new mk6("link", ""), new mk6(FirebaseAnalytics.Param.LOCATION, ""), new mk6("max-forwards", ""), new mk6("proxy-authenticate", ""), new mk6("proxy-authorization", ""), new mk6("range", ""), new mk6("referer", ""), new mk6("refresh", ""), new mk6("retry-after", ""), new mk6("server", ""), new mk6("set-cookie", ""), new mk6("strict-transport-security", ""), new mk6("transfer-encoding", ""), new mk6("user-agent", ""), new mk6("vary", ""), new mk6("via", ""), new mk6("www-authenticate", "")};
        f2569a = mk6Arr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(mk6Arr.length);
        int length = mk6Arr.length;
        for (int i = 0; i < length; i++) {
            mk6[] mk6Arr2 = f2569a;
            if (!linkedHashMap.containsKey(mk6Arr2[i].b)) {
                linkedHashMap.put(mk6Arr2[i].b, Integer.valueOf(i));
            }
        }
        Map<zm6, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        n86.b(unmodifiableMap, "Collections.unmodifiableMap(result)");
        b = unmodifiableMap;
    }

    public final zm6 a(zm6 zm6) throws IOException {
        n86.f(zm6, "name");
        int g = zm6.g();
        for (int i = 0; i < g; i++) {
            byte b2 = (byte) 65;
            byte b3 = (byte) 90;
            byte j = zm6.j(i);
            if (b2 <= j && b3 >= j) {
                StringBuilder i0 = hj1.i0("PROTOCOL_ERROR response malformed: mixed case name: ");
                i0.append(zm6.p());
                throw new IOException(i0.toString());
            }
        }
        return zm6;
    }
}
