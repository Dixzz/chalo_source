package defpackage;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: za4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class za4 implements Runnable {
    public final ab4 f;
    public final int g;
    public final Throwable h;
    public final byte[] i;
    public final String j;
    public final Map<String, List<String>> k;

    public za4(String str, ab4 ab4, int i2, Throwable th, byte[] bArr, Map map, xa4 xa4) {
        Objects.requireNonNull(ab4, "null reference");
        this.f = ab4;
        this.g = i2;
        this.h = th;
        this.i = bArr;
        this.j = str;
        this.k = map;
    }

    public final void run() {
        this.f.a(this.j, this.g, this.h, this.i, this.k);
    }
}
