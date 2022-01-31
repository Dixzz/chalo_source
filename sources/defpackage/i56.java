package defpackage;

/* renamed from: i56  reason: default package */
/* compiled from: KotlinVersion.kt */
public final class i56 implements Comparable<i56> {
    public static final i56 j = new i56(1, 5, 30);
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    public i56(int i2, int i3, int i4) {
        this.g = i2;
        this.h = i3;
        this.i = i4;
        if (i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3 && i4 >= 0 && 255 >= i4) {
            this.f = (i2 << 16) + (i3 << 8) + i4;
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + '.' + i3 + '.' + i4).toString());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(i56 i56) {
        i56 i562 = i56;
        n86.e(i562, "other");
        return this.f - i562.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i56)) {
            obj = null;
        }
        i56 i56 = (i56) obj;
        if (i56 == null || this.f != i56.f) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.g);
        sb.append('.');
        sb.append(this.h);
        sb.append('.');
        sb.append(this.i);
        return sb.toString();
    }
}
