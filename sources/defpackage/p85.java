package defpackage;

/* renamed from: p85  reason: default package */
/* compiled from: BarcodeRow */
public final class p85 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f2780a;
    public int b = 0;

    public p85(int i) {
        this.f2780a = new byte[i];
    }

    public void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.b;
            this.b = i3 + 1;
            this.f2780a[i3] = z ? (byte) 1 : 0;
        }
    }
}
