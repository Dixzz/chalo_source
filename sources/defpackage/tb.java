package defpackage;

import defpackage.ub;
import java.util.NoSuchElementException;

/* renamed from: tb  reason: default package */
/* compiled from: ByteString */
public class tb extends ub.a {
    public int f = 0;
    public final int g;
    public final /* synthetic */ ub h;

    public tb(ub ubVar) {
        this.h = ubVar;
        this.g = ubVar.size();
    }

    public byte a() {
        int i = this.f;
        if (i < this.g) {
            this.f = i + 1;
            return this.h.k(i);
        }
        throw new NoSuchElementException();
    }

    @Override // j$.util.Iterator
    public boolean hasNext() {
        return this.f < this.g;
    }
}
