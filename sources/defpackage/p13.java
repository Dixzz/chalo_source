package defpackage;

import com.rabbitmq.client.StringRpcServer;
import java.nio.charset.Charset;

/* renamed from: p13  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class p13 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f2758a = Charset.forName(StringRpcServer.STRING_ENCODING);

    static {
        Charset.forName("US-ASCII");
        Charset.forName("ISO-8859-1");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("UTF-16");
    }
}
