package defpackage;

/* renamed from: dl6  reason: default package */
/* compiled from: Settings.kt */
public final class dl6 {

    /* renamed from: a  reason: collision with root package name */
    public int f855a;
    public final int[] b = new int[10];

    public final int a() {
        if ((this.f855a & 128) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    public final void b(dl6 dl6) {
        n86.f(dl6, "other");
        for (int i = 0; i < 10; i++) {
            boolean z = true;
            if (((1 << i) & dl6.f855a) == 0) {
                z = false;
            }
            if (z) {
                c(i, dl6.b[i]);
            }
        }
    }

    public final dl6 c(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.b;
            if (i < iArr.length) {
                this.f855a = (1 << i) | this.f855a;
                iArr[i] = i2;
            }
        }
        return this;
    }
}
