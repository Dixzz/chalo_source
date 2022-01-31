package defpackage;

import java.io.IOException;
import java.util.List;

/* renamed from: tk6  reason: default package */
/* compiled from: TaskQueue.kt */
public final class tk6 extends fj6 {
    public final /* synthetic */ pk6 e;
    public final /* synthetic */ int f;
    public final /* synthetic */ List g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public tk6(String str, boolean z, String str2, boolean z2, pk6 pk6, int i, List list) {
        super(str2, z2);
        this.e = pk6;
        this.f = i;
        this.g = list;
    }

    @Override // defpackage.fj6
    public long a() {
        if (!this.e.q.a(this.f, this.g)) {
            return -1;
        }
        try {
            this.e.E.i(this.f, lk6.CANCEL);
            synchronized (this.e) {
                this.e.G.remove(Integer.valueOf(this.f));
            }
            return -1;
        } catch (IOException unused) {
            return -1;
        }
    }
}
