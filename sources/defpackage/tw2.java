package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.AEADBadTagException;

/* renamed from: tw2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class tw2 implements vn2 {

    /* renamed from: a  reason: collision with root package name */
    public final rw2 f3414a;
    public final rw2 b;

    public tw2(byte[] bArr) throws InvalidKeyException {
        this.f3414a = c(bArr, 1);
        this.b = c(bArr, 0);
    }

    @Override // defpackage.vn2
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }

    @Override // defpackage.vn2
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.remaining() >= this.f3414a.c() + 16) {
            int position = wrap.position();
            byte[] bArr3 = new byte[16];
            wrap.position(wrap.limit() - 16);
            wrap.get(bArr3);
            wrap.position(position);
            wrap.limit(wrap.limit() - 16);
            byte[] bArr4 = new byte[this.f3414a.c()];
            wrap.get(bArr4);
            try {
                byte[] bArr5 = new byte[32];
                this.b.e(bArr4, 0).get(bArr5);
                int length = bArr2.length;
                int i = length & 15;
                int i2 = i == 0 ? length : (length + 16) - i;
                int remaining = wrap.remaining();
                int i3 = remaining % 16;
                int i4 = (i3 == 0 ? remaining : (remaining + 16) - i3) + i2;
                ByteBuffer order = ByteBuffer.allocate(i4 + 16).order(ByteOrder.LITTLE_ENDIAN);
                order.put(bArr2);
                order.position(i2);
                order.put(wrap);
                order.position(i4);
                order.putLong((long) length);
                order.putLong((long) remaining);
                if (gj1.h1(gj1.j1(bArr5, order.array()), bArr3)) {
                    wrap.position(position);
                    return this.f3414a.d(wrap);
                }
                throw new GeneralSecurityException("invalid MAC");
            } catch (GeneralSecurityException e) {
                throw new AEADBadTagException(e.toString());
            }
        } else {
            throw new GeneralSecurityException("ciphertext too short");
        }
    }

    public abstract rw2 c(byte[] bArr, int i) throws InvalidKeyException;
}
