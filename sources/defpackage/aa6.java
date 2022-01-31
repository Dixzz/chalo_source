package defpackage;

import com.rabbitmq.client.StringRpcServer;
import java.nio.charset.Charset;

/* renamed from: aa6  reason: default package */
/* compiled from: Charsets.kt */
public final class aa6 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f144a;
    public static Charset b;
    public static Charset c;
    public static final aa6 d = null;

    static {
        Charset forName = Charset.forName(StringRpcServer.STRING_ENCODING);
        n86.d(forName, "Charset.forName(\"UTF-8\")");
        f144a = forName;
        n86.d(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        n86.d(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        n86.d(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        n86.d(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        n86.d(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }
}
