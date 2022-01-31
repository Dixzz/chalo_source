package defpackage;

import java.io.IOException;

/* renamed from: ga  reason: default package */
/* compiled from: Serializer.kt */
public final class ga extends IOException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ga(String str, Throwable th, int i) {
        super(str, null);
        int i2 = i & 2;
        n86.e(str, "message");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ga(String str, Throwable th) {
        super(str, th);
        n86.e(str, "message");
    }
}
