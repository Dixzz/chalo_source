package defpackage;

import java.util.NoSuchElementException;

/* renamed from: z83  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class z83 extends a93 {
    public int f = 0;
    public final int g;
    public final /* synthetic */ g93 h;

    public z83(g93 g93) {
        this.h = g93;
        this.g = g93.e();
    }

    @Override // defpackage.a93
    public final byte a() {
        int i = this.f;
        if (i < this.g) {
            this.f = i + 1;
            return this.h.d(i);
        }
        throw new NoSuchElementException();
    }

    @Override // j$.util.Iterator
    public final boolean hasNext() {
        return this.f < this.g;
    }
}
