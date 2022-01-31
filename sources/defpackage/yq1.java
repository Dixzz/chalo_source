package defpackage;

import defpackage.sl1;

/* renamed from: yq1  reason: default package */
/* compiled from: GifBitmapProvider */
public final class yq1 implements sl1.a {

    /* renamed from: a  reason: collision with root package name */
    public final zn1 f4080a;
    public final xn1 b;

    public yq1(zn1 zn1, xn1 xn1) {
        this.f4080a = zn1;
        this.b = xn1;
    }

    public byte[] a(int i) {
        xn1 xn1 = this.b;
        if (xn1 == null) {
            return new byte[i];
        }
        return (byte[]) xn1.d(i, byte[].class);
    }

    public void b(byte[] bArr) {
        xn1 xn1 = this.b;
        if (xn1 != null) {
            xn1.c(bArr, byte[].class);
        }
    }
}
