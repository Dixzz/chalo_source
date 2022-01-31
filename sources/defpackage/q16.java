package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.rabbitmq.client.StringRpcServer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;

/* renamed from: q16  reason: default package */
/* compiled from: HttpRequest */
public class q16 {

    /* renamed from: a  reason: collision with root package name */
    public HttpURLConnection f2885a = null;
    public final URL b;
    public final String c;
    public e d;
    public boolean e;

    /* renamed from: q16$a */
    /* compiled from: HttpRequest */
    public class a extends b<q16> {
        public final /* synthetic */ InputStream h;
        public final /* synthetic */ OutputStream i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Closeable closeable, boolean z, InputStream inputStream, OutputStream outputStream) {
            super(closeable, z);
            this.h = inputStream;
            this.i = outputStream;
        }

        @Override // defpackage.q16.d
        public Object b() throws c, IOException {
            Objects.requireNonNull(q16.this);
            byte[] bArr = new byte[RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST];
            while (true) {
                int read = this.h.read(bArr);
                if (read == -1) {
                    return q16.this;
                }
                this.i.write(bArr, 0, read);
            }
        }
    }

    /* renamed from: q16$b */
    /* compiled from: HttpRequest */
    public static abstract class b<V> extends d<V> {
        public final Closeable f;
        public final boolean g;

        public b(Closeable closeable, boolean z) {
            this.f = closeable;
            this.g = z;
        }

        @Override // defpackage.q16.d
        public void a() throws IOException {
            Closeable closeable = this.f;
            if (closeable instanceof Flushable) {
                ((Flushable) closeable).flush();
            }
            if (this.g) {
                try {
                    this.f.close();
                } catch (IOException unused) {
                }
            } else {
                this.f.close();
            }
        }
    }

    /* renamed from: q16$c */
    /* compiled from: HttpRequest */
    public static class c extends RuntimeException {
        public c(IOException iOException) {
            super(iOException);
        }

        public Throwable getCause() {
            return (IOException) super.getCause();
        }
    }

    /* renamed from: q16$d */
    /* compiled from: HttpRequest */
    public static abstract class d<V> implements Callable<V> {
        public abstract void a() throws IOException;

        public abstract V b() throws c, IOException;

        @Override // java.util.concurrent.Callable
        public V call() throws c {
            boolean z;
            Throwable th;
            try {
                V b = b();
                try {
                    a();
                    return b;
                } catch (IOException e) {
                    throw new c(e);
                }
            } catch (c e2) {
                throw e2;
            } catch (IOException e3) {
                throw new c(e3);
            } catch (Throwable th2) {
                th = th2;
                z = true;
                a();
                throw th;
            }
        }
    }

    /* renamed from: q16$e */
    /* compiled from: HttpRequest */
    public static class e extends BufferedOutputStream {
        public final CharsetEncoder f;

        public e(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f = Charset.forName((str == null || str.length() <= 0) ? StringRpcServer.STRING_ENCODING : str).newEncoder();
        }

        public e a(String str) throws IOException {
            ByteBuffer encode = this.f.encode(CharBuffer.wrap(str));
            write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    public q16(CharSequence charSequence, String str) throws c {
        try {
            this.b = new URL(charSequence.toString());
            this.c = str;
        } catch (MalformedURLException e2) {
            throw new c(e2);
        }
    }

    public static String a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder sb = new StringBuilder(charSequence2);
        if (charSequence2.indexOf(58) + 2 == charSequence2.lastIndexOf(47)) {
            sb.append('/');
        }
        int indexOf = charSequence2.indexOf(63);
        int length = sb.length() - 1;
        if (indexOf == -1) {
            sb.append('?');
        } else if (indexOf < length && charSequence2.charAt(length) != '&') {
            sb.append('&');
        }
        Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        Map.Entry<?, ?> next = it.next();
        sb.append(next.getKey().toString());
        sb.append('=');
        Object value = next.getValue();
        if (value != null) {
            sb.append(value);
        }
        while (it.hasNext()) {
            sb.append('&');
            Map.Entry<?, ?> next2 = it.next();
            sb.append(next2.getKey().toString());
            sb.append('=');
            Object value2 = next2.getValue();
            if (value2 != null) {
                sb.append(value2);
            }
        }
        return sb.toString();
    }

    public static String g(CharSequence charSequence) throws c {
        int i;
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String aSCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = aSCIIString.indexOf(63);
                if (indexOf <= 0 || (i = indexOf + 1) >= aSCIIString.length()) {
                    return aSCIIString;
                }
                return aSCIIString.substring(0, i) + aSCIIString.substring(i).replace("+", "%2B");
            } catch (URISyntaxException e2) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e2);
                throw new c(iOException);
            }
        } catch (IOException e3) {
            throw new c(e3);
        }
    }

    public String b() throws c {
        ByteArrayOutputStream byteArrayOutputStream;
        String i = i(k("Content-Type"), "charset");
        try {
            d();
            int headerFieldInt = h().getHeaderFieldInt("Content-Length", -1);
            if (headerFieldInt > 0) {
                byteArrayOutputStream = new ByteArrayOutputStream(headerFieldInt);
            } else {
                byteArrayOutputStream = new ByteArrayOutputStream();
            }
            try {
                f(c(), byteArrayOutputStream);
                if (i == null || i.length() <= 0) {
                    i = StringRpcServer.STRING_ENCODING;
                }
                return byteArrayOutputStream.toString(i);
            } catch (IOException e2) {
                throw new c(e2);
            }
        } catch (IOException e3) {
            throw new c(e3);
        }
    }

    public BufferedInputStream c() throws c {
        InputStream inputStream;
        if (e() < 400) {
            try {
                inputStream = h().getInputStream();
            } catch (IOException e2) {
                throw new c(e2);
            }
        } else {
            inputStream = h().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = h().getInputStream();
                } catch (IOException e3) {
                    throw new c(e3);
                }
            }
        }
        return new BufferedInputStream(inputStream, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
    }

    public q16 d() throws IOException {
        e eVar = this.d;
        if (eVar == null) {
            return this;
        }
        if (this.e) {
            eVar.a("\r\n--00content0boundary00--\r\n");
        }
        try {
            this.d.close();
        } catch (IOException unused) {
        }
        this.d = null;
        return this;
    }

    public int e() throws c {
        try {
            d();
            return h().getResponseCode();
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public q16 f(InputStream inputStream, OutputStream outputStream) throws IOException {
        return (q16) new a(inputStream, true, inputStream, outputStream).call();
    }

    public HttpURLConnection h() {
        if (this.f2885a == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(this.b.openConnection()));
                httpURLConnection.setRequestMethod(this.c);
                this.f2885a = httpURLConnection;
            } catch (IOException e2) {
                throw new c(e2);
            }
        }
        return this.f2885a;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f A[EDGE_INSN: B:30:0x006f->B:29:0x006f ?: BREAK  , SYNTHETIC] */
    public java.lang.String i(java.lang.String r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 112
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q16.i(java.lang.String, java.lang.String):java.lang.String");
    }

    public q16 j(String str, String str2) {
        h().setRequestProperty(str, str2);
        return this;
    }

    public String k(String str) throws c {
        try {
            d();
            return h().getHeaderField(str);
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public q16 l() throws IOException {
        if (this.d != null) {
            return this;
        }
        h().setDoOutput(true);
        this.d = new e(h().getOutputStream(), i(h().getRequestProperty("Content-Type"), "charset"), RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r4 = th;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0032 A[SYNTHETIC, Splitter:B:23:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x000b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.q16 m(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.io.File r7) throws defpackage.q16.c {
        /*
            r3 = this;
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0028 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0028 }
            r2.<init>(r7)     // Catch:{ IOException -> 0x0028 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0028 }
            r3.o()     // Catch:{ IOException -> 0x001c, all -> 0x001a }
            r3.p(r4, r5, r6)     // Catch:{ IOException -> 0x001c, all -> 0x001a }
            q16$e r4 = r3.d     // Catch:{ IOException -> 0x001c, all -> 0x001a }
            r3.f(r1, r4)     // Catch:{ IOException -> 0x001c, all -> 0x001a }
            r1.close()     // Catch:{ IOException -> 0x0019 }
        L_0x0019:
            return r3
        L_0x001a:
            r4 = move-exception
            goto L_0x0030
        L_0x001c:
            r4 = move-exception
            q16$c r5 = new q16$c     // Catch:{ IOException -> 0x0023, all -> 0x001a }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0023, all -> 0x001a }
            throw r5     // Catch:{ IOException -> 0x0023, all -> 0x001a }
        L_0x0023:
            r4 = move-exception
            r0 = r1
            goto L_0x0029
        L_0x0026:
            r4 = move-exception
            goto L_0x002f
        L_0x0028:
            r4 = move-exception
        L_0x0029:
            q16$c r5 = new q16$c     // Catch:{ all -> 0x0026 }
            r5.<init>(r4)     // Catch:{ all -> 0x0026 }
            throw r5     // Catch:{ all -> 0x0026 }
        L_0x002f:
            r1 = r0
        L_0x0030:
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0035:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q16.m(java.lang.String, java.lang.String, java.lang.String, java.io.File):q16");
    }

    public q16 n(CharSequence charSequence) throws c {
        try {
            l();
            this.d.a(charSequence.toString());
            return this;
        } catch (IOException e2) {
            throw new c(e2);
        }
    }

    public q16 o() throws IOException {
        if (!this.e) {
            this.e = true;
            h().setRequestProperty("Content-Type", "multipart/form-data; boundary=00content0boundary00");
            l();
            this.d.a("--00content0boundary00\r\n");
        } else {
            this.d.a("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    public q16 p(String str, String str2, String str3) throws IOException {
        StringBuilder k0 = hj1.k0("form-data; name=\"", str);
        if (str2 != null) {
            k0.append("\"; filename=\"");
            k0.append(str2);
        }
        k0.append('\"');
        String sb = k0.toString();
        n("Content-Disposition");
        n(": ");
        n(sb);
        n("\r\n");
        if (str3 != null) {
            n("Content-Type");
            n(": ");
            n(str3);
            n("\r\n");
        }
        n("\r\n");
        return this;
    }

    public String toString() {
        return h().getRequestMethod() + ' ' + h().getURL();
    }
}
