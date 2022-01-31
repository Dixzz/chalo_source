package defpackage;

import java.nio.ByteBuffer;

/* renamed from: pb5  reason: default package */
/* compiled from: Framedata */
public interface pb5 {

    /* renamed from: pb5$a */
    /* compiled from: Framedata */
    public enum a {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    boolean b();

    a c();

    boolean d();

    ByteBuffer f();
}
