package defpackage;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: mo5  reason: default package */
/* compiled from: FrequencyLimitDao_Impl */
public final class mo5 implements lo5 {

    /* renamed from: a  reason: collision with root package name */
    public final wl f2419a;
    public final ql<ko5> b;
    public final ql<no5> c;
    public final pl<ko5> d;
    public final pl<ko5> e;

    /* renamed from: mo5$a */
    /* compiled from: FrequencyLimitDao_Impl */
    public class a extends ql<ko5> {
        public a(mo5 mo5, wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.ql
        public void bind(sm smVar, ko5 ko5) {
            ko5 ko52 = ko5;
            smVar.d0(1, (long) ko52.f2094a);
            String str = ko52.b;
            if (str == null) {
                smVar.E0(2);
            } else {
                smVar.z(2, str);
            }
            smVar.d0(3, (long) ko52.c);
            smVar.d0(4, ko52.d);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "INSERT OR IGNORE INTO `constraints` (`id`,`constraintId`,`count`,`range`) VALUES (nullif(?, 0),?,?,?)";
        }
    }

    /* renamed from: mo5$b */
    /* compiled from: FrequencyLimitDao_Impl */
    public class b extends ql<no5> {
        public b(mo5 mo5, wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.ql
        public void bind(sm smVar, no5 no5) {
            no5 no52 = no5;
            smVar.d0(1, (long) no52.f2584a);
            String str = no52.b;
            if (str == null) {
                smVar.E0(2);
            } else {
                smVar.z(2, str);
            }
            smVar.d0(3, no52.c);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "INSERT OR REPLACE INTO `occurrences` (`id`,`parentConstraintId`,`timeStamp`) VALUES (nullif(?, 0),?,?)";
        }
    }

    /* renamed from: mo5$c */
    /* compiled from: FrequencyLimitDao_Impl */
    public class c extends pl<ko5> {
        public c(mo5 mo5, wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.pl
        public void bind(sm smVar, ko5 ko5) {
            smVar.d0(1, (long) ko5.f2094a);
        }

        @Override // defpackage.bm, defpackage.pl
        public String createQuery() {
            return "DELETE FROM `constraints` WHERE `id` = ?";
        }
    }

    /* renamed from: mo5$d */
    /* compiled from: FrequencyLimitDao_Impl */
    public class d extends pl<ko5> {
        public d(mo5 mo5, wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.pl
        public void bind(sm smVar, ko5 ko5) {
            ko5 ko52 = ko5;
            smVar.d0(1, (long) ko52.f2094a);
            String str = ko52.b;
            if (str == null) {
                smVar.E0(2);
            } else {
                smVar.z(2, str);
            }
            smVar.d0(3, (long) ko52.c);
            smVar.d0(4, ko52.d);
            smVar.d0(5, (long) ko52.f2094a);
        }

        @Override // defpackage.bm, defpackage.pl
        public String createQuery() {
            return "UPDATE OR ABORT `constraints` SET `id` = ?,`constraintId` = ?,`count` = ?,`range` = ? WHERE `id` = ?";
        }
    }

    public mo5(wl wlVar) {
        this.f2419a = wlVar;
        this.b = new a(this, wlVar);
        this.c = new b(this, wlVar);
        this.d = new c(this, wlVar);
        this.e = new d(this, wlVar);
    }

    public void a(Collection<String> collection) {
        this.f2419a.assertNotSuspendingTransaction();
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM constraints WHERE (constraintId IN (");
        im.a(sb, collection.size());
        sb.append("))");
        sm compileStatement = this.f2419a.compileStatement(sb.toString());
        int i = 1;
        for (String str : collection) {
            if (str == null) {
                compileStatement.E0(i);
            } else {
                compileStatement.z(i, str);
            }
            i++;
        }
        this.f2419a.beginTransaction();
        try {
            compileStatement.F();
            this.f2419a.setTransactionSuccessful();
        } finally {
            this.f2419a.endTransaction();
        }
    }

    public List<ko5> b() {
        yl e2 = yl.e("SELECT * FROM constraints", 0);
        this.f2419a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f2419a, e2, false, null);
        try {
            int L = h.L(b2, "id");
            int L2 = h.L(b2, "constraintId");
            int L3 = h.L(b2, "count");
            int L4 = h.L(b2, "range");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                ko5 ko5 = new ko5();
                ko5.f2094a = b2.getInt(L);
                ko5.b = b2.getString(L2);
                ko5.c = b2.getInt(L3);
                ko5.d = b2.getLong(L4);
                arrayList.add(ko5);
            }
            return arrayList;
        } finally {
            b2.close();
            e2.f();
        }
    }

    public void c(ko5 ko5) {
        this.f2419a.assertNotSuspendingTransaction();
        this.f2419a.beginTransaction();
        try {
            this.b.insert(ko5);
            this.f2419a.setTransactionSuccessful();
        } finally {
            this.f2419a.endTransaction();
        }
    }
}
