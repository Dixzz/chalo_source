package defpackage;

import defpackage.fi6;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.regex.Pattern;

/* renamed from: oi6  reason: default package */
/* compiled from: ResponseBody.kt */
public abstract class oi6 implements Closeable {
    public static final b Companion = new b(null);
    private Reader reader;

    /* renamed from: oi6$a */
    /* compiled from: ResponseBody.kt */
    public static final class a extends Reader {
        public boolean f;
        public Reader g;
        public final ym6 h;
        public final Charset i;

        public a(ym6 ym6, Charset charset) {
            n86.f(ym6, "source");
            n86.f(charset, "charset");
            this.h = ym6;
            this.i = charset;
        }

        @Override // java.io.Closeable, java.io.Reader, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f = true;
            Reader reader = this.g;
            if (reader != null) {
                reader.close();
            } else {
                this.h.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) throws IOException {
            n86.f(cArr, "cbuf");
            if (!this.f) {
                Reader reader = this.g;
                if (reader == null) {
                    reader = new InputStreamReader(this.h.j1(), vi6.r(this.h, this.i));
                    this.g = reader;
                }
                return reader.read(cArr, i2, i3);
            }
            throw new IOException("Stream closed");
        }
    }

    /* renamed from: oi6$b */
    /* compiled from: ResponseBody.kt */
    public static final class b {

        /* renamed from: oi6$b$a */
        /* compiled from: ResponseBody.kt */
        public static final class a extends oi6 {
            public final /* synthetic */ ym6 f;
            public final /* synthetic */ fi6 g;
            public final /* synthetic */ long h;

            public a(ym6 ym6, fi6 fi6, long j) {
                this.f = ym6;
                this.g = fi6;
                this.h = j;
            }

            @Override // defpackage.oi6
            public long contentLength() {
                return this.h;
            }

            @Override // defpackage.oi6
            public fi6 contentType() {
                return this.g;
            }

            @Override // defpackage.oi6
            public ym6 source() {
                return this.f;
            }
        }

        public b(j86 j86) {
        }

        public final oi6 a(String str, fi6 fi6) {
            n86.f(str, "$this$toResponseBody");
            Charset charset = aa6.f144a;
            if (fi6 != null) {
                Pattern pattern = fi6.d;
                Charset a2 = fi6.a(null);
                if (a2 == null) {
                    fi6.a aVar = fi6.f;
                    fi6 = fi6.a.b(fi6 + "; charset=utf-8");
                } else {
                    charset = a2;
                }
            }
            vm6 vm6 = new vm6();
            n86.f(str, "string");
            n86.f(charset, "charset");
            vm6.M(str, 0, str.length(), charset);
            return b(vm6, fi6, vm6.g);
        }

        public final oi6 b(ym6 ym6, fi6 fi6, long j) {
            n86.f(ym6, "$this$asResponseBody");
            return new a(ym6, fi6, j);
        }

        public final oi6 c(zm6 zm6, fi6 fi6) {
            n86.f(zm6, "$this$toResponseBody");
            vm6 vm6 = new vm6();
            vm6.t(zm6);
            n86.f(vm6, "$this$asResponseBody");
            return new a(vm6, fi6, (long) zm6.g());
        }

        public final oi6 d(byte[] bArr, fi6 fi6) {
            n86.f(bArr, "$this$toResponseBody");
            vm6 vm6 = new vm6();
            vm6.w(bArr);
            n86.f(vm6, "$this$asResponseBody");
            return new a(vm6, fi6, (long) bArr.length);
        }
    }

    private final Charset charset() {
        Charset a2;
        fi6 contentType = contentType();
        return (contentType == null || (a2 = contentType.a(aa6.f144a)) == null) ? aa6.f144a : a2;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0055, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0056, code lost:
        defpackage.hd3.H(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0059, code lost:
        throw r7;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> T consumeSource(defpackage.s76<? super defpackage.ym6, ? extends T> r6, defpackage.s76<? super T, java.lang.Integer> r7) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oi6.consumeSource(s76, s76):java.lang.Object");
    }

    public static final oi6 create(fi6 fi6, long j, ym6 ym6) {
        Objects.requireNonNull(Companion);
        n86.f(ym6, "content");
        n86.f(ym6, "$this$asResponseBody");
        return new b.a(ym6, fi6, j);
    }

    public static final oi6 create(String str, fi6 fi6) {
        return Companion.a(str, fi6);
    }

    public static final oi6 create(zm6 zm6, fi6 fi6) {
        return Companion.c(zm6, fi6);
    }

    public static final oi6 create(byte[] bArr, fi6 fi6) {
        return Companion.d(bArr, fi6);
    }

    public final InputStream byteStream() {
        return source().j1();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        defpackage.hd3.H(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.zm6 byteString() throws java.io.IOException {
        /*
            r7 = this;
            long r0 = r7.contentLength()
            r2 = 2147483647(0x7fffffff, float:NaN)
            long r2 = (long) r2
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0054
            ym6 r2 = r7.source()
            r3 = 0
            zm6 r4 = r2.v0()     // Catch:{ all -> 0x004d }
            defpackage.hd3.H(r2, r3)
            int r2 = r4.g()
            r5 = -1
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x004c
            long r5 = (long) r2
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0028
            goto L_0x004c
        L_0x0028:
            java.io.IOException r3 = new java.io.IOException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Content-Length ("
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = ") and stream length ("
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = ") disagree"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        L_0x004c:
            return r4
        L_0x004d:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x004f }
        L_0x004f:
            r1 = move-exception
            defpackage.hd3.H(r2, r0)
            throw r1
        L_0x0054:
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Cannot buffer entire body for content length: "
            java.lang.String r0 = defpackage.hj1.M(r3, r0)
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oi6.byteString():zm6");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        defpackage.hd3.H(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] bytes() throws java.io.IOException {
        /*
            r7 = this;
            long r0 = r7.contentLength()
            r2 = 2147483647(0x7fffffff, float:NaN)
            long r2 = (long) r2
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0051
            ym6 r2 = r7.source()
            r3 = 0
            byte[] r4 = r2.O()     // Catch:{ all -> 0x004a }
            defpackage.hd3.H(r2, r3)
            int r2 = r4.length
            r5 = -1
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0049
            long r5 = (long) r2
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0025
            goto L_0x0049
        L_0x0025:
            java.io.IOException r3 = new java.io.IOException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Content-Length ("
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = ") and stream length ("
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = ") disagree"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        L_0x0049:
            return r4
        L_0x004a:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r1 = move-exception
            defpackage.hd3.H(r2, r0)
            throw r1
        L_0x0051:
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "Cannot buffer entire body for content length: "
            java.lang.String r0 = defpackage.hj1.M(r3, r0)
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oi6.bytes():byte[]");
    }

    public final Reader charStream() {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        a aVar = new a(source(), charset());
        this.reader = aVar;
        return aVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        vi6.c(source());
    }

    public abstract long contentLength();

    public abstract fi6 contentType();

    public abstract ym6 source();

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        defpackage.hd3.H(r0, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String string() throws java.io.IOException {
        /*
            r3 = this;
            ym6 r0 = r3.source()
            java.nio.charset.Charset r1 = r3.charset()     // Catch:{ all -> 0x0015 }
            java.nio.charset.Charset r1 = defpackage.vi6.r(r0, r1)     // Catch:{ all -> 0x0015 }
            java.lang.String r1 = r0.p0(r1)     // Catch:{ all -> 0x0015 }
            r2 = 0
            defpackage.hd3.H(r0, r2)
            return r1
        L_0x0015:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r2 = move-exception
            defpackage.hd3.H(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oi6.string():java.lang.String");
    }

    public static final oi6 create(fi6 fi6, String str) {
        b bVar = Companion;
        Objects.requireNonNull(bVar);
        n86.f(str, "content");
        return bVar.a(str, fi6);
    }

    public static final oi6 create(fi6 fi6, zm6 zm6) {
        b bVar = Companion;
        Objects.requireNonNull(bVar);
        n86.f(zm6, "content");
        return bVar.c(zm6, fi6);
    }

    public static final oi6 create(fi6 fi6, byte[] bArr) {
        b bVar = Companion;
        Objects.requireNonNull(bVar);
        n86.f(bArr, "content");
        return bVar.d(bArr, fi6);
    }

    public static final oi6 create(ym6 ym6, fi6 fi6, long j) {
        Objects.requireNonNull(Companion);
        n86.f(ym6, "$this$asResponseBody");
        return new b.a(ym6, fi6, j);
    }
}
