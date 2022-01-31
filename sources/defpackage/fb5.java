package defpackage;

import android.annotation.SuppressLint;
import com.google.firebase.appindexing.Indexable;
import com.rabbitmq.client.LongString;
import defpackage.bb5;
import defpackage.pb5;
import defpackage.wa5;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseValueOf"})
/* renamed from: fb5  reason: default package */
/* compiled from: Draft_76 */
public class fb5 extends eb5 {
    public static final byte[] i = {-1, 0};
    public final SecureRandom h = new SecureRandom();

    public static byte[] p(String str, String str2, byte[] bArr) throws jb5 {
        byte[] r = r(str);
        byte[] r2 = r(str2);
        try {
            return MessageDigest.getInstance("MD5").digest(new byte[]{r[0], r[1], r[2], r[3], r2[0], r2[1], r2[2], r2[3], bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]});
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String q() {
        SecureRandom secureRandom = new SecureRandom();
        long nextInt = (long) (secureRandom.nextInt(12) + 1);
        String l = Long.toString(((long) (secureRandom.nextInt(Math.abs(new Long(LongString.MAX_LENGTH / nextInt).intValue())) + 1)) * nextInt);
        int nextInt2 = secureRandom.nextInt(12) + 1;
        for (int i2 = 0; i2 < nextInt2; i2++) {
            int abs = Math.abs(secureRandom.nextInt(l.length()));
            char nextInt3 = (char) (secureRandom.nextInt(95) + 33);
            if (nextInt3 >= '0' && nextInt3 <= '9') {
                nextInt3 = (char) (nextInt3 - 15);
            }
            l = new StringBuilder(l).insert(abs, nextInt3).toString();
        }
        for (int i3 = 0; ((long) i3) < nextInt; i3++) {
            l = new StringBuilder(l).insert(Math.abs(secureRandom.nextInt(l.length() - 1) + 1), " ").toString();
        }
        return l;
    }

    public static byte[] r(String str) throws jb5 {
        try {
            long parseLong = Long.parseLong(str.replaceAll("[^0-9]", ""));
            long length = (long) (str.split(" ").length - 1);
            if (length != 0) {
                long longValue = new Long(parseLong / length).longValue();
                return new byte[]{(byte) ((int) (longValue >> 24)), (byte) ((int) ((longValue << 8) >> 24)), (byte) ((int) ((longValue << 16) >> 24)), (byte) ((int) ((longValue << 24) >> 24))};
            }
            throw new jb5("invalid Sec-WebSocket-Key (/key2/)");
        } catch (NumberFormatException unused) {
            throw new jb5("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
        }
    }

    @Override // defpackage.bb5, defpackage.eb5
    public bb5.b a(rb5 rb5, xb5 xb5) {
        try {
            if (xb5.f("Sec-WebSocket-Origin").equals(rb5.f("Origin"))) {
                if (c(xb5)) {
                    byte[] d = xb5.d();
                    if (d == null || d.length == 0) {
                        throw new gb5();
                    } else if (Arrays.equals(d, p(rb5.f("Sec-WebSocket-Key1"), rb5.f("Sec-WebSocket-Key2"), rb5.d()))) {
                        return bb5.b.MATCHED;
                    } else {
                        return bb5.b.NOT_MATCHED;
                    }
                }
            }
            return bb5.b.NOT_MATCHED;
        } catch (jb5 e) {
            throw new RuntimeException("bad handshakerequest", e);
        }
    }

    @Override // defpackage.bb5, defpackage.eb5
    public bb5.b b(rb5 rb5) {
        if (!rb5.f("Upgrade").equals("WebSocket") || !rb5.f("Connection").contains("Upgrade") || rb5.f("Sec-WebSocket-Key1").length() <= 0 || rb5.f("Sec-WebSocket-Key2").isEmpty() || !rb5.e("Origin")) {
            return bb5.b.NOT_MATCHED;
        }
        return bb5.b.MATCHED;
    }

    @Override // defpackage.bb5, defpackage.eb5
    public bb5 e() {
        return new fb5();
    }

    @Override // defpackage.bb5, defpackage.eb5
    public ByteBuffer f(pb5 pb5) {
        if (pb5.c() == pb5.a.CLOSING) {
            return ByteBuffer.wrap(i);
        }
        return super.f(pb5);
    }

    @Override // defpackage.bb5, defpackage.eb5
    public bb5.a h() {
        return bb5.a.ONEWAY;
    }

    @Override // defpackage.bb5, defpackage.eb5
    public tb5 i(tb5 tb5) {
        tb5.b.put("Upgrade", "WebSocket");
        tb5.b.put("Connection", "Upgrade");
        tb5.b.put("Sec-WebSocket-Key1", q());
        tb5.b.put("Sec-WebSocket-Key2", q());
        if (!tb5.b.containsKey("Origin")) {
            StringBuilder i0 = hj1.i0("random");
            i0.append(this.h.nextInt());
            tb5.b.put("Origin", i0.toString());
        }
        byte[] bArr = new byte[8];
        this.h.nextBytes(bArr);
        tb5.f3757a = bArr;
        return tb5;
    }

    @Override // defpackage.bb5, defpackage.eb5
    public List<pb5> l(ByteBuffer byteBuffer) throws hb5 {
        byteBuffer.mark();
        List<pb5> o = o(byteBuffer);
        if (o != null) {
            return o;
        }
        byteBuffer.reset();
        List<pb5> list = this.e;
        this.d = true;
        if (this.f == null) {
            this.f = ByteBuffer.allocate(2);
            if (byteBuffer.remaining() <= this.f.remaining()) {
                this.f.put(byteBuffer);
                if (this.f.hasRemaining()) {
                    this.e = new LinkedList();
                    return list;
                } else if (Arrays.equals(this.f.array(), i)) {
                    list.add(new nb5(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL));
                    return list;
                } else {
                    throw new ib5();
                }
            } else {
                throw new ib5();
            }
        } else {
            throw new ib5();
        }
    }

    @Override // defpackage.bb5
    public vb5 m(ByteBuffer byteBuffer) throws jb5 {
        sb5 n = bb5.n(byteBuffer, this.f406a);
        wb5 wb5 = (wb5) n;
        if ((wb5.b.containsKey("Sec-WebSocket-Key1") || this.f406a == wa5.b.CLIENT) && !wb5.b.containsKey("Sec-WebSocket-Version")) {
            byte[] bArr = new byte[(this.f406a == wa5.b.SERVER ? 8 : 16)];
            try {
                byteBuffer.get(bArr);
                wb5.f3757a = bArr;
            } catch (BufferUnderflowException unused) {
                throw new gb5(byteBuffer.capacity() + 16);
            }
        }
        return n;
    }
}
