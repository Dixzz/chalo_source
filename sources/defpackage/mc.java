package defpackage;

import com.rabbitmq.client.StringRpcServer;
import defpackage.kc;
import defpackage.nb;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* renamed from: mc  reason: default package */
/* compiled from: Internal */
public final class mc {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f2352a = Charset.forName(StringRpcServer.STRING_ENCODING);
    public static final byte[] b;

    /* renamed from: mc$a */
    /* compiled from: Internal */
    public interface a {
        int getNumber();
    }

    /* renamed from: mc$b */
    /* compiled from: Internal */
    public interface b {
        boolean isInRange(int i);
    }

    /* renamed from: mc$c */
    /* compiled from: Internal */
    public interface c<E> extends List<E>, RandomAccess, j$.util.List {
        void c();

        c<E> f(int i);

        boolean t();
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        b = bArr;
        ByteBuffer.wrap(bArr);
        vb.f(bArr, 0, 0, false);
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int b(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static Object c(Object obj, Object obj2) {
        dd ddVar = (dd) obj2;
        nb.a aVar = (nb.a) ((dd) obj).toBuilder();
        Objects.requireNonNull(aVar);
        kc.a aVar2 = (kc.a) aVar;
        if (aVar2.f.getClass().isInstance(ddVar)) {
            aVar2.d();
            aVar2.f(aVar2.g, (kc) ((nb) ddVar));
            return aVar2.c();
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
