package defpackage;

import android.os.Handler;
import defpackage.zg;

/* renamed from: yh  reason: default package */
/* compiled from: ServiceLifecycleDispatcher */
public class yh {

    /* renamed from: a  reason: collision with root package name */
    public final gh f4045a;
    public final Handler b = new Handler();
    public a c;

    /* renamed from: yh$a */
    /* compiled from: ServiceLifecycleDispatcher */
    public static class a implements Runnable {
        public final gh f;
        public final zg.a g;
        public boolean h = false;

        public a(gh ghVar, zg.a aVar) {
            this.f = ghVar;
            this.g = aVar;
        }

        public void run() {
            if (!this.h) {
                this.f.e(this.g);
                this.h = true;
            }
        }
    }

    public yh(fh fhVar) {
        this.f4045a = new gh(fhVar);
    }

    public final void a(zg.a aVar) {
        a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.run();
        }
        a aVar3 = new a(this.f4045a, aVar);
        this.c = aVar3;
        this.b.postAtFrontOfQueue(aVar3);
    }
}
