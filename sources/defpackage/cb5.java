package defpackage;

import android.annotation.SuppressLint;
import defpackage.bb5;
import defpackage.pb5;
import defpackage.wa5;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"Assert", "UseValueOf"})
/* renamed from: cb5  reason: default package */
/* compiled from: Draft_10 */
public class cb5 extends bb5 {
    public ByteBuffer d;
    public final SecureRandom e = new SecureRandom();

    /* renamed from: cb5$a */
    /* compiled from: Draft_10 */
    public class a extends Throwable {
        public int f;

        public a(cb5 cb5, int i) {
            this.f = i;
        }
    }

    public static int p(vb5 vb5) {
        String f = vb5.f("Sec-WebSocket-Version");
        if (f.length() <= 0) {
            return -1;
        }
        try {
            return new Integer(f.trim()).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    @Override // defpackage.bb5
    public bb5.b a(rb5 rb5, xb5 xb5) throws jb5 {
        if (!rb5.e("Sec-WebSocket-Key") || !xb5.e("Sec-WebSocket-Accept")) {
            return bb5.b.NOT_MATCHED;
        }
        if (o(rb5.f("Sec-WebSocket-Key")).equals(xb5.f("Sec-WebSocket-Accept"))) {
            return bb5.b.MATCHED;
        }
        return bb5.b.NOT_MATCHED;
    }

    @Override // defpackage.bb5
    public bb5.b b(rb5 rb5) throws jb5 {
        int p = p(rb5);
        if (p == 7 || p == 8) {
            return c(rb5) ? bb5.b.MATCHED : bb5.b.NOT_MATCHED;
        }
        return bb5.b.NOT_MATCHED;
    }

    @Override // defpackage.bb5
    public bb5 e() {
        return new cb5();
    }

    @Override // defpackage.bb5
    public ByteBuffer f(pb5 pb5) {
        byte b;
        ByteBuffer f = pb5.f();
        int i = 0;
        boolean z = this.f406a == wa5.b.CLIENT;
        int i2 = f.remaining() <= 125 ? 1 : f.remaining() <= 65535 ? 2 : 8;
        ByteBuffer allocate = ByteBuffer.allocate(f.remaining() + (i2 > 1 ? i2 + 1 : i2) + 1 + (z ? 4 : 0));
        pb5.a c = pb5.c();
        if (c == pb5.a.CONTINUOUS) {
            b = 0;
        } else if (c == pb5.a.TEXT) {
            b = 1;
        } else if (c == pb5.a.BINARY) {
            b = 2;
        } else if (c == pb5.a.CLOSING) {
            b = 8;
        } else if (c == pb5.a.PING) {
            b = 9;
        } else if (c == pb5.a.PONG) {
            b = 10;
        } else {
            StringBuilder i0 = hj1.i0("Don't know how to handle ");
            i0.append(c.toString());
            throw new RuntimeException(i0.toString());
        }
        byte b2 = Byte.MIN_VALUE;
        allocate.put((byte) (((byte) (pb5.d() ? -128 : 0)) | b));
        long remaining = (long) f.remaining();
        byte[] bArr = new byte[i2];
        int i3 = (i2 * 8) - 8;
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) ((int) (remaining >>> (i3 - (i4 * 8))));
        }
        if (i2 == 1) {
            byte b3 = bArr[0];
            if (!z) {
                b2 = 0;
            }
            allocate.put((byte) (b3 | b2));
        } else if (i2 == 2) {
            if (!z) {
                b2 = 0;
            }
            allocate.put((byte) (b2 | 126));
            allocate.put(bArr);
        } else if (i2 == 8) {
            if (!z) {
                b2 = 0;
            }
            allocate.put((byte) (b2 | Byte.MAX_VALUE));
            allocate.put(bArr);
        } else {
            throw new RuntimeException("Size representation not supported/specified");
        }
        if (z) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.e.nextInt());
            allocate.put(allocate2.array());
            while (f.hasRemaining()) {
                allocate.put((byte) (f.get() ^ allocate2.get(i % 4)));
                i++;
            }
        } else {
            allocate.put(f);
        }
        allocate.flip();
        return allocate;
    }

    @Override // defpackage.bb5
    public bb5.a h() {
        return bb5.a.TWOWAY;
    }

    @Override // defpackage.bb5
    public tb5 i(tb5 tb5) {
        String str;
        tb5.b.put("Upgrade", "websocket");
        tb5.b.put("Connection", "Upgrade");
        tb5.b.put("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.e.nextBytes(bArr);
        try {
            str = yb5.b(bArr, 0, 16, 0);
        } catch (IOException unused) {
            str = null;
        }
        tb5.b.put("Sec-WebSocket-Key", str);
        return tb5;
    }

    @Override // defpackage.bb5
    public void k() {
        this.d = null;
    }

    @Override // defpackage.bb5
    public List<pb5> l(ByteBuffer byteBuffer) throws kb5, hb5 {
        LinkedList linkedList = new LinkedList();
        if (this.d != null) {
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.d.remaining();
                if (remaining2 > remaining) {
                    this.d.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.d.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(q((ByteBuffer) this.d.duplicate().position(0)));
                this.d = null;
            } catch (a e2) {
                this.d.limit();
                int i = e2.f;
                d(i);
                ByteBuffer allocate = ByteBuffer.allocate(i);
                this.d.rewind();
                allocate.put(this.d);
                this.d = allocate;
                return l(byteBuffer);
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(q(byteBuffer));
            } catch (a e3) {
                byteBuffer.reset();
                int i2 = e3.f;
                d(i2);
                ByteBuffer allocate2 = ByteBuffer.allocate(i2);
                this.d = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public final String o(String str) {
        String S = hj1.S(str.trim(), "258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(S.getBytes());
            try {
                return yb5.b(digest, 0, digest.length, 0);
            } catch (IOException unused) {
                return null;
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public pb5 q(ByteBuffer byteBuffer) throws a, hb5 {
        pb5.a aVar;
        qb5 qb5;
        int remaining = byteBuffer.remaining();
        int i = 2;
        if (remaining >= 2) {
            byte b = byteBuffer.get();
            boolean z = (b >> 8) != 0;
            byte b2 = (byte) ((b & Byte.MAX_VALUE) >> 4);
            if (b2 == 0) {
                byte b3 = byteBuffer.get();
                boolean z2 = (b3 & Byte.MIN_VALUE) != 0;
                int i2 = (byte) (b3 & Byte.MAX_VALUE);
                byte b4 = (byte) (b & 15);
                if (b4 == 0) {
                    aVar = pb5.a.CONTINUOUS;
                } else if (b4 == 1) {
                    aVar = pb5.a.TEXT;
                } else if (b4 != 2) {
                    switch (b4) {
                        case 8:
                            aVar = pb5.a.CLOSING;
                            break;
                        case 9:
                            aVar = pb5.a.PING;
                            break;
                        case 10:
                            aVar = pb5.a.PONG;
                            break;
                        default:
                            StringBuilder i0 = hj1.i0("unknow optcode ");
                            i0.append((int) ((short) b4));
                            throw new ib5(i0.toString());
                    }
                } else {
                    aVar = pb5.a.BINARY;
                }
                if (z || !(aVar == pb5.a.PING || aVar == pb5.a.PONG || aVar == pb5.a.CLOSING)) {
                    if (i2 < 0 || i2 > 125) {
                        if (aVar == pb5.a.PING || aVar == pb5.a.PONG || aVar == pb5.a.CLOSING) {
                            throw new ib5("more than 125 octets");
                        } else if (i2 != 126) {
                            i = 10;
                            if (remaining >= 10) {
                                byte[] bArr = new byte[8];
                                for (int i3 = 0; i3 < 8; i3++) {
                                    bArr[i3] = byteBuffer.get();
                                }
                                long longValue = new BigInteger(bArr).longValue();
                                if (longValue <= 2147483647L) {
                                    i2 = (int) longValue;
                                } else {
                                    throw new kb5("Payloadsize is to big...");
                                }
                            } else {
                                throw new a(this, 10);
                            }
                        } else if (remaining >= 4) {
                            byte[] bArr2 = new byte[3];
                            bArr2[1] = byteBuffer.get();
                            bArr2[2] = byteBuffer.get();
                            i2 = new BigInteger(bArr2).intValue();
                            i = 4;
                        } else {
                            throw new a(this, 4);
                        }
                    }
                    int i4 = i + (z2 ? 4 : 0) + i2;
                    if (remaining >= i4) {
                        d(i2);
                        ByteBuffer allocate = ByteBuffer.allocate(i2);
                        if (z2) {
                            byte[] bArr3 = new byte[4];
                            byteBuffer.get(bArr3);
                            for (int i5 = 0; i5 < i2; i5++) {
                                allocate.put((byte) (byteBuffer.get() ^ bArr3[i5 % 4]));
                            }
                        } else {
                            allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                            byteBuffer.position(allocate.limit() + byteBuffer.position());
                        }
                        if (aVar == pb5.a.CLOSING) {
                            qb5 = new nb5();
                        } else {
                            qb5 = new qb5();
                            qb5.f2925a = z;
                            qb5.b = aVar;
                        }
                        allocate.flip();
                        qb5.g(allocate);
                        return qb5;
                    }
                    throw new a(this, i4);
                }
                throw new ib5("control frames may no be fragmented");
            }
            throw new ib5(hj1.I("bad rsv ", b2));
        }
        throw new a(this, 2);
    }
}
