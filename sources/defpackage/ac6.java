package defpackage;

/* renamed from: ac6  reason: default package */
/* compiled from: JobSupport.kt */
public final class ac6 implements mc6 {
    public final boolean f;

    public ac6(boolean z) {
        this.f = z;
    }

    @Override // defpackage.mc6
    public boolean a() {
        return this.f;
    }

    @Override // defpackage.mc6
    public bd6 d() {
        return null;
    }

    public String toString() {
        return hj1.Z(hj1.i0("Empty{"), this.f ? "Active" : "New", '}');
    }
}
