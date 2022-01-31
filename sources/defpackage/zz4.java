package defpackage;

import defpackage.a05;
import java.util.NoSuchElementException;

/* renamed from: zz4  reason: default package */
/* compiled from: ByteString */
public class zz4 extends a05.a {
    public int f = 0;
    public final int g;
    public final /* synthetic */ a05 h;

    public zz4(a05 a05) {
        this.h = a05;
        this.g = a05.size();
    }

    public byte a() {
        int i = this.f;
        if (i < this.g) {
            this.f = i + 1;
            return this.h.s(i);
        }
        throw new NoSuchElementException();
    }

    @Override // j$.util.Iterator
    public boolean hasNext() {
        return this.f < this.g;
    }
}
