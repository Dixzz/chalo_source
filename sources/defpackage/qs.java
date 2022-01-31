package defpackage;

import java.util.Objects;

/* renamed from: qs  reason: default package */
/* compiled from: WorkProgressDao_Impl */
public final class qs implements ps {

    /* renamed from: a  reason: collision with root package name */
    public final wl f2984a;
    public final bm b;
    public final bm c;

    /* renamed from: qs$a */
    /* compiled from: WorkProgressDao_Impl */
    public class a extends ql<os> {
        public a(qs qsVar, wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.ql
        public void bind(sm smVar, os osVar) {
            Objects.requireNonNull(osVar);
            smVar.E0(1);
            byte[] c = np.c(null);
            if (c == null) {
                smVar.E0(2);
            } else {
                smVar.h0(2, c);
            }
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }
    }

    /* renamed from: qs$b */
    /* compiled from: WorkProgressDao_Impl */
    public class b extends bm {
        public b(qs qsVar, wl wlVar) {
            super(wlVar);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    /* renamed from: qs$c */
    /* compiled from: WorkProgressDao_Impl */
    public class c extends bm {
        public c(qs qsVar, wl wlVar) {
            super(wlVar);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "DELETE FROM WorkProgress";
        }
    }

    public qs(wl wlVar) {
        this.f2984a = wlVar;
        new a(this, wlVar);
        this.b = new b(this, wlVar);
        this.c = new c(this, wlVar);
    }

    public void a(String str) {
        this.f2984a.assertNotSuspendingTransaction();
        sm acquire = this.b.acquire();
        if (str == null) {
            acquire.E0(1);
        } else {
            acquire.z(1, str);
        }
        this.f2984a.beginTransaction();
        try {
            acquire.F();
            this.f2984a.setTransactionSuccessful();
        } finally {
            this.f2984a.endTransaction();
            this.b.release(acquire);
        }
    }

    public void b() {
        this.f2984a.assertNotSuspendingTransaction();
        sm acquire = this.c.acquire();
        this.f2984a.beginTransaction();
        try {
            acquire.F();
            this.f2984a.setTransactionSuccessful();
        } finally {
            this.f2984a.endTransaction();
            this.c.release(acquire);
        }
    }
}
