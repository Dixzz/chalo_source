package defpackage;

/* renamed from: d85  reason: default package */
/* compiled from: Codeword */
public final class d85 {

    /* renamed from: a  reason: collision with root package name */
    public final int f809a;
    public final int b;
    public final int c;
    public final int d;
    public int e = -1;

    public d85(int i, int i2, int i3, int i4) {
        this.f809a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public boolean a() {
        int i = this.e;
        return i != -1 && this.c == (i % 3) * 3;
    }

    public void b() {
        this.e = (this.c / 3) + ((this.d / 30) * 3);
    }

    public String toString() {
        return this.e + "|" + this.d;
    }
}
