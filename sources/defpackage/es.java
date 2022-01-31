package defpackage;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* renamed from: es  reason: default package */
/* compiled from: DependencyDao_Impl */
public final class es implements ds {

    /* renamed from: a  reason: collision with root package name */
    public final wl f1022a;
    public final ql<cs> b;

    /* renamed from: es$a */
    /* compiled from: DependencyDao_Impl */
    public class a extends ql<cs> {
        public a(es esVar, wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.ql
        public void bind(sm smVar, cs csVar) {
            cs csVar2 = csVar;
            String str = csVar2.f748a;
            if (str == null) {
                smVar.E0(1);
            } else {
                smVar.z(1, str);
            }
            String str2 = csVar2.b;
            if (str2 == null) {
                smVar.E0(2);
            } else {
                smVar.z(2, str2);
            }
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }
    }

    public es(wl wlVar) {
        this.f1022a = wlVar;
        this.b = new a(this, wlVar);
    }

    public List<String> a(String str) {
        yl e = yl.e("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        this.f1022a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f1022a, e, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            e.f();
        }
    }

    public boolean b(String str) {
        boolean z = true;
        yl e = yl.e("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        this.f1022a.assertNotSuspendingTransaction();
        boolean z2 = false;
        Cursor b2 = hm.b(this.f1022a, e, false, null);
        try {
            if (b2.moveToFirst()) {
                if (b2.getInt(0) == 0) {
                    z = false;
                }
                z2 = z;
            }
            return z2;
        } finally {
            b2.close();
            e.f();
        }
    }
}
