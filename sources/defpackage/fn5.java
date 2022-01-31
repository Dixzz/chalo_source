package defpackage;

import defpackage.gm5;
import defpackage.jn5;

/* renamed from: fn5  reason: default package */
/* compiled from: InAppAutomation */
public class fn5 implements Runnable {
    public final /* synthetic */ gm5.b f;
    public final /* synthetic */ dn5 g;

    /* renamed from: fn5$a */
    /* compiled from: InAppAutomation */
    public class a implements jn5.d {
        public a() {
        }

        @Override // defpackage.jn5.d
        public void a() {
            fn5.this.f.a(4);
            jn5 jn5 = fn5.this.g.e;
            synchronized (jn5.c) {
                jn5.c.remove(this);
            }
        }
    }

    public fn5(dn5 dn5, gm5.b bVar) {
        this.g = dn5;
        this.f = bVar;
    }

    public void run() {
        jn5 jn5 = this.g.e;
        if (jn5.b.j(jn5.c())) {
            this.f.a(4);
            return;
        }
        jn5 jn52 = this.g.e;
        a aVar = new a();
        synchronized (jn52.c) {
            jn52.c.add(aVar);
        }
    }
}
