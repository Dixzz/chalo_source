package defpackage;

import defpackage.u36;
import java.util.Objects;

/* renamed from: y36  reason: default package */
/* compiled from: Socket */
public class y36 implements Runnable {
    public final /* synthetic */ u36 f;

    /* renamed from: y36$a */
    /* compiled from: Socket */
    public class a implements Runnable {
        public final /* synthetic */ u36 f;

        public a(y36 y36, u36 u36) {
            this.f = u36;
        }

        public void run() {
            this.f.a("error", new n36("No transports available"));
        }
    }

    public y36(u36 u36) {
        this.f = u36;
    }

    public void run() {
        Objects.requireNonNull(this.f);
        if (this.f.o.size() == 0) {
            c56.b(new a(this, this.f));
            return;
        }
        u36 u36 = this.f;
        u36.y = u36.e.OPENING;
        i46 g = u36.g(this.f.o.get(0));
        u36.f(this.f, g);
        c56.a(new h46(g));
    }
}
