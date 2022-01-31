package defpackage;

import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;

/* renamed from: gk5  reason: default package */
/* compiled from: PreferenceDataDao_Impl */
public final class gk5 extends fk5 {

    /* renamed from: a  reason: collision with root package name */
    public final wl f1274a;
    public final ql<ek5> b;
    public final bm c;
    public final bm d;

    /* renamed from: gk5$a */
    /* compiled from: PreferenceDataDao_Impl */
    public class a extends ql<ek5> {
        public a(gk5 gk5, wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.ql
        public void bind(sm smVar, ek5 ek5) {
            ek5 ek52 = ek5;
            String str = ek52.f985a;
            if (str == null) {
                smVar.E0(1);
            } else {
                smVar.z(1, str);
            }
            String str2 = ek52.b;
            if (str2 == null) {
                smVar.E0(2);
            } else {
                smVar.z(2, str2);
            }
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "INSERT OR REPLACE INTO `preferences` (`_id`,`value`) VALUES (?,?)";
        }
    }

    /* renamed from: gk5$b */
    /* compiled from: PreferenceDataDao_Impl */
    public class b extends bm {
        public b(gk5 gk5, wl wlVar) {
            super(wlVar);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "DELETE FROM preferences WHERE (`_id` == ?)";
        }
    }

    /* renamed from: gk5$c */
    /* compiled from: PreferenceDataDao_Impl */
    public class c extends bm {
        public c(gk5 gk5, wl wlVar) {
            super(wlVar);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "DELETE FROM preferences";
        }
    }

    public gk5(wl wlVar) {
        this.f1274a = wlVar;
        this.b = new a(this, wlVar);
        this.c = new b(this, wlVar);
        this.d = new c(this, wlVar);
    }

    @Override // defpackage.fk5
    public void a(String str) {
        this.f1274a.assertNotSuspendingTransaction();
        sm acquire = this.c.acquire();
        if (str == null) {
            acquire.E0(1);
        } else {
            acquire.z(1, str);
        }
        this.f1274a.beginTransaction();
        try {
            acquire.F();
            this.f1274a.setTransactionSuccessful();
        } finally {
            this.f1274a.endTransaction();
            this.c.release(acquire);
        }
    }

    @Override // defpackage.fk5
    public void b() {
        this.f1274a.assertNotSuspendingTransaction();
        sm acquire = this.d.acquire();
        this.f1274a.beginTransaction();
        try {
            acquire.F();
            this.f1274a.setTransactionSuccessful();
        } finally {
            this.f1274a.endTransaction();
            this.d.release(acquire);
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.fk5
    public List<ek5> c() {
        yl e = yl.e("SELECT * FROM preferences", 0);
        this.f1274a.assertNotSuspendingTransaction();
        this.f1274a.beginTransaction();
        try {
            Cursor b2 = hm.b(this.f1274a, e, false, null);
            try {
                int L = h.L(b2, "_id");
                int L2 = h.L(b2, FirebaseAnalytics.Param.VALUE);
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    arrayList.add(new ek5(b2.getString(L), b2.getString(L2)));
                }
                this.f1274a.setTransactionSuccessful();
                b2.close();
                e.f();
                return arrayList;
            } catch (Throwable th) {
                b2.close();
                e.f();
                throw th;
            }
        } finally {
            this.f1274a.endTransaction();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.fk5
    public List<String> d() {
        yl e = yl.e("SELECT _id FROM preferences", 0);
        this.f1274a.assertNotSuspendingTransaction();
        this.f1274a.beginTransaction();
        try {
            Cursor b2 = hm.b(this.f1274a, e, false, null);
            try {
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    arrayList.add(b2.getString(0));
                }
                this.f1274a.setTransactionSuccessful();
                b2.close();
                e.f();
                return arrayList;
            } catch (Throwable th) {
                b2.close();
                e.f();
                throw th;
            }
        } finally {
            this.f1274a.endTransaction();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // defpackage.fk5
    public ek5 e(String str) {
        yl e = yl.e("SELECT * FROM preferences WHERE (`_id` == ?)", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        this.f1274a.assertNotSuspendingTransaction();
        this.f1274a.beginTransaction();
        try {
            ek5 ek5 = null;
            Cursor b2 = hm.b(this.f1274a, e, false, null);
            try {
                int L = h.L(b2, "_id");
                int L2 = h.L(b2, FirebaseAnalytics.Param.VALUE);
                if (b2.moveToFirst()) {
                    ek5 = new ek5(b2.getString(L), b2.getString(L2));
                }
                this.f1274a.setTransactionSuccessful();
                b2.close();
                e.f();
                return ek5;
            } catch (Throwable th) {
                b2.close();
                e.f();
                throw th;
            }
        } finally {
            this.f1274a.endTransaction();
        }
    }

    @Override // defpackage.fk5
    public void f(ek5 ek5) {
        this.f1274a.assertNotSuspendingTransaction();
        this.f1274a.beginTransaction();
        try {
            this.b.insert(ek5);
            this.f1274a.setTransactionSuccessful();
        } finally {
            this.f1274a.endTransaction();
        }
    }
}
