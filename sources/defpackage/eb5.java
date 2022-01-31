package defpackage;

import defpackage.bb5;
import defpackage.pb5;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

/* renamed from: eb5  reason: default package */
/* compiled from: Draft_75 */
public class eb5 extends bb5 {
    public boolean d = false;
    public List<pb5> e = new LinkedList();
    public ByteBuffer f;
    public final SecureRandom g = new SecureRandom();

    @Override // defpackage.bb5
    public bb5.b a(rb5 rb5, xb5 xb5) {
        return (!rb5.f("WebSocket-Origin").equals(xb5.f("Origin")) || !c(xb5)) ? bb5.b.NOT_MATCHED : bb5.b.MATCHED;
    }

    @Override // defpackage.bb5
    public bb5.b b(rb5 rb5) {
        if (!rb5.e("Origin") || !c(rb5)) {
            return bb5.b.NOT_MATCHED;
        }
        return bb5.b.MATCHED;
    }

    @Override // defpackage.bb5
    public bb5 e() {
        return new eb5();
    }

    @Override // defpackage.bb5
    public ByteBuffer f(pb5 pb5) {
        if (pb5.c() == pb5.a.TEXT) {
            ByteBuffer f2 = pb5.f();
            ByteBuffer allocate = ByteBuffer.allocate(f2.remaining() + 2);
            allocate.put((byte) 0);
            f2.mark();
            allocate.put(f2);
            f2.reset();
            allocate.put((byte) -1);
            allocate.flip();
            return allocate;
        }
        throw new RuntimeException("only text frames supported");
    }

    @Override // defpackage.bb5
    public bb5.a h() {
        return bb5.a.NONE;
    }

    @Override // defpackage.bb5
    public tb5 i(tb5 tb5) throws jb5 {
        tb5.b.put("Upgrade", "WebSocket");
        tb5.b.put("Connection", "Upgrade");
        if (!tb5.b.containsKey("Origin")) {
            StringBuilder i0 = hj1.i0("random");
            i0.append(this.g.nextInt());
            tb5.b.put("Origin", i0.toString());
        }
        return tb5;
    }

    @Override // defpackage.bb5
    public void k() {
        this.d = false;
        this.f = null;
    }

    @Override // defpackage.bb5
    public List<pb5> l(ByteBuffer byteBuffer) throws hb5 {
        List<pb5> o = o(byteBuffer);
        if (o != null) {
            return o;
        }
        throw new hb5(1002);
    }

    public List<pb5> o(ByteBuffer byteBuffer) throws hb5 {
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            if (b == 0) {
                if (!this.d) {
                    this.d = true;
                } else {
                    throw new ib5("unexpected START_OF_FRAME");
                }
            } else if (b == -1) {
                if (this.d) {
                    ByteBuffer byteBuffer2 = this.f;
                    if (byteBuffer2 != null) {
                        byteBuffer2.flip();
                        qb5 qb5 = new qb5();
                        qb5.c = this.f;
                        qb5.f2925a = true;
                        qb5.b = pb5.a.TEXT;
                        this.e.add(qb5);
                        this.f = null;
                        byteBuffer.mark();
                    }
                    this.d = false;
                } else {
                    throw new ib5("unexpected END_OF_FRAME");
                }
            } else if (!this.d) {
                return null;
            } else {
                ByteBuffer byteBuffer3 = this.f;
                if (byteBuffer3 == null) {
                    this.f = ByteBuffer.allocate(64);
                } else if (!byteBuffer3.hasRemaining()) {
                    ByteBuffer byteBuffer4 = this.f;
                    byteBuffer4.flip();
                    int capacity = byteBuffer4.capacity() * 2;
                    d(capacity);
                    ByteBuffer allocate = ByteBuffer.allocate(capacity);
                    allocate.put(byteBuffer4);
                    this.f = allocate;
                }
                this.f.put(b);
            }
        }
        List<pb5> list = this.e;
        this.e = new LinkedList();
        return list;
    }
}
