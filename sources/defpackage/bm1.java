package defpackage;

import java.io.IOException;

/* renamed from: bm1  reason: default package */
/* compiled from: HttpException */
public final class bm1 extends IOException {
    public bm1(int i) {
        super(hj1.I("Http request failed with status code: ", i), null);
    }

    public bm1(String str) {
        super(str, null);
    }

    public bm1(String str, int i) {
        super(str, null);
    }
}
