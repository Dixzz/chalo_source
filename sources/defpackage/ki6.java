package defpackage;

import java.io.File;

/* renamed from: ki6  reason: default package */
/* compiled from: RequestBody.kt */
public final class ki6 extends mi6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ File f2066a;
    public final /* synthetic */ fi6 b;

    public ki6(File file, fi6 fi6) {
        this.f2066a = file;
        this.b = fi6;
    }

    @Override // defpackage.mi6
    public long contentLength() {
        return this.f2066a.length();
    }

    @Override // defpackage.mi6
    public fi6 contentType() {
        return this.b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        defpackage.hd3.H(r0, r4);
     */
    @Override // defpackage.mi6
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeTo(defpackage.xm6 r4) {
        /*
            r3 = this;
            java.lang.String r0 = "sink"
            defpackage.n86.f(r4, r0)
            java.io.File r0 = r3.f2066a
            java.lang.String r1 = "$this$source"
            defpackage.n86.f(r0, r1)
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r2.<init>(r0)
            defpackage.n86.f(r2, r1)
            gn6 r0 = new gn6
            rn6 r1 = new rn6
            r1.<init>()
            r0.<init>(r2, r1)
            r4.t0(r0)     // Catch:{ all -> 0x0026 }
            r4 = 0
            defpackage.hd3.H(r0, r4)
            return
        L_0x0026:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0028 }
        L_0x0028:
            r1 = move-exception
            defpackage.hd3.H(r0, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ki6.writeTo(xm6):void");
    }
}
