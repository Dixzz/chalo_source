package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.ci6;
import defpackage.cj6;
import defpackage.fi6;
import defpackage.ol6;
import defpackage.vm6;
import defpackage.zm6;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: gh6  reason: default package */
/* compiled from: Cache.kt */
public final class gh6 implements Closeable, Flushable {
    public final cj6 f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    /* renamed from: gh6$a */
    /* compiled from: Cache.kt */
    public static final class a extends oi6 {
        public final ym6 f;
        public final cj6.c g;
        public final String h;
        public final String i;

        /* renamed from: gh6$a$a  reason: collision with other inner class name */
        /* compiled from: Cache.kt */
        public static final class C0024a extends cn6 {
            public final /* synthetic */ a f;
            public final /* synthetic */ qn6 g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0024a(a aVar, qn6 qn6, qn6 qn62) {
                super(qn62);
                this.f = aVar;
                this.g = qn6;
            }

            @Override // java.io.Closeable, defpackage.qn6, defpackage.cn6, java.lang.AutoCloseable
            public void close() throws IOException {
                this.f.g.close();
                super.close();
            }
        }

        public a(cj6.c cVar, String str, String str2) {
            n86.f(cVar, "snapshot");
            this.g = cVar;
            this.h = str;
            this.i = str2;
            qn6 qn6 = cVar.h.get(1);
            C0024a aVar = new C0024a(this, qn6, qn6);
            n86.f(aVar, "$this$buffer");
            this.f = new kn6(aVar);
        }

        @Override // defpackage.oi6
        public long contentLength() {
            String str = this.i;
            if (str != null) {
                byte[] bArr = vi6.f3652a;
                n86.f(str, "$this$toLongOrDefault");
                try {
                    return Long.parseLong(str);
                } catch (NumberFormatException unused) {
                }
            }
            return -1;
        }

        @Override // defpackage.oi6
        public fi6 contentType() {
            String str = this.h;
            if (str == null) {
                return null;
            }
            fi6.a aVar = fi6.f;
            return fi6.a.b(str);
        }

        @Override // defpackage.oi6
        public ym6 source() {
            return this.f;
        }
    }

    /* renamed from: gh6$c */
    /* compiled from: Cache.kt */
    public final class c implements aj6 {

        /* renamed from: a  reason: collision with root package name */
        public final on6 f1263a;
        public final on6 b;
        public boolean c;
        public final cj6.a d;
        public final /* synthetic */ gh6 e;

        /* renamed from: gh6$c$a */
        /* compiled from: Cache.kt */
        public static final class a extends bn6 {
            public final /* synthetic */ c g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar, on6 on6) {
                super(on6);
                this.g = cVar;
            }

            @Override // defpackage.on6, java.io.Closeable, defpackage.bn6, java.lang.AutoCloseable
            public void close() throws IOException {
                synchronized (this.g.e) {
                    c cVar = this.g;
                    if (!cVar.c) {
                        cVar.c = true;
                        cVar.e.g++;
                        this.f.close();
                        this.g.d.b();
                    }
                }
            }
        }

        public c(gh6 gh6, cj6.a aVar) {
            n86.f(aVar, "editor");
            this.e = gh6;
            this.d = aVar;
            on6 d2 = aVar.d(1);
            this.f1263a = d2;
            this.b = new a(this, d2);
        }

        @Override // defpackage.aj6
        public void abort() {
            synchronized (this.e) {
                if (!this.c) {
                    this.c = true;
                    this.e.h++;
                    vi6.c(this.f1263a);
                    try {
                        this.d.a();
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    public gh6(File file, long j2) {
        n86.f(file, "directory");
        gl6 gl6 = gl6.f1279a;
        n86.f(file, "directory");
        n86.f(gl6, "fileSystem");
        this.f = new cj6(gl6, file, 201105, 2, j2, ij6.h);
    }

    public static final String a(di6 di6) {
        n86.f(di6, "url");
        return zm6.j.c(di6.j).c("MD5").h();
    }

    public static final Set<String> e(ci6 ci6) {
        int size = ci6.size();
        TreeSet treeSet = null;
        for (int i2 = 0; i2 < size; i2++) {
            if (ea6.f("Vary", ci6.d(i2), true)) {
                String n = ci6.n(i2);
                if (treeSet == null) {
                    Comparator comparator = String.CASE_INSENSITIVE_ORDER;
                    n86.d(comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
                    treeSet = new TreeSet(comparator);
                }
                for (String str : ea6.A(n, new char[]{','}, false, 0, 6)) {
                    if (str != null) {
                        treeSet.add(ea6.K(str).toString());
                    } else {
                        throw new p56("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
                continue;
            }
        }
        return treeSet != null ? treeSet : d66.f;
    }

    public final void c(ji6 ji6) throws IOException {
        n86.f(ji6, "request");
        cj6 cj6 = this.f;
        di6 di6 = ji6.b;
        n86.f(di6, "url");
        String h2 = zm6.j.c(di6.j).c("MD5").h();
        synchronized (cj6) {
            n86.f(h2, AnalyticsConstants.KEY);
            cj6.g();
            cj6.a();
            cj6.p(h2);
            cj6.b bVar = cj6.l.get(h2);
            if (bVar != null) {
                n86.b(bVar, "lruEntries[key] ?: return false");
                cj6.n(bVar);
                if (cj6.j <= cj6.f) {
                    cj6.r = false;
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f.flush();
    }

    /* renamed from: gh6$b */
    /* compiled from: Cache.kt */
    public static final class b {
        public static final String k = "OkHttp-Sent-Millis";
        public static final String l = "OkHttp-Received-Millis";

        /* renamed from: a  reason: collision with root package name */
        public final String f1262a;
        public final ci6 b;
        public final String c;
        public final ii6 d;
        public final int e;
        public final String f;
        public final ci6 g;
        public final bi6 h;
        public final long i;
        public final long j;

        static {
            ol6.a aVar = ol6.c;
            Objects.requireNonNull(ol6.f2709a);
            Objects.requireNonNull(ol6.f2709a);
        }

        public b(qn6 qn6) throws IOException {
            qi6 qi6;
            n86.f(qn6, "rawSource");
            try {
                n86.f(qn6, "$this$buffer");
                kn6 kn6 = new kn6(qn6);
                this.f1262a = kn6.G0();
                this.c = kn6.G0();
                ci6.a aVar = new ci6.a();
                n86.f(kn6, "source");
                try {
                    long e2 = kn6.e();
                    String G0 = kn6.G0();
                    long j2 = 0;
                    if (e2 >= 0) {
                        long j3 = (long) Integer.MAX_VALUE;
                        if (e2 <= j3) {
                            boolean z = false;
                            if (!(G0.length() > 0)) {
                                int i2 = (int) e2;
                                for (int i3 = 0; i3 < i2; i3++) {
                                    aVar.b(kn6.G0());
                                }
                                this.b = aVar.d();
                                hk6 a2 = hk6.a(kn6.G0());
                                this.d = a2.f1386a;
                                this.e = a2.b;
                                this.f = a2.c;
                                ci6.a aVar2 = new ci6.a();
                                n86.f(kn6, "source");
                                try {
                                    long e3 = kn6.e();
                                    String G02 = kn6.G0();
                                    if (e3 >= 0 && e3 <= j3) {
                                        if (!(G02.length() > 0)) {
                                            int i4 = (int) e3;
                                            for (int i5 = 0; i5 < i4; i5++) {
                                                aVar2.b(kn6.G0());
                                            }
                                            String str = k;
                                            String e4 = aVar2.e(str);
                                            String str2 = l;
                                            String e5 = aVar2.e(str2);
                                            aVar2.f(str);
                                            aVar2.f(str2);
                                            this.i = e4 != null ? Long.parseLong(e4) : 0;
                                            this.j = e5 != null ? Long.parseLong(e5) : j2;
                                            this.g = aVar2.d();
                                            if (ea6.G(this.f1262a, "https://", false, 2)) {
                                                String G03 = kn6.G0();
                                                if (!(G03.length() > 0 ? true : z)) {
                                                    nh6 b2 = nh6.t.b(kn6.G0());
                                                    List<Certificate> a3 = a(kn6);
                                                    List<Certificate> a4 = a(kn6);
                                                    if (!kn6.R()) {
                                                        qi6 = qi6.Companion.a(kn6.G0());
                                                    } else {
                                                        qi6 = qi6.SSL_3_0;
                                                    }
                                                    n86.f(qi6, "tlsVersion");
                                                    n86.f(b2, "cipherSuite");
                                                    n86.f(a3, "peerCertificates");
                                                    n86.f(a4, "localCertificates");
                                                    this.h = new bi6(qi6, b2, vi6.y(a4), new zh6(vi6.y(a3)));
                                                } else {
                                                    throw new IOException("expected \"\" but was \"" + G03 + '\"');
                                                }
                                            } else {
                                                this.h = null;
                                            }
                                            return;
                                        }
                                    }
                                    throw new IOException("expected an int but was \"" + e3 + G02 + '\"');
                                } catch (NumberFormatException e6) {
                                    throw new IOException(e6.getMessage());
                                }
                            }
                        }
                    }
                    throw new IOException("expected an int but was \"" + e2 + G0 + '\"');
                } catch (NumberFormatException e7) {
                    throw new IOException(e7.getMessage());
                }
            } finally {
                qn6.close();
            }
        }

        public final List<Certificate> a(ym6 ym6) throws IOException {
            n86.f(ym6, "source");
            kn6 kn6 = (kn6) ym6;
            try {
                long e2 = kn6.e();
                String G0 = kn6.G0();
                if (e2 >= 0 && e2 <= ((long) Integer.MAX_VALUE)) {
                    if (!(G0.length() > 0)) {
                        int i2 = (int) e2;
                        if (i2 == -1) {
                            return b66.f;
                        }
                        try {
                            CertificateFactory instance = CertificateFactory.getInstance("X.509");
                            ArrayList arrayList = new ArrayList(i2);
                            for (int i3 = 0; i3 < i2; i3++) {
                                String G02 = kn6.G0();
                                vm6 vm6 = new vm6();
                                zm6 a2 = zm6.j.a(G02);
                                if (a2 != null) {
                                    vm6.t(a2);
                                    arrayList.add(instance.generateCertificate(new vm6.b(vm6)));
                                } else {
                                    n86.k();
                                    throw null;
                                }
                            }
                            return arrayList;
                        } catch (CertificateException e3) {
                            throw new IOException(e3.getMessage());
                        }
                    }
                }
                throw new IOException("expected an int but was \"" + e2 + G0 + '\"');
            } catch (NumberFormatException e4) {
                throw new IOException(e4.getMessage());
            }
        }

        public final void b(xm6 xm6, List<? extends Certificate> list) throws IOException {
            try {
                jn6 jn6 = (jn6) xm6;
                jn6.f1((long) list.size());
                jn6.S(10);
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    byte[] encoded = ((Certificate) list.get(i2)).getEncoded();
                    zm6.a aVar = zm6.j;
                    n86.b(encoded, "bytes");
                    jn6.k0(zm6.a.d(aVar, encoded, 0, 0, 3).a()).S(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0117, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0118, code lost:
            defpackage.hd3.H(r1, r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x011b, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void c(defpackage.cj6.a r9) throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 284
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.gh6.b.c(cj6$a):void");
        }

        public b(ni6 ni6) {
            ci6 ci6;
            n86.f(ni6, "response");
            this.f1262a = ni6.g.b.j;
            n86.f(ni6, "$this$varyHeaders");
            ni6 ni62 = ni6.n;
            if (ni62 != null) {
                ci6 ci62 = ni62.g.d;
                Set<String> e2 = gh6.e(ni6.l);
                if (e2.isEmpty()) {
                    ci6 = vi6.b;
                } else {
                    ci6.a aVar = new ci6.a();
                    int size = ci62.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String d2 = ci62.d(i2);
                        if (e2.contains(d2)) {
                            aVar.a(d2, ci62.n(i2));
                        }
                    }
                    ci6 = aVar.d();
                }
                this.b = ci6;
                this.c = ni6.g.c;
                this.d = ni6.h;
                this.e = ni6.j;
                this.f = ni6.i;
                this.g = ni6.l;
                this.h = ni6.k;
                this.i = ni6.q;
                this.j = ni6.r;
                return;
            }
            n86.k();
            throw null;
        }
    }
}
