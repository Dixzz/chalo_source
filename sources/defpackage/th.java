package defpackage;

import android.os.Handler;
import defpackage.vh;
import defpackage.zg;

/* renamed from: th  reason: default package */
/* compiled from: ProcessLifecycleOwner */
public class th implements fh {
    public static final th n = new th();
    public int f = 0;
    public int g = 0;
    public boolean h = true;
    public boolean i = true;
    public Handler j;
    public final gh k = new gh(this);
    public Runnable l = new a();
    public vh.a m = new b();

    /* renamed from: th$a */
    /* compiled from: ProcessLifecycleOwner */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            th thVar = th.this;
            if (thVar.g == 0) {
                thVar.h = true;
                thVar.k.e(zg.a.ON_PAUSE);
            }
            th thVar2 = th.this;
            if (thVar2.f == 0 && thVar2.h) {
                thVar2.k.e(zg.a.ON_STOP);
                thVar2.i = true;
            }
        }
    }

    /* renamed from: th$b */
    /* compiled from: ProcessLifecycleOwner */
    public class b implements vh.a {
        public b() {
        }
    }

    public void a() {
        int i2 = this.g + 1;
        this.g = i2;
        if (i2 != 1) {
            return;
        }
        if (this.h) {
            this.k.e(zg.a.ON_RESUME);
            this.h = false;
            return;
        }
        this.j.removeCallbacks(this.l);
    }

    public void b() {
        int i2 = this.f + 1;
        this.f = i2;
        if (i2 == 1 && this.i) {
            this.k.e(zg.a.ON_START);
            this.i = false;
        }
    }

    @Override // defpackage.fh
    public zg getLifecycle() {
        return this.k;
    }
}
