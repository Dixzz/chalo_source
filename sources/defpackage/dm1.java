package defpackage;

import com.rabbitmq.client.StringRpcServer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* renamed from: dm1  reason: default package */
/* compiled from: Key */
public interface dm1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f856a = Charset.forName(StringRpcServer.STRING_ENCODING);

    void a(MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
