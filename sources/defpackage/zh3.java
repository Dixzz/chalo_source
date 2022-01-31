package defpackage;

import com.rabbitmq.client.StringRpcServer;
import defpackage.uh3;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: zh3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zh3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f4175a = Charset.forName(StringRpcServer.STRING_ENCODING);
    public static final byte[] b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        b = bArr;
        ByteBuffer.wrap(bArr);
        int length = bArr.length;
        int i = length + 0;
        if (length < 0) {
            throw new fi3("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if ((0 - 0) + length <= Integer.MAX_VALUE) {
            int i2 = i + 0 + 0;
        } else {
            try {
                throw new fi3("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            } catch (fi3 e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public static Object a(Object obj, Object obj2) {
        gj3 gj3 = (gj3) obj2;
        sg3 sg3 = (sg3) ((gj3) obj).s();
        Objects.requireNonNull(sg3);
        uh3.b bVar = (uh3.b) sg3;
        if (bVar.f.getClass().isInstance(gj3)) {
            bVar.b((uh3) ((qg3) gj3));
            return bVar.e();
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
