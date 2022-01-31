package defpackage;

import android.database.Cursor;
import com.urbanairship.json.JsonValue;
import defpackage.t2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: qo5  reason: default package */
/* compiled from: AutomationDao_Impl */
public final class qo5 extends oo5 {

    /* renamed from: a  reason: collision with root package name */
    public final wl f2969a;
    public final ql<wo5> b;
    public final ro5 c = new ro5();
    public final ql<xo5> d;
    public final pl<wo5> e;
    public final pl<wo5> f;
    public final pl<xo5> g;

    /* renamed from: qo5$a */
    /* compiled from: AutomationDao_Impl */
    public class a extends ql<wo5> {
        public a(wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.ql
        public void bind(sm smVar, wo5 wo5) {
            String str;
            String str2;
            wo5 wo52 = wo5;
            smVar.d0(1, (long) wo52.f3817a);
            String str3 = wo52.b;
            if (str3 == null) {
                smVar.E0(2);
            } else {
                smVar.z(2, str3);
            }
            String str4 = wo52.c;
            if (str4 == null) {
                smVar.E0(3);
            } else {
                smVar.z(3, str4);
            }
            ro5 ro5 = qo5.this.c;
            zt5 zt5 = wo52.d;
            Objects.requireNonNull(ro5);
            String str5 = null;
            if (zt5 == null) {
                str = null;
            } else {
                str = JsonValue.x(zt5).toString();
            }
            if (str == null) {
                smVar.E0(4);
            } else {
                smVar.z(4, str);
            }
            smVar.d0(5, (long) wo52.e);
            smVar.d0(6, (long) wo52.f);
            smVar.d0(7, wo52.g);
            smVar.d0(8, wo52.h);
            smVar.d0(9, wo52.i);
            smVar.d0(10, wo52.j);
            String str6 = wo52.k;
            if (str6 == null) {
                smVar.E0(11);
            } else {
                smVar.z(11, str6);
            }
            String f = qo5.this.c.f(wo52.l);
            if (f == null) {
                smVar.E0(12);
            } else {
                smVar.z(12, f);
            }
            smVar.d0(13, (long) wo52.m);
            smVar.d0(14, (long) wo52.n);
            smVar.d0(15, wo52.o);
            ro5 ro52 = qo5.this.c;
            pn5 pn5 = wo52.p;
            Objects.requireNonNull(ro52);
            if (pn5 == null) {
                str2 = null;
            } else {
                str2 = pn5.b().toString();
            }
            if (str2 == null) {
                smVar.E0(16);
            } else {
                smVar.z(16, str2);
            }
            smVar.d0(17, (long) wo52.q);
            String b = ro5.b(wo52.r);
            if (b == null) {
                smVar.E0(18);
            } else {
                smVar.z(18, b);
            }
            smVar.d0(19, wo52.s);
            String str7 = wo52.t;
            if (str7 == null) {
                smVar.E0(20);
            } else {
                smVar.z(20, str7);
            }
            ro5 ro53 = qo5.this.c;
            fm5 fm5 = wo52.u;
            Objects.requireNonNull(ro53);
            if (fm5 != null) {
                str5 = fm5.b().toString();
            }
            if (str5 == null) {
                smVar.E0(21);
            } else {
                smVar.z(21, str5);
            }
            String f2 = qo5.this.c.f(wo52.v);
            if (f2 == null) {
                smVar.E0(22);
            } else {
                smVar.z(22, f2);
            }
            String b2 = ro5.b(wo52.w);
            if (b2 == null) {
                smVar.E0(23);
            } else {
                smVar.z(23, b2);
            }
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "INSERT OR REPLACE INTO `schedules` (`id`,`scheduleId`,`group`,`metadata`,`limit`,`priority`,`scheduleStart`,`scheduleEnd`,`editGracePeriod`,`interval`,`scheduleType`,`data`,`count`,`executionState`,`executionStateChangeDate`,`triggerContext`,`appState`,`screens`,`seconds`,`regionId`,`audience`,`campaigns`,`frequencyConstraintIds`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* renamed from: qo5$b */
    /* compiled from: AutomationDao_Impl */
    public class b extends ql<xo5> {
        public b(wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.ql
        public void bind(sm smVar, xo5 xo5) {
            String str;
            xo5 xo52 = xo5;
            smVar.d0(1, (long) xo52.f3949a);
            smVar.d0(2, (long) xo52.b);
            smVar.N(3, xo52.c);
            ro5 ro5 = qo5.this.c;
            bu5 bu5 = xo52.d;
            Objects.requireNonNull(ro5);
            if (bu5 == null) {
                str = null;
            } else {
                str = bu5.b().toString();
            }
            if (str == null) {
                smVar.E0(4);
            } else {
                smVar.z(4, str);
            }
            smVar.d0(5, xo52.e ? 1 : 0);
            smVar.N(6, xo52.f);
            String str2 = xo52.g;
            if (str2 == null) {
                smVar.E0(7);
            } else {
                smVar.z(7, str2);
            }
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "INSERT OR REPLACE INTO `triggers` (`id`,`triggerType`,`goal`,`jsonPredicate`,`isCancellation`,`progress`,`parentScheduleId`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
        }
    }

    /* renamed from: qo5$c */
    /* compiled from: AutomationDao_Impl */
    public class c extends pl<wo5> {
        public c(qo5 qo5, wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.pl
        public void bind(sm smVar, wo5 wo5) {
            smVar.d0(1, (long) wo5.f3817a);
        }

        @Override // defpackage.bm, defpackage.pl
        public String createQuery() {
            return "DELETE FROM `schedules` WHERE `id` = ?";
        }
    }

    /* renamed from: qo5$d */
    /* compiled from: AutomationDao_Impl */
    public class d extends pl<wo5> {
        public d(wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.pl
        public void bind(sm smVar, wo5 wo5) {
            String str;
            String str2;
            wo5 wo52 = wo5;
            smVar.d0(1, (long) wo52.f3817a);
            String str3 = wo52.b;
            if (str3 == null) {
                smVar.E0(2);
            } else {
                smVar.z(2, str3);
            }
            String str4 = wo52.c;
            if (str4 == null) {
                smVar.E0(3);
            } else {
                smVar.z(3, str4);
            }
            ro5 ro5 = qo5.this.c;
            zt5 zt5 = wo52.d;
            Objects.requireNonNull(ro5);
            String str5 = null;
            if (zt5 == null) {
                str = null;
            } else {
                str = JsonValue.x(zt5).toString();
            }
            if (str == null) {
                smVar.E0(4);
            } else {
                smVar.z(4, str);
            }
            smVar.d0(5, (long) wo52.e);
            smVar.d0(6, (long) wo52.f);
            smVar.d0(7, wo52.g);
            smVar.d0(8, wo52.h);
            smVar.d0(9, wo52.i);
            smVar.d0(10, wo52.j);
            String str6 = wo52.k;
            if (str6 == null) {
                smVar.E0(11);
            } else {
                smVar.z(11, str6);
            }
            String f = qo5.this.c.f(wo52.l);
            if (f == null) {
                smVar.E0(12);
            } else {
                smVar.z(12, f);
            }
            smVar.d0(13, (long) wo52.m);
            smVar.d0(14, (long) wo52.n);
            smVar.d0(15, wo52.o);
            ro5 ro52 = qo5.this.c;
            pn5 pn5 = wo52.p;
            Objects.requireNonNull(ro52);
            if (pn5 == null) {
                str2 = null;
            } else {
                str2 = pn5.b().toString();
            }
            if (str2 == null) {
                smVar.E0(16);
            } else {
                smVar.z(16, str2);
            }
            smVar.d0(17, (long) wo52.q);
            String b = ro5.b(wo52.r);
            if (b == null) {
                smVar.E0(18);
            } else {
                smVar.z(18, b);
            }
            smVar.d0(19, wo52.s);
            String str7 = wo52.t;
            if (str7 == null) {
                smVar.E0(20);
            } else {
                smVar.z(20, str7);
            }
            ro5 ro53 = qo5.this.c;
            fm5 fm5 = wo52.u;
            Objects.requireNonNull(ro53);
            if (fm5 != null) {
                str5 = fm5.b().toString();
            }
            if (str5 == null) {
                smVar.E0(21);
            } else {
                smVar.z(21, str5);
            }
            String f2 = qo5.this.c.f(wo52.v);
            if (f2 == null) {
                smVar.E0(22);
            } else {
                smVar.z(22, f2);
            }
            String b2 = ro5.b(wo52.w);
            if (b2 == null) {
                smVar.E0(23);
            } else {
                smVar.z(23, b2);
            }
            smVar.d0(24, (long) wo52.f3817a);
        }

        @Override // defpackage.bm, defpackage.pl
        public String createQuery() {
            return "UPDATE OR ABORT `schedules` SET `id` = ?,`scheduleId` = ?,`group` = ?,`metadata` = ?,`limit` = ?,`priority` = ?,`scheduleStart` = ?,`scheduleEnd` = ?,`editGracePeriod` = ?,`interval` = ?,`scheduleType` = ?,`data` = ?,`count` = ?,`executionState` = ?,`executionStateChangeDate` = ?,`triggerContext` = ?,`appState` = ?,`screens` = ?,`seconds` = ?,`regionId` = ?,`audience` = ?,`campaigns` = ?,`frequencyConstraintIds` = ? WHERE `id` = ?";
        }
    }

    /* renamed from: qo5$e */
    /* compiled from: AutomationDao_Impl */
    public class e extends pl<xo5> {
        public e(wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        @Override // defpackage.pl
        public void bind(sm smVar, xo5 xo5) {
            String str;
            xo5 xo52 = xo5;
            smVar.d0(1, (long) xo52.f3949a);
            smVar.d0(2, (long) xo52.b);
            smVar.N(3, xo52.c);
            ro5 ro5 = qo5.this.c;
            bu5 bu5 = xo52.d;
            Objects.requireNonNull(ro5);
            if (bu5 == null) {
                str = null;
            } else {
                str = bu5.b().toString();
            }
            if (str == null) {
                smVar.E0(4);
            } else {
                smVar.z(4, str);
            }
            smVar.d0(5, xo52.e ? 1 : 0);
            smVar.N(6, xo52.f);
            String str2 = xo52.g;
            if (str2 == null) {
                smVar.E0(7);
            } else {
                smVar.z(7, str2);
            }
            smVar.d0(8, (long) xo52.f3949a);
        }

        @Override // defpackage.bm, defpackage.pl
        public String createQuery() {
            return "UPDATE OR ABORT `triggers` SET `id` = ?,`triggerType` = ?,`goal` = ?,`jsonPredicate` = ?,`isCancellation` = ?,`progress` = ?,`parentScheduleId` = ? WHERE `id` = ?";
        }
    }

    public qo5(wl wlVar) {
        this.f2969a = wlVar;
        this.b = new a(wlVar);
        this.d = new b(wlVar);
        this.e = new c(this, wlVar);
        this.f = new d(wlVar);
        this.g = new e(wlVar);
    }

    @Override // defpackage.oo5
    public void a(wo5 wo5) {
        this.f2969a.assertNotSuspendingTransaction();
        this.f2969a.beginTransaction();
        try {
            this.e.handle(wo5);
            this.f2969a.setTransactionSuccessful();
        } finally {
            this.f2969a.endTransaction();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x030a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02ef A[Catch:{ all -> 0x034b }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02fe A[Catch:{ all -> 0x034b }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0305 A[Catch:{ all -> 0x034b }] */
    @Override // defpackage.oo5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<defpackage.so5> c() {
        /*
        // Method dump skipped, instructions count: 862
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qo5.c():java.util.List");
    }

    @Override // defpackage.oo5
    public List<xo5> d(int i) {
        yl e2 = yl.e("SELECT triggers.* FROM triggers JOIN schedules ON schedules.scheduleId = triggers.parentScheduleId AND (triggers.triggerType = ?) AND ((triggers.isCancellation = 1 AND + schedules.executionState IN (1,5,6))OR (triggers.isCancellation = 0 AND + schedules.executionState = 0))AND (schedules.scheduleStart < 0 OR schedules.scheduleStart <= strftime('%s', 'now') * 1000)", 1);
        e2.d0(1, (long) i);
        this.f2969a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f2969a, e2, false, null);
        try {
            int L = h.L(b2, "id");
            int L2 = h.L(b2, "triggerType");
            int L3 = h.L(b2, "goal");
            int L4 = h.L(b2, "jsonPredicate");
            int L5 = h.L(b2, "isCancellation");
            int L6 = h.L(b2, "progress");
            int L7 = h.L(b2, "parentScheduleId");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                xo5 xo5 = new xo5();
                xo5.f3949a = b2.getInt(L);
                xo5.b = b2.getInt(L2);
                xo5.c = b2.getDouble(L3);
                xo5.d = this.c.d(b2.getString(L4));
                xo5.e = b2.getInt(L5) != 0;
                xo5.f = b2.getDouble(L6);
                xo5.g = b2.getString(L7);
                arrayList.add(xo5);
            }
            return arrayList;
        } finally {
            b2.close();
            e2.f();
        }
    }

    @Override // defpackage.oo5
    public List<xo5> e(int i, String str) {
        yl e2 = yl.e("SELECT triggers.* FROM triggers JOIN schedules ON schedules.scheduleId = triggers.parentScheduleId WHERE (schedules.scheduleId = ?)AND (triggers.triggerType = ?) AND ((triggers.isCancellation = 1 AND + schedules.executionState IN (1,5,6))OR (triggers.isCancellation = 0 AND + schedules.executionState = 0))AND (schedules.scheduleStart < 0 OR schedules.scheduleStart <= strftime('%s', 'now') * 1000)", 2);
        if (str == null) {
            e2.E0(1);
        } else {
            e2.z(1, str);
        }
        e2.d0(2, (long) i);
        this.f2969a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f2969a, e2, false, null);
        try {
            int L = h.L(b2, "id");
            int L2 = h.L(b2, "triggerType");
            int L3 = h.L(b2, "goal");
            int L4 = h.L(b2, "jsonPredicate");
            int L5 = h.L(b2, "isCancellation");
            int L6 = h.L(b2, "progress");
            int L7 = h.L(b2, "parentScheduleId");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                xo5 xo5 = new xo5();
                xo5.f3949a = b2.getInt(L);
                xo5.b = b2.getInt(L2);
                xo5.c = b2.getDouble(L3);
                xo5.d = this.c.d(b2.getString(L4));
                xo5.e = b2.getInt(L5) != 0;
                xo5.f = b2.getDouble(L6);
                xo5.g = b2.getString(L7);
                arrayList.add(xo5);
            }
            return arrayList;
        } finally {
            b2.close();
            e2.f();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x02b6 A[Catch:{ all -> 0x02e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02c4 A[Catch:{ all -> 0x02e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02c7 A[Catch:{ all -> 0x02e5 }] */
    @Override // defpackage.oo5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.so5 f(java.lang.String r30) {
        /*
        // Method dump skipped, instructions count: 760
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qo5.f(java.lang.String):so5");
    }

    @Override // defpackage.oo5
    public int g() {
        int i = 0;
        yl e2 = yl.e("SELECT COUNT(*) FROM schedules", 0);
        this.f2969a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f2969a, e2, false, null);
        try {
            if (b2.moveToFirst()) {
                i = b2.getInt(0);
            }
            return i;
        } finally {
            b2.close();
            e2.f();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x030a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02ef A[Catch:{ all -> 0x034b }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02fe A[Catch:{ all -> 0x034b }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0305 A[Catch:{ all -> 0x034b }] */
    @Override // defpackage.oo5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<defpackage.so5> h() {
        /*
        // Method dump skipped, instructions count: 862
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qo5.h():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x034a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x032f A[Catch:{ all -> 0x038b }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x033e A[Catch:{ all -> 0x038b }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0345 A[Catch:{ all -> 0x038b }] */
    @Override // defpackage.oo5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<defpackage.so5> i(java.util.Collection<java.lang.String> r34) {
        /*
        // Method dump skipped, instructions count: 926
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qo5.i(java.util.Collection):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x0314 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02f9 A[Catch:{ all -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0308 A[Catch:{ all -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x030f A[Catch:{ all -> 0x0355 }] */
    @Override // defpackage.oo5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<defpackage.so5> j(java.lang.String r34) {
        /*
        // Method dump skipped, instructions count: 872
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qo5.j(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x0314 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02f9 A[Catch:{ all -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0308 A[Catch:{ all -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x030f A[Catch:{ all -> 0x0355 }] */
    @Override // defpackage.oo5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<defpackage.so5> k(java.lang.String r34) {
        /*
        // Method dump skipped, instructions count: 872
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qo5.k(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x033a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x031f A[Catch:{ all -> 0x037b }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x032e A[Catch:{ all -> 0x037b }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0335 A[Catch:{ all -> 0x037b }] */
    @Override // defpackage.oo5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<defpackage.so5> l(int... r34) {
        /*
        // Method dump skipped, instructions count: 910
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qo5.l(int[]):java.util.List");
    }

    @Override // defpackage.oo5
    public void n(wo5 wo5, List<xo5> list) {
        this.f2969a.assertNotSuspendingTransaction();
        this.f2969a.beginTransaction();
        try {
            this.b.insert(wo5);
            this.d.insert(list);
            this.f2969a.setTransactionSuccessful();
        } finally {
            this.f2969a.endTransaction();
        }
    }

    @Override // defpackage.oo5
    public void o(Collection<so5> collection) {
        this.f2969a.beginTransaction();
        try {
            super.o(collection);
            this.f2969a.setTransactionSuccessful();
        } finally {
            this.f2969a.endTransaction();
        }
    }

    @Override // defpackage.oo5
    public void q(wo5 wo5, List<xo5> list) {
        this.f2969a.assertNotSuspendingTransaction();
        this.f2969a.beginTransaction();
        try {
            this.f.handle(wo5);
            this.g.handleMultiple(list);
            this.f2969a.setTransactionSuccessful();
        } finally {
            this.f2969a.endTransaction();
        }
    }

    @Override // defpackage.oo5
    public void s(List<xo5> list) {
        this.f2969a.assertNotSuspendingTransaction();
        this.f2969a.beginTransaction();
        try {
            this.g.handleMultiple(list);
            this.f2969a.setTransactionSuccessful();
        } finally {
            this.f2969a.endTransaction();
        }
    }

    public final void t(n2<String, ArrayList<xo5>> n2Var) {
        int i;
        t2.c cVar = (t2.c) n2Var.keySet();
        if (!cVar.isEmpty()) {
            if (n2Var.h > 999) {
                n2<String, ArrayList<xo5>> n2Var2 = new n2<>((int) wl.MAX_BIND_PARAMETER_CNT);
                int i2 = n2Var.h;
                int i3 = 0;
                loop0:
                while (true) {
                    i = 0;
                    while (i3 < i2) {
                        n2Var2.put(n2Var.h(i3), n2Var.l(i3));
                        i3++;
                        i++;
                        if (i == 999) {
                            t(n2Var2);
                            n2Var2 = new n2<>((int) wl.MAX_BIND_PARAMETER_CNT);
                        }
                    }
                    break loop0;
                }
                if (i > 0) {
                    t(n2Var2);
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT `id`,`triggerType`,`goal`,`jsonPredicate`,`isCancellation`,`progress`,`parentScheduleId` FROM `triggers` WHERE `parentScheduleId` IN (");
            int size = cVar.size();
            im.a(sb, size);
            sb.append(")");
            yl e2 = yl.e(sb.toString(), size + 0);
            Iterator it = cVar.iterator();
            int i4 = 1;
            while (true) {
                t2.a aVar = (t2.a) it;
                if (!aVar.hasNext()) {
                    break;
                }
                String str = (String) aVar.next();
                if (str == null) {
                    e2.E0(i4);
                } else {
                    e2.z(i4, str);
                }
                i4++;
            }
            Cursor b2 = hm.b(this.f2969a, e2, false, null);
            try {
                int K = h.K(b2, "parentScheduleId");
                int i5 = -1;
                if (K != -1) {
                    int K2 = h.K(b2, "id");
                    int K3 = h.K(b2, "triggerType");
                    int K4 = h.K(b2, "goal");
                    int K5 = h.K(b2, "jsonPredicate");
                    int K6 = h.K(b2, "isCancellation");
                    int K7 = h.K(b2, "progress");
                    int K8 = h.K(b2, "parentScheduleId");
                    while (b2.moveToNext()) {
                        if (!b2.isNull(K)) {
                            ArrayList<xo5> arrayList = n2Var.get(b2.getString(K));
                            if (arrayList != null) {
                                xo5 xo5 = new xo5();
                                if (K2 != i5) {
                                    xo5.f3949a = b2.getInt(K2);
                                }
                                if (K3 != i5) {
                                    xo5.b = b2.getInt(K3);
                                }
                                if (K4 != i5) {
                                    xo5.c = b2.getDouble(K4);
                                }
                                int i6 = -1;
                                if (K5 != -1) {
                                    xo5.d = this.c.d(b2.getString(K5));
                                    i6 = -1;
                                }
                                if (K6 != i6) {
                                    xo5.e = b2.getInt(K6) != 0;
                                    i6 = -1;
                                }
                                if (K7 != i6) {
                                    xo5.f = b2.getDouble(K7);
                                    i6 = -1;
                                }
                                if (K8 != i6) {
                                    xo5.g = b2.getString(K8);
                                }
                                arrayList.add(xo5);
                            }
                            i5 = -1;
                        }
                    }
                    b2.close();
                }
            } finally {
                b2.close();
            }
        }
    }
}
