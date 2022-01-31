package defpackage;

import defpackage.kt1;
import java.nio.ByteBuffer;

/* renamed from: ir1  reason: default package */
/* compiled from: GifDrawableBytesTranscoder */
public class ir1 implements jr1<zq1, byte[]> {
    @Override // defpackage.jr1
    public rn1<byte[]> a(rn1<zq1> rn1) {
        byte[] bArr;
        ByteBuffer asReadOnlyBuffer = rn1.get().f.b.f881a.e().asReadOnlyBuffer();
        int i = kt1.f2117a;
        kt1.b bVar = (asReadOnlyBuffer.isReadOnly() || !asReadOnlyBuffer.hasArray()) ? null : new kt1.b(asReadOnlyBuffer.array(), asReadOnlyBuffer.arrayOffset(), asReadOnlyBuffer.limit());
        if (bVar != null && bVar.f2118a == 0 && bVar.b == bVar.c.length) {
            bArr = asReadOnlyBuffer.array();
        } else {
            ByteBuffer asReadOnlyBuffer2 = asReadOnlyBuffer.asReadOnlyBuffer();
            byte[] bArr2 = new byte[asReadOnlyBuffer2.limit()];
            asReadOnlyBuffer2.position(0);
            asReadOnlyBuffer2.get(bArr2);
            bArr = bArr2;
        }
        return new tq1(bArr);
    }
}
