package defpackage;

/* renamed from: g85  reason: default package */
/* compiled from: DetectionResultColumn */
public class g85 {

    /* renamed from: a  reason: collision with root package name */
    public final c85 f1226a;
    public final d85[] b;

    public g85(c85 c85) {
        this.f1226a = new c85(c85);
        this.b = new d85[((c85.i - c85.h) + 1)];
    }

    public final d85 a(int i) {
        d85 d85;
        d85 d852;
        d85 d853 = this.b[i - this.f1226a.h];
        if (d853 != null) {
            return d853;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int i3 = i - this.f1226a.h;
            int i4 = i3 - i2;
            if (i4 >= 0 && (d852 = this.b[i4]) != null) {
                return d852;
            }
            int i5 = i3 + i2;
            d85[] d85Arr = this.b;
            if (i5 < d85Arr.length && (d85 = d85Arr[i5]) != null) {
                return d85;
            }
        }
        return null;
    }

    public final int b(int i) {
        return i - this.f1226a.h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0058, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r11 = this;
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            d85[] r1 = r11.b     // Catch:{ all -> 0x0050 }
            int r2 = r1.length     // Catch:{ all -> 0x0050 }
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x000b:
            if (r4 >= r2) goto L_0x0048
            r6 = r1[r4]     // Catch:{ all -> 0x0050 }
            r7 = 1
            if (r6 != 0) goto L_0x0023
            java.lang.String r6 = "%3d:    |   %n"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0050 }
            int r8 = r5 + 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0050 }
            r7[r3] = r5     // Catch:{ all -> 0x0050 }
            r0.format(r6, r7)     // Catch:{ all -> 0x0050 }
            r5 = r8
            goto L_0x0045
        L_0x0023:
            java.lang.String r8 = "%3d: %3d|%3d%n"
            r9 = 3
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x0050 }
            int r10 = r5 + 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0050 }
            r9[r3] = r5     // Catch:{ all -> 0x0050 }
            int r5 = r6.e     // Catch:{ all -> 0x0050 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0050 }
            r9[r7] = r5     // Catch:{ all -> 0x0050 }
            r5 = 2
            int r6 = r6.d     // Catch:{ all -> 0x0050 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0050 }
            r9[r5] = r6     // Catch:{ all -> 0x0050 }
            r0.format(r8, r9)     // Catch:{ all -> 0x0050 }
            r5 = r10
        L_0x0045:
            int r4 = r4 + 1
            goto L_0x000b
        L_0x0048:
            java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x0050 }
            r0.close()
            return r1
        L_0x0050:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x005b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g85.toString():java.lang.String");
    }
}
