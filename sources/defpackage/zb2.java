package defpackage;

import java.lang.ref.WeakReference;

/* renamed from: zb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class zb2 extends xb2 {
    public static final WeakReference<byte[]> i = new WeakReference<>(null);
    public WeakReference<byte[]> h = i;

    public zb2(byte[] bArr) {
        super(bArr);
    }

    public abstract byte[] C1();

    @Override // defpackage.xb2
    public final byte[] F() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.h.get();
            if (bArr == null) {
                bArr = C1();
                this.h = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
