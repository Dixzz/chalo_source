package defpackage;

import android.database.Cursor;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import defpackage.rs;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ts  reason: default package */
/* compiled from: WorkSpecDao_Impl */
public final class ts implements ss {

    /* renamed from: a  reason: collision with root package name */
    public final wl f3404a;
    public final ql<rs> b;
    public final bm c;
    public final bm d;
    public final bm e;
    public final bm f;
    public final bm g;
    public final bm h;
    public final bm i;

    /* renamed from: ts$a */
    /* compiled from: WorkSpecDao_Impl */
    public class a extends ql<rs> {
        public a(ts tsVar, wl wlVar) {
            super(wlVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [sm, java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0179  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0190  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0196  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x01a0 A[SYNTHETIC, Splitter:B:75:0x01a0] */
        @Override // defpackage.ql
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void bind(defpackage.sm r17, defpackage.rs r18) {
            /*
            // Method dump skipped, instructions count: 446
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ts.a.bind(sm, java.lang.Object):void");
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* renamed from: ts$b */
    /* compiled from: WorkSpecDao_Impl */
    public class b extends bm {
        public b(ts tsVar, wl wlVar) {
            super(wlVar);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    /* renamed from: ts$c */
    /* compiled from: WorkSpecDao_Impl */
    public class c extends bm {
        public c(ts tsVar, wl wlVar) {
            super(wlVar);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    /* renamed from: ts$d */
    /* compiled from: WorkSpecDao_Impl */
    public class d extends bm {
        public d(ts tsVar, wl wlVar) {
            super(wlVar);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    /* renamed from: ts$e */
    /* compiled from: WorkSpecDao_Impl */
    public class e extends bm {
        public e(ts tsVar, wl wlVar) {
            super(wlVar);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    /* renamed from: ts$f */
    /* compiled from: WorkSpecDao_Impl */
    public class f extends bm {
        public f(ts tsVar, wl wlVar) {
            super(wlVar);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    /* renamed from: ts$g */
    /* compiled from: WorkSpecDao_Impl */
    public class g extends bm {
        public g(ts tsVar, wl wlVar) {
            super(wlVar);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    /* renamed from: ts$h */
    /* compiled from: WorkSpecDao_Impl */
    public class h extends bm {
        public h(ts tsVar, wl wlVar) {
            super(wlVar);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    /* renamed from: ts$i */
    /* compiled from: WorkSpecDao_Impl */
    public class i extends bm {
        public i(ts tsVar, wl wlVar) {
            super(wlVar);
        }

        @Override // defpackage.bm
        public String createQuery() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public ts(wl wlVar) {
        this.f3404a = wlVar;
        this.b = new a(this, wlVar);
        this.c = new b(this, wlVar);
        this.d = new c(this, wlVar);
        this.e = new d(this, wlVar);
        this.f = new e(this, wlVar);
        this.g = new f(this, wlVar);
        this.h = new g(this, wlVar);
        this.i = new h(this, wlVar);
        new i(this, wlVar);
    }

    public void a(String str) {
        this.f3404a.assertNotSuspendingTransaction();
        sm acquire = this.c.acquire();
        if (str == null) {
            acquire.E0(1);
        } else {
            acquire.z(1, str);
        }
        this.f3404a.beginTransaction();
        try {
            acquire.F();
            this.f3404a.setTransactionSuccessful();
        } finally {
            this.f3404a.endTransaction();
            this.c.release(acquire);
        }
    }

    public List<rs> b(int i2) {
        yl ylVar;
        Throwable th;
        yl e2 = yl.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        e2.d0(1, (long) i2);
        this.f3404a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f3404a, e2, false, null);
        try {
            int L = h.L(b2, "required_network_type");
            int L2 = h.L(b2, "requires_charging");
            int L3 = h.L(b2, "requires_device_idle");
            int L4 = h.L(b2, "requires_battery_not_low");
            int L5 = h.L(b2, "requires_storage_not_low");
            int L6 = h.L(b2, "trigger_content_update_delay");
            int L7 = h.L(b2, "trigger_max_content_delay");
            int L8 = h.L(b2, "content_uri_triggers");
            int L9 = h.L(b2, "id");
            int L10 = h.L(b2, RemoteConfigConstants.ResponseFieldKey.STATE);
            int L11 = h.L(b2, "worker_class_name");
            int L12 = h.L(b2, "input_merger_class_name");
            int L13 = h.L(b2, "input");
            int L14 = h.L(b2, "output");
            ylVar = e2;
            try {
                int L15 = h.L(b2, "initial_delay");
                int L16 = h.L(b2, "interval_duration");
                int L17 = h.L(b2, "flex_duration");
                int L18 = h.L(b2, "run_attempt_count");
                int L19 = h.L(b2, "backoff_policy");
                int L20 = h.L(b2, "backoff_delay_duration");
                int L21 = h.L(b2, "period_start_time");
                int L22 = h.L(b2, "minimum_retention_duration");
                int L23 = h.L(b2, "schedule_requested_at");
                int L24 = h.L(b2, "run_in_foreground");
                int i3 = L14;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(L9);
                    String string2 = b2.getString(L11);
                    lp lpVar = new lp();
                    lpVar.f2251a = vn.G0(b2.getInt(L));
                    lpVar.b = b2.getInt(L2) != 0;
                    lpVar.c = b2.getInt(L3) != 0;
                    lpVar.d = b2.getInt(L4) != 0;
                    lpVar.e = b2.getInt(L5) != 0;
                    lpVar.f = b2.getLong(L6);
                    lpVar.g = b2.getLong(L7);
                    lpVar.h = vn.d(b2.getBlob(L8));
                    rs rsVar = new rs(string, string2);
                    rsVar.b = vn.H0(b2.getInt(L10));
                    rsVar.d = b2.getString(L12);
                    rsVar.e = np.a(b2.getBlob(L13));
                    rsVar.f = np.a(b2.getBlob(i3));
                    i3 = i3;
                    rsVar.g = b2.getLong(L15);
                    rsVar.h = b2.getLong(L16);
                    rsVar.i = b2.getLong(L17);
                    rsVar.k = b2.getInt(L18);
                    rsVar.l = vn.F0(b2.getInt(L19));
                    L17 = L17;
                    rsVar.m = b2.getLong(L20);
                    rsVar.n = b2.getLong(L21);
                    L21 = L21;
                    rsVar.o = b2.getLong(L22);
                    rsVar.p = b2.getLong(L23);
                    rsVar.q = b2.getInt(L24) != 0;
                    rsVar.j = lpVar;
                    arrayList.add(rsVar);
                    L23 = L23;
                    L24 = L24;
                    L2 = L2;
                    L12 = L12;
                    L15 = L15;
                    L16 = L16;
                    L18 = L18;
                    L9 = L9;
                    L11 = L11;
                    L = L;
                    L22 = L22;
                    L3 = L3;
                    L20 = L20;
                    L4 = L4;
                    L19 = L19;
                }
                b2.close();
                ylVar.f();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                ylVar.f();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            ylVar = e2;
            b2.close();
            ylVar.f();
            throw th;
        }
    }

    public List<String> c() {
        yl e2 = yl.e("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.f3404a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f3404a, e2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            e2.f();
        }
    }

    public List<rs> d(int i2) {
        yl ylVar;
        Throwable th;
        yl e2 = yl.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        e2.d0(1, (long) i2);
        this.f3404a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f3404a, e2, false, null);
        try {
            int L = h.L(b2, "required_network_type");
            int L2 = h.L(b2, "requires_charging");
            int L3 = h.L(b2, "requires_device_idle");
            int L4 = h.L(b2, "requires_battery_not_low");
            int L5 = h.L(b2, "requires_storage_not_low");
            int L6 = h.L(b2, "trigger_content_update_delay");
            int L7 = h.L(b2, "trigger_max_content_delay");
            int L8 = h.L(b2, "content_uri_triggers");
            int L9 = h.L(b2, "id");
            int L10 = h.L(b2, RemoteConfigConstants.ResponseFieldKey.STATE);
            int L11 = h.L(b2, "worker_class_name");
            int L12 = h.L(b2, "input_merger_class_name");
            int L13 = h.L(b2, "input");
            int L14 = h.L(b2, "output");
            ylVar = e2;
            try {
                int L15 = h.L(b2, "initial_delay");
                int L16 = h.L(b2, "interval_duration");
                int L17 = h.L(b2, "flex_duration");
                int L18 = h.L(b2, "run_attempt_count");
                int L19 = h.L(b2, "backoff_policy");
                int L20 = h.L(b2, "backoff_delay_duration");
                int L21 = h.L(b2, "period_start_time");
                int L22 = h.L(b2, "minimum_retention_duration");
                int L23 = h.L(b2, "schedule_requested_at");
                int L24 = h.L(b2, "run_in_foreground");
                int i3 = L14;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(L9);
                    String string2 = b2.getString(L11);
                    lp lpVar = new lp();
                    lpVar.f2251a = vn.G0(b2.getInt(L));
                    lpVar.b = b2.getInt(L2) != 0;
                    lpVar.c = b2.getInt(L3) != 0;
                    lpVar.d = b2.getInt(L4) != 0;
                    lpVar.e = b2.getInt(L5) != 0;
                    lpVar.f = b2.getLong(L6);
                    lpVar.g = b2.getLong(L7);
                    lpVar.h = vn.d(b2.getBlob(L8));
                    rs rsVar = new rs(string, string2);
                    rsVar.b = vn.H0(b2.getInt(L10));
                    rsVar.d = b2.getString(L12);
                    rsVar.e = np.a(b2.getBlob(L13));
                    rsVar.f = np.a(b2.getBlob(i3));
                    i3 = i3;
                    rsVar.g = b2.getLong(L15);
                    rsVar.h = b2.getLong(L16);
                    rsVar.i = b2.getLong(L17);
                    rsVar.k = b2.getInt(L18);
                    rsVar.l = vn.F0(b2.getInt(L19));
                    L17 = L17;
                    rsVar.m = b2.getLong(L20);
                    rsVar.n = b2.getLong(L21);
                    L21 = L21;
                    rsVar.o = b2.getLong(L22);
                    rsVar.p = b2.getLong(L23);
                    rsVar.q = b2.getInt(L24) != 0;
                    rsVar.j = lpVar;
                    arrayList.add(rsVar);
                    L23 = L23;
                    L24 = L24;
                    L2 = L2;
                    L12 = L12;
                    L15 = L15;
                    L16 = L16;
                    L18 = L18;
                    L9 = L9;
                    L11 = L11;
                    L = L;
                    L22 = L22;
                    L3 = L3;
                    L20 = L20;
                    L4 = L4;
                    L19 = L19;
                }
                b2.close();
                ylVar.f();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                ylVar.f();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            ylVar = e2;
            b2.close();
            ylVar.f();
            throw th;
        }
    }

    public List<rs> e() {
        yl ylVar;
        Throwable th;
        yl e2 = yl.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=1", 0);
        this.f3404a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f3404a, e2, false, null);
        try {
            int L = h.L(b2, "required_network_type");
            int L2 = h.L(b2, "requires_charging");
            int L3 = h.L(b2, "requires_device_idle");
            int L4 = h.L(b2, "requires_battery_not_low");
            int L5 = h.L(b2, "requires_storage_not_low");
            int L6 = h.L(b2, "trigger_content_update_delay");
            int L7 = h.L(b2, "trigger_max_content_delay");
            int L8 = h.L(b2, "content_uri_triggers");
            int L9 = h.L(b2, "id");
            int L10 = h.L(b2, RemoteConfigConstants.ResponseFieldKey.STATE);
            int L11 = h.L(b2, "worker_class_name");
            int L12 = h.L(b2, "input_merger_class_name");
            int L13 = h.L(b2, "input");
            int L14 = h.L(b2, "output");
            ylVar = e2;
            try {
                int L15 = h.L(b2, "initial_delay");
                int L16 = h.L(b2, "interval_duration");
                int L17 = h.L(b2, "flex_duration");
                int L18 = h.L(b2, "run_attempt_count");
                int L19 = h.L(b2, "backoff_policy");
                int L20 = h.L(b2, "backoff_delay_duration");
                int L21 = h.L(b2, "period_start_time");
                int L22 = h.L(b2, "minimum_retention_duration");
                int L23 = h.L(b2, "schedule_requested_at");
                int L24 = h.L(b2, "run_in_foreground");
                int i2 = L14;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(L9);
                    String string2 = b2.getString(L11);
                    lp lpVar = new lp();
                    lpVar.f2251a = vn.G0(b2.getInt(L));
                    lpVar.b = b2.getInt(L2) != 0;
                    lpVar.c = b2.getInt(L3) != 0;
                    lpVar.d = b2.getInt(L4) != 0;
                    lpVar.e = b2.getInt(L5) != 0;
                    lpVar.f = b2.getLong(L6);
                    lpVar.g = b2.getLong(L7);
                    lpVar.h = vn.d(b2.getBlob(L8));
                    rs rsVar = new rs(string, string2);
                    rsVar.b = vn.H0(b2.getInt(L10));
                    rsVar.d = b2.getString(L12);
                    rsVar.e = np.a(b2.getBlob(L13));
                    rsVar.f = np.a(b2.getBlob(i2));
                    i2 = i2;
                    rsVar.g = b2.getLong(L15);
                    rsVar.h = b2.getLong(L16);
                    rsVar.i = b2.getLong(L17);
                    rsVar.k = b2.getInt(L18);
                    rsVar.l = vn.F0(b2.getInt(L19));
                    L17 = L17;
                    rsVar.m = b2.getLong(L20);
                    rsVar.n = b2.getLong(L21);
                    L21 = L21;
                    rsVar.o = b2.getLong(L22);
                    rsVar.p = b2.getLong(L23);
                    rsVar.q = b2.getInt(L24) != 0;
                    rsVar.j = lpVar;
                    arrayList.add(rsVar);
                    L23 = L23;
                    L24 = L24;
                    L2 = L2;
                    L13 = L13;
                    L15 = L15;
                    L16 = L16;
                    L18 = L18;
                    L9 = L9;
                    L11 = L11;
                    L = L;
                    L22 = L22;
                    L3 = L3;
                    L20 = L20;
                    L4 = L4;
                    L19 = L19;
                }
                b2.close();
                ylVar.f();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                ylVar.f();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            ylVar = e2;
            b2.close();
            ylVar.f();
            throw th;
        }
    }

    public List<rs> f() {
        yl ylVar;
        Throwable th;
        yl e2 = yl.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f3404a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f3404a, e2, false, null);
        try {
            int L = h.L(b2, "required_network_type");
            int L2 = h.L(b2, "requires_charging");
            int L3 = h.L(b2, "requires_device_idle");
            int L4 = h.L(b2, "requires_battery_not_low");
            int L5 = h.L(b2, "requires_storage_not_low");
            int L6 = h.L(b2, "trigger_content_update_delay");
            int L7 = h.L(b2, "trigger_max_content_delay");
            int L8 = h.L(b2, "content_uri_triggers");
            int L9 = h.L(b2, "id");
            int L10 = h.L(b2, RemoteConfigConstants.ResponseFieldKey.STATE);
            int L11 = h.L(b2, "worker_class_name");
            int L12 = h.L(b2, "input_merger_class_name");
            int L13 = h.L(b2, "input");
            int L14 = h.L(b2, "output");
            ylVar = e2;
            try {
                int L15 = h.L(b2, "initial_delay");
                int L16 = h.L(b2, "interval_duration");
                int L17 = h.L(b2, "flex_duration");
                int L18 = h.L(b2, "run_attempt_count");
                int L19 = h.L(b2, "backoff_policy");
                int L20 = h.L(b2, "backoff_delay_duration");
                int L21 = h.L(b2, "period_start_time");
                int L22 = h.L(b2, "minimum_retention_duration");
                int L23 = h.L(b2, "schedule_requested_at");
                int L24 = h.L(b2, "run_in_foreground");
                int i2 = L14;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string = b2.getString(L9);
                    String string2 = b2.getString(L11);
                    lp lpVar = new lp();
                    lpVar.f2251a = vn.G0(b2.getInt(L));
                    lpVar.b = b2.getInt(L2) != 0;
                    lpVar.c = b2.getInt(L3) != 0;
                    lpVar.d = b2.getInt(L4) != 0;
                    lpVar.e = b2.getInt(L5) != 0;
                    lpVar.f = b2.getLong(L6);
                    lpVar.g = b2.getLong(L7);
                    lpVar.h = vn.d(b2.getBlob(L8));
                    rs rsVar = new rs(string, string2);
                    rsVar.b = vn.H0(b2.getInt(L10));
                    rsVar.d = b2.getString(L12);
                    rsVar.e = np.a(b2.getBlob(L13));
                    rsVar.f = np.a(b2.getBlob(i2));
                    i2 = i2;
                    rsVar.g = b2.getLong(L15);
                    rsVar.h = b2.getLong(L16);
                    rsVar.i = b2.getLong(L17);
                    rsVar.k = b2.getInt(L18);
                    rsVar.l = vn.F0(b2.getInt(L19));
                    L17 = L17;
                    rsVar.m = b2.getLong(L20);
                    rsVar.n = b2.getLong(L21);
                    L21 = L21;
                    rsVar.o = b2.getLong(L22);
                    rsVar.p = b2.getLong(L23);
                    rsVar.q = b2.getInt(L24) != 0;
                    rsVar.j = lpVar;
                    arrayList.add(rsVar);
                    L23 = L23;
                    L24 = L24;
                    L2 = L2;
                    L13 = L13;
                    L15 = L15;
                    L16 = L16;
                    L18 = L18;
                    L9 = L9;
                    L11 = L11;
                    L = L;
                    L22 = L22;
                    L3 = L3;
                    L20 = L20;
                    L4 = L4;
                    L19 = L19;
                }
                b2.close();
                ylVar.f();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                ylVar.f();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            ylVar = e2;
            b2.close();
            ylVar.f();
            throw th;
        }
    }

    public zp g(String str) {
        yl e2 = yl.e("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            e2.E0(1);
        } else {
            e2.z(1, str);
        }
        this.f3404a.assertNotSuspendingTransaction();
        zp zpVar = null;
        Cursor b2 = hm.b(this.f3404a, e2, false, null);
        try {
            if (b2.moveToFirst()) {
                zpVar = vn.H0(b2.getInt(0));
            }
            return zpVar;
        } finally {
            b2.close();
            e2.f();
        }
    }

    public List<String> h(String str) {
        yl e2 = yl.e("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            e2.E0(1);
        } else {
            e2.z(1, str);
        }
        this.f3404a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f3404a, e2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(b2.getString(0));
            }
            return arrayList;
        } finally {
            b2.close();
            e2.f();
        }
    }

    public rs i(String str) {
        yl ylVar;
        Throwable th;
        rs rsVar;
        yl e2 = yl.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE id=?", 1);
        if (str == null) {
            e2.E0(1);
        } else {
            e2.z(1, str);
        }
        this.f3404a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f3404a, e2, false, null);
        try {
            int L = h.L(b2, "required_network_type");
            int L2 = h.L(b2, "requires_charging");
            int L3 = h.L(b2, "requires_device_idle");
            int L4 = h.L(b2, "requires_battery_not_low");
            int L5 = h.L(b2, "requires_storage_not_low");
            int L6 = h.L(b2, "trigger_content_update_delay");
            int L7 = h.L(b2, "trigger_max_content_delay");
            int L8 = h.L(b2, "content_uri_triggers");
            int L9 = h.L(b2, "id");
            int L10 = h.L(b2, RemoteConfigConstants.ResponseFieldKey.STATE);
            int L11 = h.L(b2, "worker_class_name");
            int L12 = h.L(b2, "input_merger_class_name");
            int L13 = h.L(b2, "input");
            int L14 = h.L(b2, "output");
            ylVar = e2;
            try {
                int L15 = h.L(b2, "initial_delay");
                int L16 = h.L(b2, "interval_duration");
                int L17 = h.L(b2, "flex_duration");
                int L18 = h.L(b2, "run_attempt_count");
                int L19 = h.L(b2, "backoff_policy");
                int L20 = h.L(b2, "backoff_delay_duration");
                int L21 = h.L(b2, "period_start_time");
                int L22 = h.L(b2, "minimum_retention_duration");
                int L23 = h.L(b2, "schedule_requested_at");
                int L24 = h.L(b2, "run_in_foreground");
                if (b2.moveToFirst()) {
                    String string = b2.getString(L9);
                    String string2 = b2.getString(L11);
                    lp lpVar = new lp();
                    lpVar.f2251a = vn.G0(b2.getInt(L));
                    lpVar.b = b2.getInt(L2) != 0;
                    lpVar.c = b2.getInt(L3) != 0;
                    lpVar.d = b2.getInt(L4) != 0;
                    lpVar.e = b2.getInt(L5) != 0;
                    lpVar.f = b2.getLong(L6);
                    lpVar.g = b2.getLong(L7);
                    lpVar.h = vn.d(b2.getBlob(L8));
                    rs rsVar2 = new rs(string, string2);
                    rsVar2.b = vn.H0(b2.getInt(L10));
                    rsVar2.d = b2.getString(L12);
                    rsVar2.e = np.a(b2.getBlob(L13));
                    rsVar2.f = np.a(b2.getBlob(L14));
                    rsVar2.g = b2.getLong(L15);
                    rsVar2.h = b2.getLong(L16);
                    rsVar2.i = b2.getLong(L17);
                    rsVar2.k = b2.getInt(L18);
                    rsVar2.l = vn.F0(b2.getInt(L19));
                    rsVar2.m = b2.getLong(L20);
                    rsVar2.n = b2.getLong(L21);
                    rsVar2.o = b2.getLong(L22);
                    rsVar2.p = b2.getLong(L23);
                    rsVar2.q = b2.getInt(L24) != 0;
                    rsVar2.j = lpVar;
                    rsVar = rsVar2;
                } else {
                    rsVar = null;
                }
                b2.close();
                ylVar.f();
                return rsVar;
            } catch (Throwable th2) {
                th = th2;
                b2.close();
                ylVar.f();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            ylVar = e2;
            b2.close();
            ylVar.f();
            throw th;
        }
    }

    public List<rs.a> j(String str) {
        yl e2 = yl.e("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            e2.E0(1);
        } else {
            e2.z(1, str);
        }
        this.f3404a.assertNotSuspendingTransaction();
        Cursor b2 = hm.b(this.f3404a, e2, false, null);
        try {
            int L = h.L(b2, "id");
            int L2 = h.L(b2, RemoteConfigConstants.ResponseFieldKey.STATE);
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                rs.a aVar = new rs.a();
                aVar.f3123a = b2.getString(L);
                aVar.b = vn.H0(b2.getInt(L2));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            b2.close();
            e2.f();
        }
    }

    public int k(String str) {
        this.f3404a.assertNotSuspendingTransaction();
        sm acquire = this.f.acquire();
        if (str == null) {
            acquire.E0(1);
        } else {
            acquire.z(1, str);
        }
        this.f3404a.beginTransaction();
        try {
            int F = acquire.F();
            this.f3404a.setTransactionSuccessful();
            return F;
        } finally {
            this.f3404a.endTransaction();
            this.f.release(acquire);
        }
    }

    public int l(String str, long j) {
        this.f3404a.assertNotSuspendingTransaction();
        sm acquire = this.h.acquire();
        acquire.d0(1, j);
        if (str == null) {
            acquire.E0(2);
        } else {
            acquire.z(2, str);
        }
        this.f3404a.beginTransaction();
        try {
            int F = acquire.F();
            this.f3404a.setTransactionSuccessful();
            return F;
        } finally {
            this.f3404a.endTransaction();
            this.h.release(acquire);
        }
    }

    public int m(String str) {
        this.f3404a.assertNotSuspendingTransaction();
        sm acquire = this.g.acquire();
        if (str == null) {
            acquire.E0(1);
        } else {
            acquire.z(1, str);
        }
        this.f3404a.beginTransaction();
        try {
            int F = acquire.F();
            this.f3404a.setTransactionSuccessful();
            return F;
        } finally {
            this.f3404a.endTransaction();
            this.g.release(acquire);
        }
    }

    public void n(String str, np npVar) {
        this.f3404a.assertNotSuspendingTransaction();
        sm acquire = this.d.acquire();
        byte[] c2 = np.c(npVar);
        if (c2 == null) {
            acquire.E0(1);
        } else {
            acquire.h0(1, c2);
        }
        if (str == null) {
            acquire.E0(2);
        } else {
            acquire.z(2, str);
        }
        this.f3404a.beginTransaction();
        try {
            acquire.F();
            this.f3404a.setTransactionSuccessful();
        } finally {
            this.f3404a.endTransaction();
            this.d.release(acquire);
        }
    }

    public void o(String str, long j) {
        this.f3404a.assertNotSuspendingTransaction();
        sm acquire = this.e.acquire();
        acquire.d0(1, j);
        if (str == null) {
            acquire.E0(2);
        } else {
            acquire.z(2, str);
        }
        this.f3404a.beginTransaction();
        try {
            acquire.F();
            this.f3404a.setTransactionSuccessful();
        } finally {
            this.f3404a.endTransaction();
            this.e.release(acquire);
        }
    }

    public int p(zp zpVar, String... strArr) {
        this.f3404a.assertNotSuspendingTransaction();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE workspec SET state=");
        sb.append("?");
        sb.append(" WHERE id IN (");
        im.a(sb, strArr.length);
        sb.append(")");
        sm compileStatement = this.f3404a.compileStatement(sb.toString());
        compileStatement.d0(1, (long) vn.c1(zpVar));
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                compileStatement.E0(i2);
            } else {
                compileStatement.z(i2, str);
            }
            i2++;
        }
        this.f3404a.beginTransaction();
        try {
            int F = compileStatement.F();
            this.f3404a.setTransactionSuccessful();
            return F;
        } finally {
            this.f3404a.endTransaction();
        }
    }
}
