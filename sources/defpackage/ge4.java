package defpackage;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: ge4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ge4 implements Runnable {
    public final URL f;
    public final yb4 g;
    public final String h;
    public final /* synthetic */ ee4 i;

    /* JADX WARN: Incorrect args count in method signature: (Ljava/lang/String;Ljava/net/URL;[BLjava/util/Map<Ljava/lang/String;Ljava/lang/String;>;Lyb4;)V */
    public ge4(ee4 ee4, String str, URL url, yb4 yb4) {
        this.i = ee4;
        gj1.j(str);
        Objects.requireNonNull(url, "null reference");
        this.f = url;
        this.g = yb4;
        this.h = str;
    }

    public final void a(int i2, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.i.f().u(new fe4(this, i2, exc, bArr, map));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            ee4 r0 = r5.i
            r0.a()
            r0 = 0
            r1 = 0
            ee4 r2 = r5.i     // Catch:{ IOException -> 0x0038, all -> 0x002c }
            java.net.URL r3 = r5.f     // Catch:{ IOException -> 0x0038, all -> 0x002c }
            java.net.HttpURLConnection r2 = r2.q(r3)     // Catch:{ IOException -> 0x0038, all -> 0x002c }
            int r1 = r2.getResponseCode()     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            java.util.Map r3 = r2.getHeaderFields()     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            byte[] r4 = defpackage.ee4.s(r2)     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
            r2.disconnect()
            r5.a(r1, r0, r4, r3)
            return
        L_0x0022:
            r4 = move-exception
            goto L_0x002f
        L_0x0024:
            r4 = move-exception
            goto L_0x003b
        L_0x0026:
            r4 = move-exception
            r3 = r0
            goto L_0x002f
        L_0x0029:
            r4 = move-exception
            r3 = r0
            goto L_0x003b
        L_0x002c:
            r4 = move-exception
            r2 = r0
            r3 = r2
        L_0x002f:
            if (r2 == 0) goto L_0x0034
            r2.disconnect()
        L_0x0034:
            r5.a(r1, r0, r0, r3)
            throw r4
        L_0x0038:
            r4 = move-exception
            r2 = r0
            r3 = r2
        L_0x003b:
            if (r2 == 0) goto L_0x0040
            r2.disconnect()
        L_0x0040:
            r5.a(r1, r4, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ge4.run():void");
    }
}
