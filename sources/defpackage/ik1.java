package defpackage;

import android.os.SystemClock;
import com.google.firebase.perf.util.Constants;
import com.rabbitmq.client.StringRpcServer;
import defpackage.jj1;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: ik1  reason: default package */
/* compiled from: DiskBasedCache */
public class ik1 implements jj1 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f1527a = new LinkedHashMap(16, 0.75f, true);
    public long b = 0;
    public final File c;
    public final int d;

    public ik1(File file) {
        this.c = file;
        this.d = 5242880;
    }

    public static int g(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public static int h(InputStream inputStream) throws IOException {
        return (g(inputStream) << 24) | (g(inputStream) << 0) | 0 | (g(inputStream) << 8) | (g(inputStream) << 16);
    }

    public static long i(InputStream inputStream) throws IOException {
        return ((((long) g(inputStream)) & 255) << 0) | 0 | ((((long) g(inputStream)) & 255) << 8) | ((((long) g(inputStream)) & 255) << 16) | ((((long) g(inputStream)) & 255) << 24) | ((((long) g(inputStream)) & 255) << 32) | ((((long) g(inputStream)) & 255) << 40) | ((((long) g(inputStream)) & 255) << 48) | ((255 & ((long) g(inputStream))) << 56);
    }

    public static String j(b bVar) throws IOException {
        return new String(l(bVar, i(bVar)), StringRpcServer.STRING_ENCODING);
    }

    public static byte[] l(b bVar, long j) throws IOException {
        long j2 = bVar.f - bVar.g;
        if (j >= 0 && j <= j2) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + j2);
    }

    public static void m(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & Constants.MAX_HOST_LENGTH);
        outputStream.write((i >> 8) & Constants.MAX_HOST_LENGTH);
        outputStream.write((i >> 16) & Constants.MAX_HOST_LENGTH);
        outputStream.write((i >> 24) & Constants.MAX_HOST_LENGTH);
    }

    public static void n(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    public static void o(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(StringRpcServer.STRING_ENCODING);
        n(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    public synchronized void a() {
        File[] listFiles = this.c.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
        this.f1527a.clear();
        this.b = 0;
        ek1.a("Cache cleared.", new Object[0]);
    }

    public File b(String str) {
        return new File(this.c, c(str));
    }

    public final String c(String str) {
        int length = str.length() / 2;
        StringBuilder i0 = hj1.i0(String.valueOf(str.substring(0, length).hashCode()));
        i0.append(String.valueOf(str.substring(length).hashCode()));
        return i0.toString();
    }

    public final void d(int i) {
        long j;
        long j2 = (long) i;
        if (this.b + j2 >= ((long) this.d)) {
            if (ek1.f981a) {
                ek1.b("Pruning old cache entries.", new Object[0]);
            }
            long j3 = this.b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, a>> it = this.f1527a.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (b(value.b).delete()) {
                    j = j2;
                    this.b -= value.f1528a;
                } else {
                    j = j2;
                    String str = value.b;
                    ek1.a("Could not delete cache entry for key=%s, filename=%s", str, c(str));
                }
                it.remove();
                i2++;
                if (((float) (this.b + j)) < ((float) this.d) * 0.9f) {
                    break;
                }
                j2 = j;
            }
            if (ek1.f981a) {
                ek1.b("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.b - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    public synchronized void e(String str, jj1.a aVar) {
        d(aVar.f1933a.length);
        File b2 = b(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(b2));
            a aVar2 = new a(str, aVar);
            if (aVar2.c(bufferedOutputStream)) {
                bufferedOutputStream.write(aVar.f1933a);
                bufferedOutputStream.close();
                f(str, aVar2);
            } else {
                bufferedOutputStream.close();
                ek1.a("Failed to write header for %s", b2.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException unused) {
            if (!b2.delete()) {
                ek1.a("Could not clean up file %s", b2.getAbsolutePath());
            }
        }
    }

    public final void f(String str, a aVar) {
        if (!this.f1527a.containsKey(str)) {
            this.b += aVar.f1528a;
        } else {
            this.b = (aVar.f1528a - this.f1527a.get(str).f1528a) + this.b;
        }
        this.f1527a.put(str, aVar);
    }

    public synchronized void k(String str) {
        boolean delete = b(str).delete();
        a remove = this.f1527a.remove(str);
        if (remove != null) {
            this.b -= remove.f1528a;
        }
        if (!delete) {
            ek1.a("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }

    /* renamed from: ik1$b */
    /* compiled from: DiskBasedCache */
    public static class b extends FilterInputStream {
        public final long f;
        public long g;

        public b(InputStream inputStream, long j) {
            super(inputStream);
            this.f = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.g++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.g += (long) read;
            }
            return read;
        }
    }

    /* renamed from: ik1$a */
    /* compiled from: DiskBasedCache */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f1528a;
        public final String b;
        public final String c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;
        public final List<pj1> h;

        public a(String str, String str2, long j, long j2, long j3, long j4, List<pj1> list) {
            this.b = str;
            this.c = "".equals(str2) ? null : str2;
            this.d = j;
            this.e = j2;
            this.f = j3;
            this.g = j4;
            this.h = list;
        }

        public static a a(b bVar) throws IOException {
            if (ik1.h(bVar) == 538247942) {
                String j = ik1.j(bVar);
                String j2 = ik1.j(bVar);
                long i = ik1.i(bVar);
                long i2 = ik1.i(bVar);
                long i3 = ik1.i(bVar);
                long i4 = ik1.i(bVar);
                int h2 = ik1.h(bVar);
                if (h2 >= 0) {
                    List emptyList = h2 == 0 ? Collections.emptyList() : new ArrayList();
                    for (int i5 = 0; i5 < h2; i5++) {
                        emptyList.add(new pj1(ik1.j(bVar).intern(), ik1.j(bVar).intern()));
                    }
                    return new a(j, j2, i, i2, i3, i4, emptyList);
                }
                throw new IOException(hj1.I("readHeaderList size=", h2));
            }
            throw new IOException();
        }

        public jj1.a b(byte[] bArr) {
            jj1.a aVar = new jj1.a();
            aVar.f1933a = bArr;
            aVar.b = this.c;
            aVar.c = this.d;
            aVar.d = this.e;
            aVar.e = this.f;
            aVar.f = this.g;
            List<pj1> list = this.h;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (pj1 pj1 : list) {
                treeMap.put(pj1.f2812a, pj1.b);
            }
            aVar.g = treeMap;
            aVar.h = Collections.unmodifiableList(this.h);
            return aVar;
        }

        public boolean c(OutputStream outputStream) {
            try {
                ik1.m(outputStream, 538247942);
                ik1.o(outputStream, this.b);
                String str = this.c;
                if (str == null) {
                    str = "";
                }
                ik1.o(outputStream, str);
                ik1.n(outputStream, this.d);
                ik1.n(outputStream, this.e);
                ik1.n(outputStream, this.f);
                ik1.n(outputStream, this.g);
                List<pj1> list = this.h;
                if (list != null) {
                    ik1.m(outputStream, list.size());
                    for (pj1 pj1 : list) {
                        ik1.o(outputStream, pj1.f2812a);
                        ik1.o(outputStream, pj1.b);
                    }
                } else {
                    ik1.m(outputStream, 0);
                }
                outputStream.flush();
                return true;
            } catch (IOException e2) {
                ek1.a("%s", e2.toString());
                return false;
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(java.lang.String r16, defpackage.jj1.a r17) {
            /*
                r15 = this;
                r0 = r17
                java.lang.String r3 = r0.b
                long r4 = r0.c
                long r6 = r0.d
                long r8 = r0.e
                long r10 = r0.f
                java.util.List<pj1> r1 = r0.h
                if (r1 == 0) goto L_0x0012
                r12 = r1
                goto L_0x0047
            L_0x0012:
                java.util.Map<java.lang.String, java.lang.String> r1 = r0.g
                java.util.ArrayList r2 = new java.util.ArrayList
                int r12 = r1.size()
                r2.<init>(r12)
                java.util.Set r1 = r1.entrySet()
                java.util.Iterator r1 = r1.iterator()
            L_0x0025:
                boolean r12 = r1.hasNext()
                if (r12 == 0) goto L_0x0046
                java.lang.Object r12 = r1.next()
                java.util.Map$Entry r12 = (java.util.Map.Entry) r12
                pj1 r13 = new pj1
                java.lang.Object r14 = r12.getKey()
                java.lang.String r14 = (java.lang.String) r14
                java.lang.Object r12 = r12.getValue()
                java.lang.String r12 = (java.lang.String) r12
                r13.<init>(r14, r12)
                r2.add(r13)
                goto L_0x0025
            L_0x0046:
                r12 = r2
            L_0x0047:
                r1 = r15
                r2 = r16
                r1.<init>(r2, r3, r4, r6, r8, r10, r12)
                byte[] r0 = r0.f1933a
                int r0 = r0.length
                long r0 = (long) r0
                r2 = r15
                r2.f1528a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ik1.a.<init>(java.lang.String, jj1$a):void");
        }
    }
}
