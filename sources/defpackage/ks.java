package defpackage;

import android.database.Cursor;

/* renamed from: ks  reason: default package */
/* compiled from: SystemIdInfoDao_Impl */
public final class ks implements js {

    /* renamed from: a  reason: collision with root package name */
    public final wl f2112a;
    public final ql<is> b;
    public final bm c;

    /* renamed from: ks$a */
    /* compiled from: SystemIdInfoDao_Impl */
    public class a extends ql<is> {
        public a(ks ksVar, wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.ql
        public void bind(sm smVar, is isVar) {
            is isVar2 = isVar;
            String str = isVar2.f1565a;
            if (str == null) {
                smVar.E0(1);
            } else {
                smVar.z(1, str);
            }
            smVar.d0(2, (long) isVar2.b);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }
    }

    /* renamed from: ks$b */
    /* compiled from: SystemIdInfoDao_Impl */
    public class b extends bm {
        public b(ks ksVar, wl wlVar) {
            super(wlVar);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public ks(wl wlVar) {
        this.f2112a = wlVar;
        this.b = new a(this, wlVar);
        this.c = new b(this, wlVar);
    }

    public is a(String str) {
        yl e = yl.e("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        this.f2112a.assertNotSuspendingTransaction();
        is isVar = null;
        Cursor b2 = hm.b(this.f2112a, e, false, null);
        try {
            int L = h.L(b2, "work_spec_id");
            int L2 = h.L(b2, "system_id");
            if (b2.moveToFirst()) {
                isVar = new is(b2.getString(L), b2.getInt(L2));
            }
            return isVar;
        } finally {
            b2.close();
            e.f();
        }
    }

    public void b(is isVar) {
        this.f2112a.assertNotSuspendingTransaction();
        this.f2112a.beginTransaction();
        try {
            this.b.insert(isVar);
            this.f2112a.setTransactionSuccessful();
        } finally {
            this.f2112a.endTransaction();
        }
    }

    public void c(String str) {
        this.f2112a.assertNotSuspendingTransaction();
        sm acquire = this.c.acquire();
        if (str == null) {
            acquire.E0(1);
        } else {
            acquire.z(1, str);
        }
        this.f2112a.beginTransaction();
        try {
            acquire.F();
            this.f2112a.setTransactionSuccessful();
        } finally {
            this.f2112a.endTransaction();
            this.c.release(acquire);
        }
    }
}
