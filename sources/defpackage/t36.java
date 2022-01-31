package defpackage;

import defpackage.u36;

/* renamed from: t36  reason: default package */
/* compiled from: Socket */
public class t36 implements Runnable {
    public final /* synthetic */ u36 f;

    /* renamed from: t36$a */
    /* compiled from: Socket */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            u36 u36 = t36.this.f;
            if (u36.y != u36.e.CLOSED) {
                u36.i("ping timeout", null);
            }
        }
    }

    public t36(u36 u36, u36 u362) {
        this.f = u362;
    }

    public void run() {
        c56.a(new a());
    }
}
