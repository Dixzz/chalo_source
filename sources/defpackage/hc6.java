package defpackage;

import defpackage.kb6;
import java.io.Closeable;
import java.util.concurrent.Executor;

/* renamed from: hc6  reason: default package */
/* compiled from: Executors.kt */
public abstract class hc6 extends kb6 implements Closeable {
    static {
        kb6.a aVar = kb6.f;
        gc6 gc6 = gc6.f;
        n86.e(aVar, "baseKey");
        n86.e(gc6, "safeCast");
    }

    public abstract Executor A();
}
