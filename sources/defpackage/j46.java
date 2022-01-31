package defpackage;

import defpackage.i46;
import defpackage.m36;

/* renamed from: j46  reason: default package */
/* compiled from: Polling */
public class j46 implements Runnable {
    public final /* synthetic */ Runnable f;
    public final /* synthetic */ k46 g;

    /* renamed from: j46$a */
    /* compiled from: Polling */
    public class a implements Runnable {
        public final /* synthetic */ k46 f;

        public a(k46 k46) {
            this.f = k46;
        }

        public void run() {
            k46.o.fine("paused");
            this.f.k = i46.d.PAUSED;
            j46.this.f.run();
        }
    }

    /* renamed from: j46$b */
    /* compiled from: Polling */
    public class b implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int[] f1876a;
        public final /* synthetic */ Runnable b;

        public b(j46 j46, int[] iArr, Runnable runnable) {
            this.f1876a = iArr;
            this.b = runnable;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            k46.o.fine("pre-pause polling complete");
            int[] iArr = this.f1876a;
            int i = iArr[0] - 1;
            iArr[0] = i;
            if (i == 0) {
                this.b.run();
            }
        }
    }

    /* renamed from: j46$c */
    /* compiled from: Polling */
    public class c implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int[] f1877a;
        public final /* synthetic */ Runnable b;

        public c(j46 j46, int[] iArr, Runnable runnable) {
            this.f1877a = iArr;
            this.b = runnable;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            k46.o.fine("pre-pause writing complete");
            int[] iArr = this.f1877a;
            int i = iArr[0] - 1;
            iArr[0] = i;
            if (i == 0) {
                this.b.run();
            }
        }
    }

    public j46(k46 k46, Runnable runnable) {
        this.g = k46;
        this.f = runnable;
    }

    public void run() {
        k46 k46 = this.g;
        k46.k = i46.d.PAUSED;
        a aVar = new a(k46);
        boolean z = k46.n;
        if (z || !k46.b) {
            int[] iArr = {0};
            if (z) {
                k46.o.fine("we are currently polling - waiting to pause");
                iArr[0] = iArr[0] + 1;
                k46 k462 = this.g;
                k462.d("pollComplete", new m36.b("pollComplete", new b(this, iArr, aVar)));
            }
            if (!this.g.b) {
                k46.o.fine("we are currently writing - waiting to pause");
                iArr[0] = iArr[0] + 1;
                k46 k463 = this.g;
                k463.d("drain", new m36.b("drain", new c(this, iArr, aVar)));
                return;
            }
            return;
        }
        aVar.run();
    }
}
