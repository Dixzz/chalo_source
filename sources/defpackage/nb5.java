package defpackage;

import defpackage.pb5;
import java.nio.ByteBuffer;

/* renamed from: nb5  reason: default package */
/* compiled from: CloseFrameBuilder */
public class nb5 extends qb5 implements mb5 {
    public static final ByteBuffer h = ByteBuffer.allocate(0);
    public int f;
    public String g;

    public nb5() {
        super(pb5.a.CLOSING);
        this.f2925a = true;
    }

    @Override // defpackage.mb5
    public String a() {
        return this.g;
    }

    @Override // defpackage.mb5
    public int e() {
        return this.f;
    }

    @Override // defpackage.pb5, defpackage.qb5
    public ByteBuffer f() {
        if (this.f == 1005) {
            return h;
        }
        return this.c;
    }

    @Override // defpackage.ob5, defpackage.qb5
    public void g(ByteBuffer byteBuffer) throws hb5 {
        this.c = byteBuffer;
        this.f = 1005;
        byteBuffer.mark();
        if (byteBuffer.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(byteBuffer.getShort());
            allocate.position(0);
            int i = allocate.getInt();
            this.f = i;
            if (i == 1006 || i == 1015 || i == 1005 || i > 4999 || i < 1000 || i == 1004) {
                StringBuilder i0 = hj1.i0("closecode must not be sent over the wire: ");
                i0.append(this.f);
                throw new ib5(i0.toString());
            }
        }
        byteBuffer.reset();
        if (this.f == 1005) {
            this.g = zb5.a(this.c);
            return;
        }
        ByteBuffer byteBuffer2 = this.c;
        int position = byteBuffer2.position();
        try {
            byteBuffer2.position(byteBuffer2.position() + 2);
            this.g = zb5.a(byteBuffer2);
            byteBuffer2.position(position);
        } catch (IllegalArgumentException e) {
            throw new ib5(e);
        } catch (Throwable th) {
            byteBuffer2.position(position);
            throw th;
        }
    }

    public final void h(int i, String str) throws hb5 {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        if (i == 1015) {
            i = 1005;
        } else {
            str2 = str;
        }
        if (i != 1005) {
            byte[] b = zb5.b(str2);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(b.length + 2);
            allocate2.put(allocate);
            allocate2.put(b);
            allocate2.rewind();
            g(allocate2);
        } else if (str2.length() > 0) {
            throw new hb5(1002, "A close frame must have a closecode if it has a reason");
        }
    }

    @Override // defpackage.qb5
    public String toString() {
        return super.toString() + "code: " + this.f;
    }

    public nb5(int i) throws hb5 {
        super(pb5.a.CLOSING);
        this.f2925a = true;
        h(i, "");
    }

    public nb5(int i, String str) throws hb5 {
        super(pb5.a.CLOSING);
        this.f2925a = true;
        h(i, str);
    }
}
