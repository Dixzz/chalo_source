package defpackage;

import java.io.IOException;

/* renamed from: ih6  reason: default package */
/* compiled from: Call.kt */
public interface ih6 extends Cloneable {

    /* renamed from: ih6$a */
    /* compiled from: Call.kt */
    public interface a {
        ih6 a(ji6 ji6);
    }

    void L(jh6 jh6);

    void cancel();

    ni6 execute() throws IOException;

    boolean isCanceled();

    ji6 request();
}
