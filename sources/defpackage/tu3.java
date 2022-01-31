package defpackage;

import com.rabbitmq.client.StringRpcServer;
import defpackage.ru3;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: tu3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class tu3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f3407a = Charset.forName(StringRpcServer.STRING_ENCODING);
    public static final byte[] b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        b = bArr;
        ByteBuffer.wrap(bArr);
        int length = bArr.length;
        int i = length + 0;
        if (length < 0) {
            throw cv3.b();
        } else if (length + 0 <= Integer.MAX_VALUE) {
            int i2 = i + 0 + 0;
        } else {
            try {
                throw cv3.a();
            } catch (cv3 e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int b(boolean z) {
        return z ? 1231 : 1237;
    }

    public static Object c(Object obj, Object obj2) {
        cw3 cw3 = (cw3) obj2;
        kt3 kt3 = (kt3) ((cw3) obj).g();
        Objects.requireNonNull(kt3);
        ru3.b bVar = (ru3.b) kt3;
        if (bVar.f.getClass().isInstance(cw3)) {
            bVar.f((ru3) ((it3) cw3));
            return bVar.j();
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
