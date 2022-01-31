package defpackage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.rabbitmq.client.StringRpcServer;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;

/* renamed from: ud3  reason: default package */
public final class ud3 extends yb3 {
    public static final byte[] j = "\n".getBytes();
    public final String h = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", zb3.f4152a, Build.VERSION.RELEASE, ie3.a(Locale.getDefault()), Build.MODEL, Build.ID);
    public final ee3 i;

    public ud3(ac3 ac3) {
        super(ac3);
        this.i = new ee3(ac3.c);
    }

    public static void m0(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, StringRpcServer.STRING_ENCODING));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, StringRpcServer.STRING_ENCODING));
    }

    @Override // defpackage.yb3
    public final void a0() {
        k("Network initialized. User agent", this.h);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f A[SYNTHETIC, Splitter:B:27:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0094 A[SYNTHETIC, Splitter:B:36:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int i0(java.net.URL r6, byte[] r7) {
        /*
        // Method dump skipped, instructions count: 162
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ud3.i0(java.net.URL, byte[]):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String j0(defpackage.nd3 r8, boolean r9) {
        /*
        // Method dump skipped, instructions count: 167
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ud3.j0(nd3, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x001f A[SYNTHETIC, Splitter:B:18:0x001f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o0(java.net.HttpURLConnection r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "Error closing http connection input stream"
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x001b }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0019 }
        L_0x000a:
            int r2 = r4.read(r1)     // Catch:{ all -> 0x0019 }
            if (r2 > 0) goto L_0x000a
            r4.close()     // Catch:{ IOException -> 0x0014 }
            return
        L_0x0014:
            r4 = move-exception
            r3.L(r0, r4)
            return
        L_0x0019:
            r1 = move-exception
            goto L_0x001d
        L_0x001b:
            r1 = move-exception
            r4 = 0
        L_0x001d:
            if (r4 == 0) goto L_0x0027
            r4.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r4 = move-exception
            r3.L(r0, r4)
        L_0x0027:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ud3.o0(java.net.HttpURLConnection):void");
    }

    public final HttpURLConnection q0(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(id3.v.f1906a.intValue());
            httpURLConnection.setReadTimeout(id3.w.f1906a.intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.h);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:161:0x038f, code lost:
        if (r0 != 200) goto L_0x0426;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0422, code lost:
        if (i0(r5, r4) == 200) goto L_0x0424;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0240 A[SYNTHETIC, Splitter:B:105:0x0240] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0418  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x041e  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0429  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0110 A[EDGE_INSN: B:196:0x0110->B:43:0x0110 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x043c A[EDGE_INSN: B:199:0x043c->B:195:0x043c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0105 A[LOOP:0: B:16:0x0087->B:42:0x0105, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0226 A[SYNTHETIC, Splitter:B:94:0x0226] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0231  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.Long> w0(java.util.List<defpackage.nd3> r18) {
        /*
        // Method dump skipped, instructions count: 1085
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ud3.w0(java.util.List):java.util.List");
    }

    public final boolean x0() {
        jz1.c();
        g0();
        NetworkInfo networkInfo = null;
        try {
            networkInfo = ((ConnectivityManager) this.f.f146a.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        M("No network connectivity");
        return false;
    }
}
