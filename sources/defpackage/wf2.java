package defpackage;

import java.util.Arrays;

/* renamed from: wf2  reason: default package */
public final class wf2 implements xf2 {
    public wf2(vf2 vf2) {
    }

    @Override // defpackage.xf2
    public final byte[] a(byte[] bArr, int i, int i2) {
        return Arrays.copyOfRange(bArr, i, i2 + i);
    }
}
