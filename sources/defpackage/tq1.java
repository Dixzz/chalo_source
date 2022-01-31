package defpackage;

import java.util.Objects;

/* renamed from: tq1  reason: default package */
/* compiled from: BytesResource */
public class tq1 implements rn1<byte[]> {
    public final byte[] f;

    public tq1(byte[] bArr) {
        Objects.requireNonNull(bArr, "Argument must not be null");
        this.f = bArr;
    }

    @Override // defpackage.rn1
    public void a() {
    }

    @Override // defpackage.rn1
    public int b() {
        return this.f.length;
    }

    @Override // defpackage.rn1
    public Class<byte[]> c() {
        return byte[].class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.rn1
    public byte[] get() {
        return this.f;
    }
}
