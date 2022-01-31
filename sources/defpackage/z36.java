package defpackage;

import defpackage.m36;
import defpackage.u36;
import java.util.logging.Logger;

/* renamed from: z36  reason: default package */
/* compiled from: Socket */
public class z36 implements Runnable {
    public final /* synthetic */ u36 f;

    /* renamed from: z36$a */
    /* compiled from: Socket */
    public class a implements Runnable {
        public final /* synthetic */ u36 f;

        public a(z36 z36, u36 u36) {
            this.f = u36;
        }

        public void run() {
            u36 u36 = this.f;
            Logger logger = u36.B;
            u36.i("forced close", null);
            u36.B.fine("socket closing - telling transport to close");
            this.f.t.e();
        }
    }

    /* renamed from: z36$b */
    /* compiled from: Socket */
    public class b implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u36 f4119a;
        public final /* synthetic */ m36.a[] b;
        public final /* synthetic */ Runnable c;

        public b(z36 z36, u36 u36, m36.a[] aVarArr, Runnable runnable) {
            this.f4119a = u36;
            this.b = aVarArr;
            this.c = runnable;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            this.f4119a.c("upgrade", this.b[0]);
            this.f4119a.c("upgradeError", this.b[0]);
            this.c.run();
        }
    }

    /* renamed from: z36$c */
    /* compiled from: Socket */
    public class c implements Runnable {
        public final /* synthetic */ u36 f;
        public final /* synthetic */ m36.a[] g;

        public c(z36 z36, u36 u36, m36.a[] aVarArr) {
            this.f = u36;
            this.g = aVarArr;
        }

        public void run() {
            u36 u36 = this.f;
            u36.d("upgrade", new m36.b("upgrade", this.g[0]));
            u36 u362 = this.f;
            u362.d("upgradeError", new m36.b("upgradeError", this.g[0]));
        }
    }

    /* renamed from: z36$d */
    /* compiled from: Socket */
    public class d implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f4120a;
        public final /* synthetic */ Runnable b;

        public d(Runnable runnable, Runnable runnable2) {
            this.f4120a = runnable;
            this.b = runnable2;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            if (z36.this.f.e) {
                this.f4120a.run();
            } else {
                this.b.run();
            }
        }
    }

    public z36(u36 u36) {
        this.f = u36;
    }

    public void run() {
        u36 u36 = this.f;
        u36.e eVar = u36.y;
        if (eVar == u36.e.OPENING || eVar == u36.e.OPEN) {
            u36.y = u36.e.CLOSING;
            a aVar = new a(this, u36);
            m36.a[] aVarArr = {new b(this, u36, aVarArr, aVar)};
            c cVar = new c(this, u36, aVarArr);
            if (u36.s.size() > 0) {
                u36 u362 = this.f;
                u362.d("drain", new m36.b("drain", new d(cVar, aVar)));
            } else if (this.f.e) {
                cVar.run();
            } else {
                aVar.run();
            }
        }
    }
}
