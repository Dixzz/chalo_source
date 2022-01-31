package defpackage;

import com.razorpay.AnalyticsConstants;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: cj6  reason: default package */
/* compiled from: DiskLruCache.kt */
public final class cj6 implements Closeable, Flushable {
    public static final ca6 A = new ca6("[a-z0-9_-]{1,120}");
    public static final String B = B;
    public static final String C = C;
    public static final String D = D;
    public static final String E = E;
    public long f;
    public final File g;
    public final File h;
    public final File i;
    public long j;
    public xm6 k;
    public final LinkedHashMap<String, b> l = new LinkedHashMap<>(0, 0.75f, true);
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public long t;
    public final hj6 u;
    public final d v;
    public final gl6 w;
    public final File x;
    public final int y;
    public final int z;

    /* renamed from: cj6$a */
    /* compiled from: DiskLruCache.kt */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean[] f572a;
        public boolean b;
        public final b c;
        public final /* synthetic */ cj6 d;

        /* renamed from: cj6$a$a  reason: collision with other inner class name */
        /* compiled from: DiskLruCache.kt */
        public static final class C0005a extends o86 implements s76<IOException, s56> {
            public final /* synthetic */ a f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0005a(a aVar, int i) {
                super(1);
                this.f = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // defpackage.s76
            public s56 invoke(IOException iOException) {
                n86.f(iOException, "it");
                synchronized (this.f.d) {
                    this.f.c();
                }
                return s56.f3190a;
            }
        }

        public a(cj6 cj6, b bVar) {
            boolean[] zArr;
            n86.f(bVar, "entry");
            this.d = cj6;
            this.c = bVar;
            if (bVar.d) {
                zArr = null;
            } else {
                zArr = new boolean[cj6.z];
            }
            this.f572a = zArr;
        }

        public final void a() throws IOException {
            synchronized (this.d) {
                if (!this.b) {
                    if (n86.a(this.c.f, this)) {
                        this.d.c(this, false);
                    }
                    this.b = true;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void b() throws IOException {
            synchronized (this.d) {
                if (!this.b) {
                    if (n86.a(this.c.f, this)) {
                        this.d.c(this, true);
                    }
                    this.b = true;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void c() {
            if (n86.a(this.c.f, this)) {
                cj6 cj6 = this.d;
                if (cj6.o) {
                    cj6.c(this, false);
                } else {
                    this.c.e = true;
                }
            }
        }

        public final on6 d(int i) {
            synchronized (this.d) {
                if (!(!this.b)) {
                    throw new IllegalStateException("Check failed.".toString());
                } else if (!n86.a(this.c.f, this)) {
                    return new um6();
                } else {
                    b bVar = this.c;
                    if (!bVar.d) {
                        boolean[] zArr = this.f572a;
                        if (zArr != null) {
                            zArr[i] = true;
                        } else {
                            n86.k();
                            throw null;
                        }
                    }
                    try {
                        return new ej6(this.d.w.b(bVar.c.get(i)), new C0005a(this, i));
                    } catch (FileNotFoundException unused) {
                        return new um6();
                    }
                }
            }
        }
    }

    /* renamed from: cj6$b */
    /* compiled from: DiskLruCache.kt */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f573a;
        public final List<File> b = new ArrayList();
        public final List<File> c = new ArrayList();
        public boolean d;
        public boolean e;
        public a f;
        public int g;
        public long h;
        public final String i;
        public final /* synthetic */ cj6 j;

        public b(cj6 cj6, String str) {
            n86.f(str, AnalyticsConstants.KEY);
            this.j = cj6;
            this.i = str;
            this.f573a = new long[cj6.z];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            int i2 = cj6.z;
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(i3);
                this.b.add(new File(cj6.x, sb.toString()));
                sb.append(".tmp");
                this.c.add(new File(cj6.x, sb.toString()));
                sb.setLength(length);
            }
        }

        public final c a() {
            cj6 cj6 = this.j;
            byte[] bArr = vi6.f3652a;
            if (!this.d) {
                return null;
            }
            if (!cj6.o && (this.f != null || this.e)) {
                return null;
            }
            ArrayList<qn6> arrayList = new ArrayList();
            long[] jArr = (long[]) this.f573a.clone();
            try {
                int i2 = this.j.z;
                for (int i3 = 0; i3 < i2; i3++) {
                    qn6 a2 = this.j.w.a(this.b.get(i3));
                    if (!this.j.o) {
                        this.g++;
                        a2 = new dj6(this, a2, a2);
                    }
                    arrayList.add(a2);
                }
                return new c(this.j, this.i, this.h, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                for (qn6 qn6 : arrayList) {
                    vi6.c(qn6);
                }
                try {
                    this.j.n(this);
                } catch (IOException unused2) {
                }
                return null;
            }
        }

        public final void b(xm6 xm6) throws IOException {
            n86.f(xm6, "writer");
            for (long j2 : this.f573a) {
                xm6.S(32).f1(j2);
            }
        }
    }

    /* renamed from: cj6$c */
    /* compiled from: DiskLruCache.kt */
    public final class c implements Closeable {
        public final String f;
        public final long g;
        public final List<qn6> h;
        public final /* synthetic */ cj6 i;

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<? extends qn6> */
        /* JADX WARN: Multi-variable type inference failed */
        public c(cj6 cj6, String str, long j, List<? extends qn6> list, long[] jArr) {
            n86.f(str, AnalyticsConstants.KEY);
            n86.f(list, "sources");
            n86.f(jArr, "lengths");
            this.i = cj6;
            this.f = str;
            this.g = j;
            this.h = list;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (qn6 qn6 : this.h) {
                vi6.c(qn6);
            }
        }
    }

    /* renamed from: cj6$d */
    /* compiled from: DiskLruCache.kt */
    public static final class d extends fj6 {
        public final /* synthetic */ cj6 e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(cj6 cj6, String str) {
            super(str, true);
            this.e = cj6;
        }

        @Override // defpackage.fj6
        public long a() {
            synchronized (this.e) {
                cj6 cj6 = this.e;
                if (!cj6.p || cj6.q) {
                    return -1;
                }
                try {
                    cj6.o();
                } catch (IOException unused) {
                    this.e.r = true;
                }
                try {
                    if (this.e.h()) {
                        this.e.m();
                        this.e.m = 0;
                    }
                } catch (IOException unused2) {
                    cj6 cj62 = this.e;
                    cj62.s = true;
                    um6 um6 = new um6();
                    n86.f(um6, "$this$buffer");
                    cj62.k = new jn6(um6);
                }
                return -1;
            }
        }
    }

    /* renamed from: cj6$e */
    /* compiled from: DiskLruCache.kt */
    public static final class e extends o86 implements s76<IOException, s56> {
        public final /* synthetic */ cj6 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(cj6 cj6) {
            super(1);
            this.f = cj6;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.s76
        public s56 invoke(IOException iOException) {
            n86.f(iOException, "it");
            cj6 cj6 = this.f;
            byte[] bArr = vi6.f3652a;
            cj6.n = true;
            return s56.f3190a;
        }
    }

    public cj6(gl6 gl6, File file, int i2, int i3, long j2, ij6 ij6) {
        n86.f(gl6, "fileSystem");
        n86.f(file, "directory");
        n86.f(ij6, "taskRunner");
        this.w = gl6;
        this.x = file;
        this.y = i2;
        this.z = i3;
        this.f = j2;
        boolean z2 = false;
        this.u = ij6.f();
        this.v = new d(this, hj1.a0(new StringBuilder(), vi6.g, " Cache"));
        if (j2 > 0) {
            if (i3 > 0 ? true : z2) {
                this.g = new File(file, "journal");
                this.h = new File(file, "journal.tmp");
                this.i = new File(file, "journal.bkp");
                return;
            }
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    public final synchronized void a() {
        if (!(!this.q)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public final synchronized void c(a aVar, boolean z2) throws IOException {
        n86.f(aVar, "editor");
        b bVar = aVar.c;
        if (n86.a(bVar.f, aVar)) {
            if (z2 && !bVar.d) {
                int i2 = this.z;
                for (int i3 = 0; i3 < i2; i3++) {
                    boolean[] zArr = aVar.f572a;
                    if (zArr == null) {
                        n86.k();
                        throw null;
                    } else if (!zArr[i3]) {
                        aVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i3);
                    } else if (!this.w.d(bVar.c.get(i3))) {
                        aVar.a();
                        return;
                    }
                }
            }
            int i4 = this.z;
            for (int i5 = 0; i5 < i4; i5++) {
                File file = bVar.c.get(i5);
                if (!z2 || bVar.e) {
                    this.w.f(file);
                } else if (this.w.d(file)) {
                    File file2 = bVar.b.get(i5);
                    this.w.e(file, file2);
                    long j2 = bVar.f573a[i5];
                    long h2 = this.w.h(file2);
                    bVar.f573a[i5] = h2;
                    this.j = (this.j - j2) + h2;
                }
            }
            bVar.f = null;
            if (bVar.e) {
                n(bVar);
                return;
            }
            this.m++;
            xm6 xm6 = this.k;
            if (xm6 != null) {
                if (bVar.d || z2) {
                    bVar.d = true;
                    xm6.k0(B).S(32);
                    xm6.k0(bVar.i);
                    bVar.b(xm6);
                    xm6.S(10);
                    if (z2) {
                        long j3 = this.t;
                        this.t = 1 + j3;
                        bVar.h = j3;
                    }
                } else {
                    this.l.remove(bVar.i);
                    xm6.k0(D).S(32);
                    xm6.k0(bVar.i);
                    xm6.S(10);
                }
                xm6.flush();
                if (this.j > this.f || h()) {
                    hj6.d(this.u, this.v, 0, 2);
                }
                return;
            }
            n86.k();
            throw null;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.p) {
            if (!this.q) {
                Collection<b> values = this.l.values();
                n86.b(values, "lruEntries.values");
                Object[] array = values.toArray(new b[0]);
                if (array != null) {
                    for (b bVar : (b[]) array) {
                        a aVar = bVar.f;
                        if (!(aVar == null || aVar == null)) {
                            aVar.c();
                        }
                    }
                    o();
                    xm6 xm6 = this.k;
                    if (xm6 != null) {
                        xm6.close();
                        this.k = null;
                        this.q = true;
                        return;
                    }
                    n86.k();
                    throw null;
                }
                throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        this.q = true;
    }

    public final synchronized a e(String str, long j2) throws IOException {
        n86.f(str, AnalyticsConstants.KEY);
        g();
        a();
        p(str);
        b bVar = this.l.get(str);
        if (j2 != -1 && (bVar == null || bVar.h != j2)) {
            return null;
        }
        if ((bVar != null ? bVar.f : null) != null) {
            return null;
        }
        if (bVar != null && bVar.g != 0) {
            return null;
        }
        if (this.r || this.s) {
            hj6.d(this.u, this.v, 0, 2);
            return null;
        }
        xm6 xm6 = this.k;
        if (xm6 != null) {
            xm6.k0(C).S(32).k0(str).S(10);
            xm6.flush();
            if (this.n) {
                return null;
            }
            if (bVar == null) {
                bVar = new b(this, str);
                this.l.put(str, bVar);
            }
            a aVar = new a(this, bVar);
            bVar.f = aVar;
            return aVar;
        }
        n86.k();
        throw null;
    }

    public final synchronized c f(String str) throws IOException {
        n86.f(str, AnalyticsConstants.KEY);
        g();
        a();
        p(str);
        b bVar = this.l.get(str);
        if (bVar == null) {
            return null;
        }
        n86.b(bVar, "lruEntries[key] ?: return null");
        c a2 = bVar.a();
        if (a2 == null) {
            return null;
        }
        this.m++;
        xm6 xm6 = this.k;
        if (xm6 != null) {
            xm6.k0(E).S(32).k0(str).S(10);
            if (h()) {
                hj6.d(this.u, this.v, 0, 2);
            }
            return a2;
        }
        n86.k();
        throw null;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.p) {
            a();
            o();
            xm6 xm6 = this.k;
            if (xm6 != null) {
                xm6.flush();
            } else {
                n86.k();
                throw null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        defpackage.hd3.H(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void g() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 183
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cj6.g():void");
    }

    public final boolean h() {
        int i2 = this.m;
        return i2 >= 2000 && i2 >= this.l.size();
    }

    public final xm6 i() throws FileNotFoundException {
        ej6 ej6 = new ej6(this.w.g(this.g), new e(this));
        n86.f(ej6, "$this$buffer");
        return new jn6(ej6);
    }

    public final void j() throws IOException {
        this.w.f(this.h);
        Iterator<b> it = this.l.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            n86.b(next, "i.next()");
            b bVar = next;
            int i2 = 0;
            if (bVar.f == null) {
                int i3 = this.z;
                while (i2 < i3) {
                    this.j += bVar.f573a[i2];
                    i2++;
                }
            } else {
                bVar.f = null;
                int i4 = this.z;
                while (i2 < i4) {
                    this.w.f(bVar.b.get(i2));
                    this.w.f(bVar.c.get(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b2, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b3, code lost:
        defpackage.hd3.H(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b6, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 183
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cj6.k():void");
    }

    public final void l(String str) throws IOException {
        String str2;
        int m2 = ea6.m(str, ' ', 0, false, 6);
        if (m2 != -1) {
            int i2 = m2 + 1;
            int m3 = ea6.m(str, ' ', i2, false, 4);
            if (m3 == -1) {
                str2 = str.substring(i2);
                n86.b(str2, "(this as java.lang.String).substring(startIndex)");
                String str3 = D;
                if (m2 == str3.length() && ea6.G(str, str3, false, 2)) {
                    this.l.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, m3);
                n86.b(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            b bVar = this.l.get(str2);
            if (bVar == null) {
                bVar = new b(this, str2);
                this.l.put(str2, bVar);
            }
            if (m3 != -1) {
                String str4 = B;
                if (m2 == str4.length() && ea6.G(str, str4, false, 2)) {
                    String substring = str.substring(m3 + 1);
                    n86.b(substring, "(this as java.lang.String).substring(startIndex)");
                    List A2 = ea6.A(substring, new char[]{' '}, false, 0, 6);
                    bVar.d = true;
                    bVar.f = null;
                    n86.f(A2, "strings");
                    if (A2.size() == bVar.j.z) {
                        try {
                            int size = A2.size();
                            for (int i3 = 0; i3 < size; i3++) {
                                bVar.f573a[i3] = Long.parseLong((String) A2.get(i3));
                            }
                            return;
                        } catch (NumberFormatException unused) {
                            throw new IOException("unexpected journal line: " + A2);
                        }
                    } else {
                        throw new IOException("unexpected journal line: " + A2);
                    }
                }
            }
            if (m3 == -1) {
                String str5 = C;
                if (m2 == str5.length() && ea6.G(str, str5, false, 2)) {
                    bVar.f = new a(this, bVar);
                    return;
                }
            }
            if (m3 == -1) {
                String str6 = E;
                if (m2 == str6.length() && ea6.G(str, str6, false, 2)) {
                    return;
                }
            }
            throw new IOException(hj1.S("unexpected journal line: ", str));
        }
        throw new IOException(hj1.S("unexpected journal line: ", str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b6, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b7, code lost:
        defpackage.hd3.H(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ba, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 190
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cj6.m():void");
    }

    public final boolean n(b bVar) throws IOException {
        xm6 xm6;
        n86.f(bVar, "entry");
        if (!this.o) {
            if (bVar.g > 0 && (xm6 = this.k) != null) {
                xm6.k0(C);
                xm6.S(32);
                xm6.k0(bVar.i);
                xm6.S(10);
                xm6.flush();
            }
            if (bVar.g > 0 || bVar.f != null) {
                bVar.e = true;
                return true;
            }
        }
        a aVar = bVar.f;
        if (aVar != null) {
            aVar.c();
        }
        int i2 = this.z;
        for (int i3 = 0; i3 < i2; i3++) {
            this.w.f(bVar.b.get(i3));
            long j2 = this.j;
            long[] jArr = bVar.f573a;
            this.j = j2 - jArr[i3];
            jArr[i3] = 0;
        }
        this.m++;
        xm6 xm62 = this.k;
        if (xm62 != null) {
            xm62.k0(D);
            xm62.S(32);
            xm62.k0(bVar.i);
            xm62.S(10);
        }
        this.l.remove(bVar.i);
        if (h()) {
            hj6.d(this.u, this.v, 0, 2);
        }
        return true;
    }

    public final void o() throws IOException {
        boolean z2;
        do {
            z2 = false;
            if (this.j > this.f) {
                Iterator<b> it = this.l.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b next = it.next();
                    if (!next.e) {
                        n86.b(next, "toEvict");
                        n(next);
                        z2 = true;
                        continue;
                        break;
                    }
                }
            } else {
                this.r = false;
                return;
            }
        } while (z2);
    }

    public final void p(String str) {
        if (!A.a(str)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
        }
    }
}
