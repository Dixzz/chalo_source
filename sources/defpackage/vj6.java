package defpackage;

import java.io.IOException;

/* renamed from: vj6  reason: default package */
/* compiled from: RouteException.kt */
public final class vj6 extends RuntimeException {
    public IOException f;
    public final IOException g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public vj6(IOException iOException) {
        super(iOException);
        n86.f(iOException, "firstConnectException");
        this.g = iOException;
        this.f = iOException;
    }
}
