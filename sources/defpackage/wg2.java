package defpackage;

import com.rabbitmq.client.StringRpcServer;
import defpackage.ug2;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: wg2  reason: default package */
public final class wg2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f3775a = Charset.forName(StringRpcServer.STRING_ENCODING);
    public static final byte[] b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        b = bArr;
        ByteBuffer.wrap(bArr);
        int length = bArr.length;
        int i = length + 0;
        if (length < 0) {
            throw new ah2("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if ((0 - 0) + length <= Integer.MAX_VALUE) {
            int i2 = i + 0 + 0;
        } else {
            try {
                throw ah2.a();
            } catch (ah2 e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public static Object a(Object obj, Object obj2) {
        zh2 zh2 = (zh2) obj2;
        mf2 mf2 = (mf2) ((zh2) obj).b();
        Objects.requireNonNull(mf2);
        ug2.a aVar = (ug2.a) mf2;
        if (aVar.f.getClass().isInstance(zh2)) {
            aVar.g((ug2) ((lf2) zh2));
            return aVar.i();
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public static int b(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int c(long j) {
        return (int) (j ^ (j >>> 32));
    }
}
