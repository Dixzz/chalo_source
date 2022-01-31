package defpackage;

import java.io.IOException;

/* renamed from: el6  reason: default package */
/* compiled from: StreamResetException.kt */
public final class el6 extends IOException {
    public final lk6 f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public el6(lk6 lk6) {
        super("stream was reset: " + lk6);
        n86.f(lk6, "errorCode");
        this.f = lk6;
    }
}
