package com.freshchat.consumer.sdk.j.a;

import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.j.x;
import com.rabbitmq.client.StringRpcServer;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b implements Closeable {
    private static final Charset UTF_8 = Charset.forName(StringRpcServer.STRING_ENCODING);
    private final File ji;
    private final File jj;
    private final File jk;
    private final int jl;
    private final long jm;
    private final int jn;
    private long jo = 0;
    private Writer jp;
    private final LinkedHashMap<String, C0013b> jq = new LinkedHashMap<>(0, 0.75f, true);
    private int jr;
    private long js = 0;
    private final ExecutorService jt = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> ju = new c(this);

    public final class a {
        private final C0013b jw;
        private boolean jx;

        /* renamed from: com.freshchat.consumer.sdk.j.a.b$a$a  reason: collision with other inner class name */
        public class C0012a extends FilterOutputStream {
            private C0012a(OutputStream outputStream) {
                super(outputStream);
            }

            public /* synthetic */ C0012a(a aVar, OutputStream outputStream, c cVar) {
                this(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    a.this.jx = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    a.this.jx = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    a.this.jx = true;
                }
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    a.this.jx = true;
                }
            }
        }

        private a(C0013b bVar) {
            this.jw = bVar;
        }

        public /* synthetic */ a(b bVar, C0013b bVar2, c cVar) {
            this(bVar2);
        }

        public void abort() throws IOException {
            b.this.a((b) this, (a) false);
        }

        public void commit() throws IOException {
            if (this.jx) {
                b.this.a((b) this, (a) false);
                b.this.remove(this.jw.jz);
                return;
            }
            b.this.a((b) this, (a) true);
        }

        public OutputStream w(int i) throws IOException {
            C0012a aVar;
            synchronized (b.this) {
                if (this.jw.jC == this) {
                    aVar = new C0012a(this, new FileOutputStream(this.jw.y(i)), null);
                } else {
                    throw new IllegalStateException();
                }
            }
            return aVar;
        }
    }

    /* renamed from: com.freshchat.consumer.sdk.j.a.b$b  reason: collision with other inner class name */
    public final class C0013b {
        private final long[] jA;
        private boolean jB;
        private a jC;
        private long jD;
        private final String jz;

        private C0013b(String str) {
            this.jz = str;
            this.jA = new long[b.this.jn];
        }

        public /* synthetic */ C0013b(b bVar, String str, c cVar) {
            this(str);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void b(String[] strArr) throws IOException {
            if (strArr.length == b.this.jn) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.jA[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw c(strArr);
                    }
                }
                return;
            }
            throw c(strArr);
        }

        private IOException c(String[] strArr) throws IOException {
            StringBuilder i0 = hj1.i0("unexpected journal line: ");
            i0.append(Arrays.toString(strArr));
            throw new IOException(i0.toString());
        }

        public String fj() throws IOException {
            StringBuilder sb = new StringBuilder();
            long[] jArr = this.jA;
            for (long j : jArr) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File x(int i) {
            File file = b.this.ji;
            return new File(file, this.jz + "." + i);
        }

        public File y(int i) {
            File file = b.this.ji;
            return new File(file, this.jz + "." + i + ".tmp");
        }
    }

    public final class c implements Closeable {
        private final long jD;
        private final InputStream[] jE;
        private final String jz;

        private c(String str, long j, InputStream[] inputStreamArr) {
            this.jz = str;
            this.jD = j;
            this.jE = inputStreamArr;
        }

        public /* synthetic */ c(b bVar, String str, long j, InputStream[] inputStreamArr, c cVar) {
            this(str, j, inputStreamArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.jE) {
                b.closeQuietly(inputStream);
            }
        }

        public InputStream z(int i) {
            return this.jE[i];
        }
    }

    private b(File file, int i, int i2, long j) {
        this.ji = file;
        this.jl = i;
        this.jj = new File(file, "journal");
        this.jk = new File(file, "journal.tmp");
        this.jn = i2;
        this.jm = j;
    }

    private synchronized a a(String str, long j) throws IOException {
        fh();
        aS(str);
        C0013b bVar = this.jq.get(str);
        if (j != -1 && (bVar == null || bVar.jD != j)) {
            return null;
        }
        if (bVar == null) {
            bVar = new C0013b(this, str, null);
            this.jq.put(str, bVar);
        } else if (bVar.jC != null) {
            return null;
        }
        a aVar = new a(this, bVar, null);
        bVar.jC = aVar;
        Writer writer = this.jp;
        writer.write("DIRTY " + str + '\n');
        this.jp.flush();
        return aVar;
    }

    public static b a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            b bVar = new b(file, i, i2, j);
            if (bVar.jj.exists()) {
                try {
                    bVar.cu();
                    bVar.et();
                    bVar.jp = new BufferedWriter(new FileWriter(bVar.jj, true), RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
                    return bVar;
                } catch (IOException unused) {
                    bVar.delete();
                }
            }
            file.mkdirs();
            b bVar2 = new b(file, i, i2, j);
            bVar2.ff();
            return bVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void a(a aVar, boolean z) throws IOException {
        C0013b bVar = aVar.jw;
        if (bVar.jC == aVar) {
            if (z && !bVar.jB) {
                for (int i = 0; i < this.jn; i++) {
                    if (!bVar.y(i).exists()) {
                        aVar.abort();
                        throw new IllegalStateException("edit didn't create file " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.jn; i2++) {
                File y = bVar.y(i2);
                if (!z) {
                    c(y);
                } else if (y.exists()) {
                    File x = bVar.x(i2);
                    y.renameTo(x);
                    long j = bVar.jA[i2];
                    long length = x.length();
                    bVar.jA[i2] = length;
                    this.jo = (this.jo - j) + length;
                }
            }
            this.jr++;
            bVar.jC = null;
            if (bVar.jB || z) {
                bVar.jB = true;
                this.jp.write("CLEAN " + bVar.jz + bVar.fj() + '\n');
                if (z) {
                    long j2 = this.js;
                    this.js = 1 + j2;
                    bVar.jD = j2;
                }
            } else {
                this.jq.remove(bVar.jz);
                this.jp.write("REMOVE " + bVar.jz + '\n');
            }
            if (this.jo > this.jm || fg()) {
                this.jt.submit(this.ju);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private void aI(String str) throws IOException {
        String[] split = str.split(" ");
        if (split.length >= 2) {
            String str2 = split[1];
            if (!split[0].equals(cj6.D) || split.length != 2) {
                C0013b bVar = this.jq.get(str2);
                if (bVar == null) {
                    bVar = new C0013b(this, str2, null);
                    this.jq.put(str2, bVar);
                }
                if (split[0].equals(cj6.B) && split.length == this.jn + 2) {
                    bVar.jB = true;
                    bVar.jC = null;
                    bVar.b((C0013b) ((String[]) copyOfRange(split, 2, split.length)));
                } else if (split[0].equals(cj6.C) && split.length == 2) {
                    bVar.jC = new a(this, bVar, null);
                } else if (!split[0].equals(cj6.E) || split.length != 2) {
                    throw new IOException(hj1.S("unexpected journal line: ", str));
                }
            } else {
                this.jq.remove(str2);
            }
        } else {
            throw new IOException(hj1.S("unexpected journal line: ", str));
        }
    }

    private void aS(String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException(hj1.T("keys must not contain spaces or newlines: \"", str, "\""));
        }
    }

    public static String c(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            } else if (read == 10) {
                int length = sb.length();
                if (length > 0) {
                    int i = length - 1;
                    if (sb.charAt(i) == '\r') {
                        sb.setLength(i);
                    }
                }
                return sb.toString();
            } else {
                sb.append((char) read);
            }
        }
    }

    private static void c(File file) throws IOException {
        x.f(file);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    private static <T> T[] copyOfRange(T[] tArr, int i, int i2) {
        int length = tArr.length;
        if (i > i2) {
            throw new IllegalArgumentException();
        } else if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
            System.arraycopy(tArr, i, tArr2, 0, min);
            return tArr2;
        }
    }

    private void cu() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.jj), RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
        try {
            String c2 = c(bufferedInputStream);
            String c3 = c(bufferedInputStream);
            String c4 = c(bufferedInputStream);
            String c5 = c(bufferedInputStream);
            String c6 = c(bufferedInputStream);
            if (!"libcore.io.DiskLruCache".equals(c2) || !"1".equals(c3) || !Integer.toString(this.jl).equals(c4) || !Integer.toString(this.jn).equals(c5) || !"".equals(c6)) {
                throw new IOException("unexpected journal header: [" + c2 + ", " + c3 + ", " + c5 + ", " + c6 + "]");
            }
            while (true) {
                try {
                    aI(c(bufferedInputStream));
                } catch (EOFException unused) {
                    return;
                }
            }
        } finally {
            closeQuietly(bufferedInputStream);
        }
    }

    public static void deleteContents(File file) throws IOException {
        x.e(file);
    }

    private void et() throws IOException {
        c(this.jk);
        Iterator<C0013b> it = this.jq.values().iterator();
        while (it.hasNext()) {
            C0013b next = it.next();
            int i = 0;
            if (next.jC == null) {
                while (i < this.jn) {
                    this.jo += next.jA[i];
                    i++;
                }
            } else {
                next.jC = null;
                while (i < this.jn) {
                    c(next.x(i));
                    c(next.y(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void ff() throws IOException {
        Writer writer = this.jp;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.jk), RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.jl));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.jn));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (C0013b bVar : this.jq.values()) {
            bufferedWriter.write(bVar.jC != null ? "DIRTY " + bVar.jz + '\n' : "CLEAN " + bVar.jz + bVar.fj() + '\n');
        }
        bufferedWriter.close();
        this.jk.renameTo(this.jj);
        this.jp = new BufferedWriter(new FileWriter(this.jj, true), RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
    }

    /* access modifiers changed from: private */
    public boolean fg() {
        int i = this.jr;
        return i >= 2000 && i >= this.jq.size();
    }

    private void fh() {
        if (this.jp == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    public void trimToSize() throws IOException {
        while (this.jo > this.jm) {
            remove(this.jq.entrySet().iterator().next().getKey());
        }
    }

    public synchronized c aP(String str) throws IOException {
        fh();
        aS(str);
        C0013b bVar = this.jq.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.jB) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.jn];
        for (int i = 0; i < this.jn; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(bVar.x(i));
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        this.jr++;
        this.jp.append((CharSequence) ("READ " + str + '\n'));
        if (fg()) {
            this.jt.submit(this.ju);
        }
        return new c(this, str, bVar.jD, inputStreamArr, null);
    }

    public a aQ(String str) throws IOException {
        return a(str, -1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.jp != null) {
            Iterator it = new ArrayList(this.jq.values()).iterator();
            while (it.hasNext()) {
                C0013b bVar = (C0013b) it.next();
                if (bVar.jC != null) {
                    bVar.jC.abort();
                }
            }
            trimToSize();
            this.jp.close();
            this.jp = null;
        }
    }

    public void delete() throws IOException {
        close();
        deleteContents(this.ji);
    }

    public synchronized void flush() throws IOException {
        fh();
        trimToSize();
        this.jp.flush();
    }

    public boolean isClosed() {
        return this.jp == null;
    }

    public synchronized boolean remove(String str) throws IOException {
        fh();
        aS(str);
        C0013b bVar = this.jq.get(str);
        if (bVar != null) {
            if (bVar.jC == null) {
                for (int i = 0; i < this.jn; i++) {
                    File x = bVar.x(i);
                    if (x.delete()) {
                        this.jo -= bVar.jA[i];
                        bVar.jA[i] = 0;
                    } else {
                        throw new IOException("failed to delete " + x);
                    }
                }
                this.jr++;
                this.jp.append((CharSequence) ("REMOVE " + str + '\n'));
                this.jq.remove(str);
                if (fg()) {
                    this.jt.submit(this.ju);
                }
                return true;
            }
        }
        return false;
    }
}
