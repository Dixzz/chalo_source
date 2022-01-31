package defpackage;

import defpackage.cm1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: fr1  reason: default package */
/* compiled from: StreamGifDecoder */
public class fr1 implements gm1<InputStream, zq1> {
    public static final em1<Boolean> d = em1.a("com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.DisableAnimation", Boolean.FALSE);

    /* renamed from: a  reason: collision with root package name */
    public final List<cm1> f1163a;
    public final gm1<ByteBuffer, zq1> b;
    public final xn1 c;

    public fr1(List<cm1> list, gm1<ByteBuffer, zq1> gm1, xn1 xn1) {
        this.f1163a = list;
        this.b = gm1;
        this.c = xn1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, fm1] */
    @Override // defpackage.gm1
    public boolean a(InputStream inputStream, fm1 fm1) throws IOException {
        return !((Boolean) fm1.c(d)).booleanValue() && gj1.M(this.f1163a, inputStream, this.c) == cm1.a.GIF;
    }

    /* Return type fixed from 'rn1' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.gm1
    public rn1<zq1> b(InputStream inputStream, int i, int i2, fm1 fm1) throws IOException {
        byte[] bArr;
        InputStream inputStream2 = inputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr2 = new byte[16384];
            while (true) {
                int read = inputStream2.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return this.b.b(ByteBuffer.wrap(bArr), i, i2, fm1);
    }
}
