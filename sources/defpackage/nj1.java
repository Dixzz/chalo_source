package defpackage;

/* renamed from: nj1  reason: default package */
/* compiled from: DefaultRetryPolicy */
public class nj1 implements ak1 {

    /* renamed from: a  reason: collision with root package name */
    public int f2564a;
    public int b;
    public final int c;
    public final float d;

    public nj1(int i, int i2, float f) {
        this.f2564a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // defpackage.ak1
    public void a(dk1 dk1) throws dk1 {
        boolean z = true;
        int i = this.b + 1;
        this.b = i;
        int i2 = this.f2564a;
        this.f2564a = i2 + ((int) (((float) i2) * this.d));
        if (i > this.c) {
            z = false;
        }
        if (!z) {
            throw dk1;
        }
    }

    @Override // defpackage.ak1
    public int b() {
        return this.f2564a;
    }

    @Override // defpackage.ak1
    public int c() {
        return this.b;
    }
}
