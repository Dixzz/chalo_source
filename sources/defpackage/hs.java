package defpackage;

import android.database.Cursor;

/* renamed from: hs  reason: default package */
/* compiled from: PreferenceDao_Impl */
public final class hs implements gs {

    /* renamed from: a  reason: collision with root package name */
    public final wl f1418a;
    public final ql<fs> b;

    /* renamed from: hs$a */
    /* compiled from: PreferenceDao_Impl */
    public class a extends ql<fs> {
        public a(hs hsVar, wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.ql
        public void bind(sm smVar, fs fsVar) {
            fs fsVar2 = fsVar;
            String str = fsVar2.f1166a;
            if (str == null) {
                smVar.E0(1);
            } else {
                smVar.z(1, str);
            }
            Long l = fsVar2.b;
            if (l == null) {
                smVar.E0(2);
            } else {
                smVar.d0(2, l.longValue());
            }
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }
    }

    public hs(wl wlVar) {
        this.f1418a = wlVar;
        this.b = new a(this, wlVar);
    }

    public Long a(String str) {
        yl e = yl.e("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        this.f1418a.assertNotSuspendingTransaction();
        Long l = null;
        Cursor b2 = hm.b(this.f1418a, e, false, null);
        try {
            if (b2.moveToFirst()) {
                if (!b2.isNull(0)) {
                    l = Long.valueOf(b2.getLong(0));
                }
            }
            return l;
        } finally {
            b2.close();
            e.f();
        }
    }

    public void b(fs fsVar) {
        this.f1418a.assertNotSuspendingTransaction();
        this.f1418a.beginTransaction();
        try {
            this.b.insert(fsVar);
            this.f1418a.setTransactionSuccessful();
        } finally {
            this.f1418a.endTransaction();
        }
    }
}
