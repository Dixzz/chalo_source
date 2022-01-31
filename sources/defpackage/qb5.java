package defpackage;

import defpackage.pb5;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: qb5  reason: default package */
/* compiled from: FramedataImpl1 */
public class qb5 implements ob5 {
    public static byte[] e = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public boolean f2925a;
    public pb5.a b;
    public ByteBuffer c;
    public boolean d;

    public qb5() {
    }

    @Override // defpackage.pb5
    public boolean b() {
        return this.d;
    }

    @Override // defpackage.pb5
    public pb5.a c() {
        return this.b;
    }

    @Override // defpackage.pb5
    public boolean d() {
        return this.f2925a;
    }

    @Override // defpackage.pb5
    public ByteBuffer f() {
        return this.c;
    }

    @Override // defpackage.ob5
    public void g(ByteBuffer byteBuffer) throws hb5 {
        this.c = byteBuffer;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Framedata{ optcode:");
        i0.append(this.b);
        i0.append(", fin:");
        i0.append(this.f2925a);
        i0.append(", payloadlength:[pos:");
        i0.append(this.c.position());
        i0.append(", len:");
        i0.append(this.c.remaining());
        i0.append("], payload:");
        i0.append(Arrays.toString(zb5.b(new String(this.c.array()))));
        i0.append("}");
        return i0.toString();
    }

    public qb5(pb5.a aVar) {
        this.b = aVar;
        this.c = ByteBuffer.wrap(e);
    }

    public qb5(pb5 pb5) {
        this.f2925a = pb5.d();
        this.b = pb5.c();
        this.c = pb5.f();
        this.d = pb5.b();
    }
}
