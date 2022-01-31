package defpackage;

/* renamed from: bo1  reason: default package */
/* compiled from: ByteArrayAdapter */
public final class bo1 implements wn1<byte[]> {
    @Override // defpackage.wn1
    public String a() {
        return "ByteArrayPool";
    }

    @Override // defpackage.wn1
    public int b() {
        return 1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.wn1
    public int c(byte[] bArr) {
        return bArr.length;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.wn1
    public byte[] newArray(int i) {
        return new byte[i];
    }
}
