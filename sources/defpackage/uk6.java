package defpackage;

/* renamed from: uk6  reason: default package */
/* compiled from: TaskQueue.kt */
public final class uk6 extends fj6 {
    public final /* synthetic */ pk6 e;
    public final /* synthetic */ int f;
    public final /* synthetic */ lk6 g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public uk6(String str, boolean z, String str2, boolean z2, pk6 pk6, int i, lk6 lk6) {
        super(str2, z2);
        this.e = pk6;
        this.f = i;
        this.g = lk6;
    }

    @Override // defpackage.fj6
    public long a() {
        this.e.q.c(this.f, this.g);
        synchronized (this.e) {
            this.e.G.remove(Integer.valueOf(this.f));
        }
        return -1;
    }
}
