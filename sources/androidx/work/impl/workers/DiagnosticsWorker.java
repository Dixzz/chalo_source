package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.rabbitmq.client.AMQP;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {
    public static final String k = tp.e("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    /* JADX INFO: finally extract failed */
    public static String h(ms msVar, vs vsVar, js jsVar, List<rs> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"));
        for (rs rsVar : list) {
            is a2 = ((ks) jsVar).a(rsVar.f3122a);
            Integer valueOf = a2 != null ? Integer.valueOf(a2.b) : null;
            String str = rsVar.f3122a;
            ns nsVar = (ns) msVar;
            Objects.requireNonNull(nsVar);
            yl e = yl.e("SELECT name FROM workname WHERE work_spec_id=?", 1);
            if (str == null) {
                e.E0(1);
            } else {
                e.z(1, str);
            }
            nsVar.f2598a.assertNotSuspendingTransaction();
            Cursor b = hm.b(nsVar.f2598a, e, false, null);
            try {
                ArrayList arrayList = new ArrayList(b.getCount());
                while (b.moveToNext()) {
                    arrayList.add(b.getString(0));
                }
                b.close();
                e.f();
                sb.append(String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", rsVar.f3122a, rsVar.c, valueOf, rsVar.b.name(), TextUtils.join(",", arrayList), TextUtils.join(",", ((ws) vsVar).a(rsVar.f3122a))));
            } catch (Throwable th) {
                b.close();
                e.f();
                throw th;
            }
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a g() {
        yl ylVar;
        Throwable th;
        js jsVar;
        vs vsVar;
        ms msVar;
        int i;
        WorkDatabase workDatabase = pq.a(this.f).c;
        ss f = workDatabase.f();
        ms d = workDatabase.d();
        vs g = workDatabase.g();
        js c = workDatabase.c();
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1);
        ts tsVar = (ts) f;
        Objects.requireNonNull(tsVar);
        yl e = yl.e("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        e.d0(1, currentTimeMillis);
        tsVar.f3404a.assertNotSuspendingTransaction();
        Cursor b = hm.b(tsVar.f3404a, e, false, null);
        try {
            int L = h.L(b, "required_network_type");
            int L2 = h.L(b, "requires_charging");
            int L3 = h.L(b, "requires_device_idle");
            int L4 = h.L(b, "requires_battery_not_low");
            int L5 = h.L(b, "requires_storage_not_low");
            int L6 = h.L(b, "trigger_content_update_delay");
            int L7 = h.L(b, "trigger_max_content_delay");
            int L8 = h.L(b, "content_uri_triggers");
            int L9 = h.L(b, "id");
            int L10 = h.L(b, RemoteConfigConstants.ResponseFieldKey.STATE);
            int L11 = h.L(b, "worker_class_name");
            int L12 = h.L(b, "input_merger_class_name");
            int L13 = h.L(b, "input");
            int L14 = h.L(b, "output");
            ylVar = e;
            try {
                int L15 = h.L(b, "initial_delay");
                int L16 = h.L(b, "interval_duration");
                int L17 = h.L(b, "flex_duration");
                int L18 = h.L(b, "run_attempt_count");
                int L19 = h.L(b, "backoff_policy");
                int L20 = h.L(b, "backoff_delay_duration");
                int L21 = h.L(b, "period_start_time");
                int L22 = h.L(b, "minimum_retention_duration");
                int L23 = h.L(b, "schedule_requested_at");
                int L24 = h.L(b, "run_in_foreground");
                int i2 = L14;
                ArrayList arrayList = new ArrayList(b.getCount());
                while (b.moveToNext()) {
                    String string = b.getString(L9);
                    String string2 = b.getString(L11);
                    lp lpVar = new lp();
                    lpVar.f2251a = vn.G0(b.getInt(L));
                    lpVar.b = b.getInt(L2) != 0;
                    lpVar.c = b.getInt(L3) != 0;
                    lpVar.d = b.getInt(L4) != 0;
                    lpVar.e = b.getInt(L5) != 0;
                    lpVar.f = b.getLong(L6);
                    lpVar.g = b.getLong(L7);
                    lpVar.h = vn.d(b.getBlob(L8));
                    rs rsVar = new rs(string, string2);
                    rsVar.b = vn.H0(b.getInt(L10));
                    rsVar.d = b.getString(L12);
                    rsVar.e = np.a(b.getBlob(L13));
                    rsVar.f = np.a(b.getBlob(i2));
                    i2 = i2;
                    rsVar.g = b.getLong(L15);
                    rsVar.h = b.getLong(L16);
                    rsVar.i = b.getLong(L17);
                    rsVar.k = b.getInt(L18);
                    rsVar.l = vn.F0(b.getInt(L19));
                    L17 = L17;
                    rsVar.m = b.getLong(L20);
                    rsVar.n = b.getLong(L21);
                    L21 = L21;
                    rsVar.o = b.getLong(L22);
                    L22 = L22;
                    rsVar.p = b.getLong(L23);
                    rsVar.q = b.getInt(L24) != 0;
                    rsVar.j = lpVar;
                    arrayList.add(rsVar);
                    L23 = L23;
                    L24 = L24;
                    L10 = L10;
                    L12 = L12;
                    L11 = L11;
                    L2 = L2;
                    L = L;
                    L15 = L15;
                    L9 = L9;
                    L20 = L20;
                    L13 = L13;
                    L16 = L16;
                    L18 = L18;
                    L19 = L19;
                }
                b.close();
                ylVar.f();
                List<rs> e2 = tsVar.e();
                List<rs> b2 = tsVar.b(AMQP.REPLY_SUCCESS);
                if (!arrayList.isEmpty()) {
                    tp c2 = tp.c();
                    String str = k;
                    i = 0;
                    c2.d(str, "Recently completed work:\n\n", new Throwable[0]);
                    jsVar = c;
                    msVar = d;
                    vsVar = g;
                    tp.c().d(str, h(msVar, vsVar, jsVar, arrayList), new Throwable[0]);
                } else {
                    jsVar = c;
                    msVar = d;
                    vsVar = g;
                    i = 0;
                }
                if (!((ArrayList) e2).isEmpty()) {
                    tp c3 = tp.c();
                    String str2 = k;
                    c3.d(str2, "Running work:\n\n", new Throwable[i]);
                    tp.c().d(str2, h(msVar, vsVar, jsVar, e2), new Throwable[i]);
                }
                if (!((ArrayList) b2).isEmpty()) {
                    tp c4 = tp.c();
                    String str3 = k;
                    c4.d(str3, "Enqueued work:\n\n", new Throwable[i]);
                    tp.c().d(str3, h(msVar, vsVar, jsVar, b2), new Throwable[i]);
                }
                return new ListenableWorker.a.c();
            } catch (Throwable th2) {
                th = th2;
                b.close();
                ylVar.f();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            ylVar = e;
            b.close();
            ylVar.f();
            throw th;
        }
    }
}
