package defpackage;

import java.io.IOException;
import java.util.List;

/* renamed from: sk6  reason: default package */
/* compiled from: TaskQueue.kt */
public final class sk6 extends fj6 {
    public final /* synthetic */ pk6 e;
    public final /* synthetic */ int f;
    public final /* synthetic */ List g;
    public final /* synthetic */ boolean h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sk6(String str, boolean z, String str2, boolean z2, pk6 pk6, int i, List list, boolean z3) {
        super(str2, z2);
        this.e = pk6;
        this.f = i;
        this.g = list;
        this.h = z3;
    }

    @Override // defpackage.fj6
    public long a() {
        boolean b = this.e.q.b(this.f, this.g, this.h);
        if (b) {
            try {
                this.e.E.i(this.f, lk6.CANCEL);
            } catch (IOException unused) {
                return -1;
            }
        }
        if (!b && !this.h) {
            return -1;
        }
        synchronized (this.e) {
            this.e.G.remove(Integer.valueOf(this.f));
        }
        return -1;
    }
}
