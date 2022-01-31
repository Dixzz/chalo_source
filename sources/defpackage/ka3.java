package defpackage;

import com.rabbitmq.client.StringRpcServer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: ka3  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ka3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f2038a = Charset.forName(StringRpcServer.STRING_ENCODING);
    public static final byte[] b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        b = bArr;
        ByteBuffer.wrap(bArr);
    }

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int b(boolean z) {
        return z ? 1231 : 1237;
    }

    public static Object c(Object obj, Object obj2) {
        r83 l = ((bm2) obj).l();
        bm2 bm2 = (bm2) obj2;
        Objects.requireNonNull(l);
        ba3 ba3 = (ba3) l;
        if (ba3.f.getClass().isInstance(bm2)) {
            ba3.e((ea3) ((s83) bm2));
            return ba3.b();
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
