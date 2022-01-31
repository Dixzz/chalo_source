package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.jj1;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;

/* renamed from: gk1  reason: default package */
/* compiled from: BasicNetwork */
public class gk1 implements qj1 {
    public static final boolean c = ek1.f981a;

    /* renamed from: a  reason: collision with root package name */
    public final fk1 f1272a;
    public final hk1 b;

    public gk1(fk1 fk1) {
        hk1 hk1 = new hk1(4096);
        this.f1272a = fk1;
        this.b = hk1;
    }

    public static void a(String str, wj1<?> wj1, dk1 dk1) throws dk1 {
        ak1 ak1 = wj1.q;
        int r = wj1.r();
        try {
            ak1.a(dk1);
            wj1.a(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(r)));
        } catch (dk1 e) {
            wj1.a(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(r)));
            throw e;
        }
    }

    public static List<pj1> b(List<pj1> list, jj1.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (pj1 pj1 : list) {
                treeSet.add(pj1.f2812a);
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<pj1> list2 = aVar.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (pj1 pj12 : aVar.h) {
                    if (!treeSet.contains(pj12.f2812a)) {
                        arrayList.add(pj12);
                    }
                }
            }
        } else if (!aVar.g.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new pj1(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    public final Map<String, String> c(jj1.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = aVar.b;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j = aVar.d;
        if (j > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
            hashMap.put("If-Modified-Since", simpleDateFormat.format(new Date(j)));
        }
        return hashMap;
    }

    public final byte[] d(InputStream inputStream, int i) throws IOException, bk1 {
        nk1 nk1 = new nk1(this.b, i);
        try {
            byte[] a2 = this.b.a(1024);
            while (true) {
                int read = inputStream.read(a2);
                if (read == -1) {
                    break;
                }
                nk1.write(a2, 0, read);
            }
            byte[] byteArray = nk1.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused) {
                ek1.b("Error occurred when closing InputStream", new Object[0]);
            }
            this.b.b(a2);
            nk1.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                ek1.b("Error occurred when closing InputStream", new Object[0]);
            }
            this.b.b(null);
            nk1.close();
            throw th;
        }
    }

    public final void e(long j, wj1<?> wj1, byte[] bArr, int i) {
        if (c || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = wj1;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : AnalyticsConstants.NULL;
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(wj1.q.c());
            ek1.a("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        r14 = null;
        r2 = r12;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a5, code lost:
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ac, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ad, code lost:
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00af, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b0, code lost:
        r18 = r1;
        r14 = null;
        r2 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b6, code lost:
        r18 = r1;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bb, code lost:
        r0 = r2.f1945a;
        defpackage.ek1.a("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r29.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d0, code lost:
        if (r14 != null) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d2, code lost:
        r1 = new defpackage.tj1(r0, r14, false, android.os.SystemClock.elapsedRealtime() - r9, r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e2, code lost:
        if (r0 == 401) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00eb, code lost:
        if (r0 < 400) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f7, code lost:
        throw new defpackage.mj1(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fa, code lost:
        if (r0 < 500) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0105, code lost:
        throw new defpackage.bk1(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x010b, code lost:
        throw new defpackage.bk1(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x010c, code lost:
        a("auth", r29, new defpackage.ij1(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0118, code lost:
        a(com.razorpay.AnalyticsConstants.NETWORK, r29, new defpackage.sj1());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0129, code lost:
        throw new defpackage.uj1(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x012a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x012b, code lost:
        r2 = defpackage.hj1.i0("Bad URL ");
        r2.append(r29.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x013f, code lost:
        throw new java.lang.RuntimeException(r2.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0140, code lost:
        a("socket", r29, new defpackage.ck1());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x012a A[ExcHandler: MalformedURLException (r0v1 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0124 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.tj1 f(defpackage.wj1<?> r29) throws defpackage.dk1 {
        /*
        // Method dump skipped, instructions count: 332
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gk1.f(wj1):tj1");
    }
}
