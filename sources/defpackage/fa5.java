package defpackage;

/* renamed from: fa5  reason: default package */
/* compiled from: Size */
public class fa5 implements Comparable<fa5> {
    public final int f;
    public final int g;

    public fa5(int i, int i2) {
        this.f = i;
        this.g = i2;
    }

    public fa5 a(fa5 fa5) {
        int i = this.f;
        int i2 = fa5.g;
        int i3 = i * i2;
        int i4 = fa5.f;
        int i5 = this.g;
        if (i3 <= i4 * i5) {
            return new fa5(i4, (i5 * i4) / i);
        }
        return new fa5((i * i2) / i5, i2);
    }

    public fa5 c(fa5 fa5) {
        int i = this.f;
        int i2 = fa5.g;
        int i3 = i * i2;
        int i4 = fa5.f;
        int i5 = this.g;
        if (i3 >= i4 * i5) {
            return new fa5(i4, (i5 * i4) / i);
        }
        return new fa5((i * i2) / i5, i2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(fa5 fa5) {
        fa5 fa52 = fa5;
        int i = this.g * this.f;
        int i2 = fa52.g * fa52.f;
        if (i2 < i) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || fa5.class != obj.getClass()) {
            return false;
        }
        fa5 fa5 = (fa5) obj;
        if (this.f == fa5.f && this.g == fa5.g) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f * 31) + this.g;
    }

    public String toString() {
        return this.f + "x" + this.g;
    }
}
