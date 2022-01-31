package defpackage;

import java.io.InputStream;

/* renamed from: op1  reason: default package */
/* compiled from: StreamEncoder */
public class op1 implements am1<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final xn1 f2720a;

    public op1(xn1 xn1) {
        this.f2720a = xn1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.io.File, fm1] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030 A[SYNTHETIC, Splitter:B:17:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003b  */
    @Override // defpackage.am1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.io.InputStream r5, java.io.File r6, defpackage.fm1 r7) {
        /*
            r4 = this;
            java.io.InputStream r5 = (java.io.InputStream) r5
            java.lang.Class<byte[]> r7 = byte[].class
            xn1 r0 = r4.f2720a
            r1 = 65536(0x10000, float:9.18355E-41)
            java.lang.Object r0 = r0.d(r1, r7)
            byte[] r0 = (byte[]) r0
            r1 = 0
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0039, all -> 0x002d }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0039, all -> 0x002d }
        L_0x0015:
            int r6 = r5.read(r0)     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            r2 = -1
            if (r6 == r2) goto L_0x0020
            r3.write(r0, r1, r6)     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            goto L_0x0015
        L_0x0020:
            r3.close()     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            r1 = 1
            r3.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x003e
        L_0x0028:
            r5 = move-exception
            r2 = r3
            goto L_0x002e
        L_0x002b:
            r2 = r3
            goto L_0x0039
        L_0x002d:
            r5 = move-exception
        L_0x002e:
            if (r2 == 0) goto L_0x0033
            r2.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            xn1 r6 = r4.f2720a
            r6.c(r0, r7)
            throw r5
        L_0x0039:
            if (r2 == 0) goto L_0x003e
            r2.close()
        L_0x003e:
            xn1 r5 = r4.f2720a
            r5.c(r0, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.op1.a(java.lang.Object, java.io.File, fm1):boolean");
    }
}
