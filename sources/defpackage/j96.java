package defpackage;

import java.util.NoSuchElementException;

/* renamed from: j96  reason: default package */
/* compiled from: ProgressionIterators.kt */
public final class j96 extends e66 {
    public final int f;
    public boolean g;
    public int h;
    public final int i;

    public j96(int i2, int i3, int i4) {
        this.i = i4;
        this.f = i3;
        boolean z = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.g = z;
        this.h = !z ? i3 : i2;
    }

    @Override // defpackage.e66
    public int a() {
        int i2 = this.h;
        if (i2 != this.f) {
            this.h = this.i + i2;
        } else if (this.g) {
            this.g = false;
        } else {
            throw new NoSuchElementException();
        }
        return i2;
    }

    @Override // j$.util.Iterator
    public boolean hasNext() {
        return this.g;
    }
}
