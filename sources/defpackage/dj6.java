package defpackage;

import defpackage.cj6;

/* renamed from: dj6  reason: default package */
/* compiled from: DiskLruCache.kt */
public final class dj6 extends cn6 {
    public boolean f;
    public final /* synthetic */ cj6.b g;
    public final /* synthetic */ qn6 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public dj6(cj6.b bVar, qn6 qn6, qn6 qn62) {
        super(qn62);
        this.g = bVar;
        this.h = qn6;
    }

    @Override // java.io.Closeable, defpackage.qn6, defpackage.cn6, java.lang.AutoCloseable
    public void close() {
        super.close();
        if (!this.f) {
            this.f = true;
            synchronized (this.g.j) {
                cj6.b bVar = this.g;
                int i = bVar.g - 1;
                bVar.g = i;
                if (i == 0 && bVar.e) {
                    bVar.j.n(bVar);
                }
            }
        }
    }
}
