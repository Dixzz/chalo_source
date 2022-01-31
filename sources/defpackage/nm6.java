package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.vm6;

/* renamed from: nm6  reason: default package */
/* compiled from: WebSocketProtocol.kt */
public final class nm6 {
    public static final void a(vm6.a aVar, byte[] bArr) {
        long j;
        n86.f(aVar, "cursor");
        n86.f(bArr, AnalyticsConstants.KEY);
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = aVar.j;
            int i2 = aVar.k;
            int i3 = aVar.l;
            boolean z = true;
            if (bArr2 != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
            long j2 = aVar.i;
            vm6 vm6 = aVar.f;
            if (vm6 != null) {
                if (j2 == vm6.g) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalStateException("no more bytes".toString());
                } else if (j2 == -1) {
                    j = 0;
                } else {
                    j = j2 + ((long) (aVar.l - aVar.k));
                }
            } else {
                n86.k();
                throw null;
            }
        } while (aVar.c(j) != -1);
    }
}
