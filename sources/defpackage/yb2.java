package defpackage;

import java.util.Arrays;

/* renamed from: yb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class yb2 extends xb2 {
    public final byte[] h;

    public yb2(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.h = bArr;
    }

    @Override // defpackage.xb2
    public final byte[] F() {
        return this.h;
    }
}
