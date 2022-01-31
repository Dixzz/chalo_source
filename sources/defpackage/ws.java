package defpackage;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ws  reason: default package */
/* compiled from: WorkTagDao_Impl */
public final class ws implements vs {

    /* renamed from: a  reason: collision with root package name */
    public final wl f3831a;
    public final ql<us> b;

    /* renamed from: ws$a */
    /* compiled from: WorkTagDao_Impl */
    public class a extends ql<us> {
        public a(ws wsVar, wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.ql
        public void bind(sm smVar, us usVar) {
            us usVar2 = usVar;
            String str = usVar2.f3549a;
            if (str == null) {
                smVar.E0(1);
            } else {
                smVar.z(1, str);
            }
            String str2 = usVar2.b;
            if (str2 == null) {
                smVar.E0(2);
            } else {
                smVar.z(2, str2);
            }
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public ws(wl wlVar) {
        this.f3831a = wlVar;
        this.b = new a(this, wlVar);
    }

    public List<String> a(String str) {
        yl e = yl.e("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        this.f3831a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f3831a, e, false, null);
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
}
