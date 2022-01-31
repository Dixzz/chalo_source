package defpackage;

/* renamed from: ad6  reason: default package */
/* compiled from: MainCoroutineDispatcher.kt */
public abstract class ad6 extends kb6 {
    public abstract ad6 A();

    public final String D() {
        ad6 ad6;
        xb6 xb6 = xb6.f3911a;
        ad6 ad62 = xf6.c;
        if (this == ad62) {
            return "Dispatchers.Main";
        }
        try {
            ad6 = ad62.A();
        } catch (UnsupportedOperationException unused) {
            ad6 = null;
        }
        if (this == ad6) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // defpackage.kb6
    public String toString() {
        String D = D();
        if (D != null) {
            return D;
        }
        return getClass().getSimpleName() + '@' + hd3.l1(this);
    }
}
