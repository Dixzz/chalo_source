package defpackage;

/* renamed from: v36  reason: default package */
/* compiled from: Socket */
public class v36 implements Runnable {
    public final /* synthetic */ u36 f;

    /* renamed from: v36$a */
    /* compiled from: Socket */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            v36.this.f.a("ping", new Object[0]);
        }
    }

    public v36(u36 u36) {
        this.f = u36;
    }

    public void run() {
        this.f.l(new s46("ping"), new a());
    }
}
