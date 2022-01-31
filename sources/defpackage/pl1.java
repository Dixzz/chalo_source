package defpackage;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: pl1  reason: default package */
/* compiled from: DiskLruCache */
public final class pl1 implements Closeable {
    public final File f;
    public final File g;
    public final File h;
    public final File i;
    public final int j;
    public long k;
    public final int l;
    public long m = 0;
    public Writer n;
    public final LinkedHashMap<String, d> o = new LinkedHashMap<>(0, 0.75f, true);
    public int p;
    public long q = 0;
    public final ThreadPoolExecutor r = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    public final Callable<Void> s = new a();

    /* renamed from: pl1$a */
    /* compiled from: DiskLruCache */
    public class a implements Callable<Void> {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (pl1.this) {
                pl1 pl1 = pl1.this;
                if (pl1.n == null) {
                    return null;
                }
                pl1.o();
                if (pl1.this.h()) {
                    pl1.this.m();
                    pl1.this.p = 0;
                }
                return null;
            }
        }
    }

    /* renamed from: pl1$b */
    /* compiled from: DiskLruCache */
    public static final class b implements ThreadFactory {
        public b(a aVar) {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* renamed from: pl1$c */
    /* compiled from: DiskLruCache */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        public final d f2820a;
        public final boolean[] b;
        public boolean c;

        public c(d dVar, a aVar) {
            boolean[] zArr;
            this.f2820a = dVar;
            if (dVar.e) {
                zArr = null;
            } else {
                zArr = new boolean[pl1.this.l];
            }
            this.b = zArr;
        }

        public void a() throws IOException {
            pl1.a(pl1.this, this, false);
        }

        public File b(int i) throws IOException {
            File file;
            synchronized (pl1.this) {
                d dVar = this.f2820a;
                if (dVar.f == this) {
                    if (!dVar.e) {
                        this.b[i] = true;
                    }
                    file = dVar.d[i];
                    if (!pl1.this.f.exists()) {
                        pl1.this.f.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return file;
        }
    }

    /* renamed from: pl1$d */
    /* compiled from: DiskLruCache */
    public final class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f2821a;
        public final long[] b;
        public File[] c;
        public File[] d;
        public boolean e;
        public c f;
        public long g;

        public d(String str, a aVar) {
            this.f2821a = str;
            int i = pl1.this.l;
            this.b = new long[i];
            this.c = new File[i];
            this.d = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < pl1.this.l; i2++) {
                sb.append(i2);
                this.c[i2] = new File(pl1.this.f, sb.toString());
                sb.append(".tmp");
                this.d[i2] = new File(pl1.this.f, sb.toString());
                sb.setLength(length);
            }
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            long[] jArr = this.b;
            for (long j : jArr) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final IOException b(String[] strArr) throws IOException {
            StringBuilder i0 = hj1.i0("unexpected journal line: ");
            i0.append(Arrays.toString(strArr));
            throw new IOException(i0.toString());
        }
    }

    /* renamed from: pl1$e */
    /* compiled from: DiskLruCache */
    public final class e {

        /* renamed from: a  reason: collision with root package name */
        public final File[] f2822a;

        public e(pl1 pl1, String str, long j, File[] fileArr, long[] jArr, a aVar) {
            this.f2822a = fileArr;
        }
    }

    public pl1(File file, int i2, int i3, long j2) {
        this.f = file;
        this.j = i2;
        this.g = new File(file, "journal");
        this.h = new File(file, "journal.tmp");
        this.i = new File(file, "journal.bkp");
        this.l = i3;
        this.k = j2;
    }

    public static void a(pl1 pl1, c cVar, boolean z) throws IOException {
        synchronized (pl1) {
            d dVar = cVar.f2820a;
            if (dVar.f == cVar) {
                if (z && !dVar.e) {
                    for (int i2 = 0; i2 < pl1.l; i2++) {
                        if (!cVar.b[i2]) {
                            cVar.a();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!dVar.d[i2].exists()) {
                            cVar.a();
                            return;
                        }
                    }
                }
                for (int i3 = 0; i3 < pl1.l; i3++) {
                    File file = dVar.d[i3];
                    if (!z) {
                        e(file);
                    } else if (file.exists()) {
                        File file2 = dVar.c[i3];
                        file.renameTo(file2);
                        long j2 = dVar.b[i3];
                        long length = file2.length();
                        dVar.b[i3] = length;
                        pl1.m = (pl1.m - j2) + length;
                    }
                }
                pl1.p++;
                dVar.f = null;
                if (dVar.e || z) {
                    dVar.e = true;
                    pl1.n.append((CharSequence) cj6.B);
                    pl1.n.append(' ');
                    pl1.n.append((CharSequence) dVar.f2821a);
                    pl1.n.append((CharSequence) dVar.a());
                    pl1.n.append('\n');
                    if (z) {
                        long j3 = pl1.q;
                        pl1.q = 1 + j3;
                        dVar.g = j3;
                    }
                } else {
                    pl1.o.remove(dVar.f2821a);
                    pl1.n.append((CharSequence) cj6.D);
                    pl1.n.append(' ');
                    pl1.n.append((CharSequence) dVar.f2821a);
                    pl1.n.append('\n');
                }
                pl1.n.flush();
                if (pl1.m > pl1.k || pl1.h()) {
                    pl1.r.submit(pl1.s);
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    public static void e(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static pl1 i(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    n(file2, file3, false);
                }
            }
            pl1 pl1 = new pl1(file, i2, i3, j2);
            if (pl1.g.exists()) {
                try {
                    pl1.k();
                    pl1.j();
                    return pl1;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    pl1.close();
                    rl1.a(pl1.f);
                }
            }
            file.mkdirs();
            pl1 pl12 = new pl1(file, i2, i3, j2);
            pl12.m();
            return pl12;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    public static void n(File file, File file2, boolean z) throws IOException {
        if (z) {
            e(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final void c() {
        if (this.n == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.n != null) {
            Iterator it = new ArrayList(this.o.values()).iterator();
            while (it.hasNext()) {
                c cVar = ((d) it.next()).f;
                if (cVar != null) {
                    cVar.a();
                }
            }
            o();
            this.n.close();
            this.n = null;
        }
    }

    public c f(String str) throws IOException {
        synchronized (this) {
            c();
            d dVar = this.o.get(str);
            if (dVar == null) {
                dVar = new d(str, null);
                this.o.put(str, dVar);
            } else if (dVar.f != null) {
                return null;
            }
            c cVar = new c(dVar, null);
            dVar.f = cVar;
            this.n.append((CharSequence) cj6.C);
            this.n.append(' ');
            this.n.append((CharSequence) str);
            this.n.append('\n');
            this.n.flush();
            return cVar;
        }
    }

    public synchronized e g(String str) throws IOException {
        c();
        d dVar = this.o.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.e) {
            return null;
        }
        for (File file : dVar.c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.p++;
        this.n.append((CharSequence) cj6.E);
        this.n.append(' ');
        this.n.append((CharSequence) str);
        this.n.append('\n');
        if (h()) {
            this.r.submit(this.s);
        }
        return new e(this, str, dVar.g, dVar.c, dVar.b, null);
    }

    public final boolean h() {
        int i2 = this.p;
        return i2 >= 2000 && i2 >= this.o.size();
    }

    public final void j() throws IOException {
        e(this.h);
        Iterator<d> it = this.o.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f == null) {
                while (i2 < this.l) {
                    this.m += next.b[i2];
                    i2++;
                }
            } else {
                next.f = null;
                while (i2 < this.l) {
                    e(next.c[i2]);
                    e(next.d[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    public final void k() throws IOException {
        ql1 ql1 = new ql1(new FileInputStream(this.g), rl1.f3093a);
        try {
            String c2 = ql1.c();
            String c3 = ql1.c();
            String c4 = ql1.c();
            String c5 = ql1.c();
            String c6 = ql1.c();
            if (!"libcore.io.DiskLruCache".equals(c2) || !"1".equals(c3) || !Integer.toString(this.j).equals(c4) || !Integer.toString(this.l).equals(c5) || !"".equals(c6)) {
                throw new IOException("unexpected journal header: [" + c2 + ", " + c3 + ", " + c5 + ", " + c6 + "]");
            }
            boolean z = false;
            int i2 = 0;
            while (true) {
                try {
                    l(ql1.c());
                    i2++;
                } catch (EOFException unused) {
                    this.p = i2 - this.o.size();
                    if (ql1.j == -1) {
                        z = true;
                    }
                    if (z) {
                        m();
                    } else {
                        this.n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.g, true), rl1.f3093a));
                    }
                    try {
                        return;
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } finally {
            try {
                ql1.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused3) {
            }
        }
    }

    public final void l(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith(cj6.D)) {
                    this.o.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            d dVar = this.o.get(str2);
            if (dVar == null) {
                dVar = new d(str2, null);
                this.o.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(cj6.B)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.e = true;
                dVar.f = null;
                if (split.length == pl1.this.l) {
                    for (int i3 = 0; i3 < split.length; i3++) {
                        try {
                            dVar.b[i3] = Long.parseLong(split[i3]);
                        } catch (NumberFormatException unused) {
                            dVar.b(split);
                            throw null;
                        }
                    }
                    return;
                }
                dVar.b(split);
                throw null;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(cj6.C)) {
                dVar.f = new c(dVar, null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(cj6.E)) {
                throw new IOException(hj1.S("unexpected journal line: ", str));
            }
        } else {
            throw new IOException(hj1.S("unexpected journal line: ", str));
        }
    }

    public final synchronized void m() throws IOException {
        Writer writer = this.n;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.h), rl1.f3093a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.j));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.l));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.o.values()) {
                if (dVar.f != null) {
                    bufferedWriter.write("DIRTY " + dVar.f2821a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.f2821a + dVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.g.exists()) {
                n(this.g, this.i, true);
            }
            n(this.h, this.g, false);
            this.i.delete();
            this.n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.g, true), rl1.f3093a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    public final void o() throws IOException {
        while (this.m > this.k) {
            String key = this.o.entrySet().iterator().next().getKey();
            synchronized (this) {
                c();
                d dVar = this.o.get(key);
                if (dVar != null) {
                    if (dVar.f == null) {
                        for (int i2 = 0; i2 < this.l; i2++) {
                            File file = dVar.c[i2];
                            if (file.exists()) {
                                if (!file.delete()) {
                                    throw new IOException("failed to delete " + file);
                                }
                            }
                            long j2 = this.m;
                            long[] jArr = dVar.b;
                            this.m = j2 - jArr[i2];
                            jArr[i2] = 0;
                        }
                        this.p++;
                        this.n.append((CharSequence) cj6.D);
                        this.n.append(' ');
                        this.n.append((CharSequence) key);
                        this.n.append('\n');
                        this.o.remove(key);
                        if (h()) {
                            this.r.submit(this.s);
                        }
                    }
                }
            }
        }
    }
}
