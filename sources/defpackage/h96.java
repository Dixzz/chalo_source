package defpackage;

import j$.util.concurrent.ThreadLocalRandom;
import java.util.Random;

/* renamed from: h96  reason: default package */
/* compiled from: PlatformThreadLocalRandom.kt */
public final class h96 extends e96 {
    @Override // defpackage.e96
    public Random b() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        n86.d(current, "ThreadLocalRandom.current()");
        return current;
    }
}
