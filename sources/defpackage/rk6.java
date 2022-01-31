package defpackage;

import java.io.IOException;

/* renamed from: rk6  reason: default package */
/* compiled from: TaskQueue.kt */
public final class rk6 extends fj6 {
    public final /* synthetic */ pk6 e;
    public final /* synthetic */ int f;
    public final /* synthetic */ vm6 g;
    public final /* synthetic */ int h;
    public final /* synthetic */ boolean i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rk6(String str, boolean z, String str2, boolean z2, pk6 pk6, int i2, vm6 vm6, int i3, boolean z3) {
        super(str2, z2);
        this.e = pk6;
        this.f = i2;
        this.g = vm6;
        this.h = i3;
        this.i = z3;
    }

    @Override // defpackage.fj6
    public long a() {
        try {
            boolean d = this.e.q.d(this.f, this.g, this.h, this.i);
            if (d) {
                this.e.E.i(this.f, lk6.CANCEL);
            }
            if (!d && !this.i) {
                return -1;
            }
            synchronized (this.e) {
                this.e.G.remove(Integer.valueOf(this.f));
            }
            return -1;
        } catch (IOException unused) {
            return -1;
        }
    }
}
