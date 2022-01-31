package defpackage;

/* renamed from: x65  reason: default package */
/* compiled from: FinderPattern */
public final class x65 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3893a;
    public final int[] b;
    public final g35[] c;

    public x65(int i, int[] iArr, int i2, int i3, int i4) {
        this.f3893a = i;
        this.b = iArr;
        float f = (float) i4;
        this.c = new g35[]{new g35((float) i2, f), new g35((float) i3, f)};
    }

    public boolean equals(Object obj) {
        if ((obj instanceof x65) && this.f3893a == ((x65) obj).f3893a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f3893a;
    }
}
