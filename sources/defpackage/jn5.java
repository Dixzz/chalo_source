package defpackage;

import android.os.Looper;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.automation.ScheduleDelay;
import com.urbanairship.automation.Trigger;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.json.JsonValue;
import defpackage.go5;
import defpackage.ln5;
import defpackage.on5;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* renamed from: jn5  reason: default package */
/* compiled from: InAppRemoteDataObserver */
public class jn5 {

    /* renamed from: a  reason: collision with root package name */
    public final hk5 f1959a;
    public final wx5 b;
    public final List<d> c = new ArrayList();

    /* renamed from: jn5$a */
    /* compiled from: InAppRemoteDataObserver */
    public class a extends mx5<by5> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1960a;

        public a(c cVar) {
            this.f1960a = cVar;
        }

        @Override // defpackage.hx5
        public void b(Object obj) {
            try {
                jn5.a(jn5.this, (by5) obj, this.f1960a);
                yj5.a("Finished processing messages.", new Object[0]);
            } catch (Exception e) {
                yj5.e(e, "InAppRemoteDataObserver - Failed to process payload: ", new Object[0]);
            }
        }
    }

    /* renamed from: jn5$b */
    /* compiled from: InAppRemoteDataObserver */
    public class b implements dk5<by5> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.dk5
        public boolean apply(by5 by5) {
            by5 by52 = by5;
            if (by52.b != jn5.this.f1959a.e("com.urbanairship.iam.data.LAST_PAYLOAD_TIMESTAMP", -1)) {
                return true;
            }
            return true ^ by52.d.equals(jn5.this.c());
        }
    }

    /* renamed from: jn5$c */
    /* compiled from: InAppRemoteDataObserver */
    public interface c {
    }

    /* renamed from: jn5$d */
    /* compiled from: InAppRemoteDataObserver */
    public interface d {
        void a();
    }

    public jn5(hk5 hk5, wx5 wx5) {
        this.f1959a = hk5;
        this.b = wx5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v63, types: [java.util.Set] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(defpackage.jn5 r17, defpackage.by5 r18, defpackage.jn5.c r19) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 645
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jn5.a(jn5, by5, jn5$c):void");
    }

    public static fm5 e(JsonValue jsonValue) throws xt5 {
        JsonValue jsonValue2 = jsonValue.n().f.get("audience");
        if (jsonValue2 == null) {
            jsonValue2 = jsonValue.n().u("message").n().f.get("audience");
        }
        if (jsonValue2 == null) {
            return null;
        }
        return fm5.a(jsonValue2);
    }

    public static List<String> g(yt5 yt5) throws xt5 {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonValue> it = yt5.iterator();
        while (it.hasNext()) {
            JsonValue next = it.next();
            if (next.f instanceof String) {
                arrayList.add(next.o());
            } else {
                throw new xt5(hj1.R("Invalid constraint ID: ", next));
            }
        }
        return arrayList;
    }

    public static on5<? extends mn5> h(JsonValue jsonValue, zt5 zt5) throws xt5 {
        on5.b bVar;
        zt5 n = jsonValue.n();
        String i = n.u("type").i();
        if (i == null) {
            i = "in_app_message";
        }
        char c2 = 65535;
        int hashCode = i.hashCode();
        if (hashCode != -1161803523) {
            if (hashCode != -379237425) {
                if (hashCode == 647890911 && i.equals("deferred")) {
                    c2 = 2;
                }
            } else if (i.equals("in_app_message")) {
                c2 = 1;
            }
        } else if (i.equals("actions")) {
            c2 = 0;
        }
        if (c2 == 0) {
            zt5 h = n.u("actions").h();
            if (h != null) {
                bVar = new on5.b("actions", new vn5(h), null);
            } else {
                throw new xt5("Missing actions payload");
            }
        } else if (c2 == 1) {
            bVar = new on5.b("in_app_message", InAppMessage.a(n.u("message"), "remote-data"), null);
        } else if (c2 == 2) {
            bVar = new on5.b("deferred", co5.a(n.u("deferred")), null);
        } else {
            throw new xt5(hj1.S("Unexpected schedule type: ", i));
        }
        bVar.g = zt5;
        bVar.f2716a = Integer.valueOf(n.u("limit").e(1));
        bVar.d = Integer.valueOf(n.u("priority").e(0));
        bVar.e = Long.valueOf(TimeUnit.DAYS.toMillis(n.u("edit_grace_period").g(0)));
        bVar.f = Long.valueOf(TimeUnit.SECONDS.toMillis(n.u("interval").g(0)));
        bVar.l = e(jsonValue);
        bVar.i = n.u("campaigns");
        bVar.b = Long.valueOf(j(n.u(AnalyticsConstants.START).i()));
        bVar.c = Long.valueOf(j(n.u(AnalyticsConstants.END).i()));
        bVar.j = new ArrayList(g(n.u("frequency_constraint_ids").m()));
        return new on5<>(bVar, null);
    }

    public static ln5<? extends mn5> i(String str, JsonValue jsonValue, zt5 zt5) throws xt5 {
        ln5.b bVar;
        zt5 n = jsonValue.n();
        String i = n.u("type").i();
        if (i == null) {
            i = "in_app_message";
        }
        i.hashCode();
        char c2 = 65535;
        switch (i.hashCode()) {
            case -1161803523:
                if (i.equals("actions")) {
                    c2 = 0;
                    break;
                }
                break;
            case -379237425:
                if (i.equals("in_app_message")) {
                    c2 = 1;
                    break;
                }
                break;
            case 647890911:
                if (i.equals("deferred")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                zt5 h = n.u("actions").h();
                if (h != null) {
                    bVar = ln5.b(new vn5(h));
                    break;
                } else {
                    throw new xt5("Missing actions payload");
                }
            case 1:
                bVar = ln5.c(InAppMessage.a(n.u("message"), "remote-data"));
                break;
            case 2:
                bVar = new ln5.b("deferred", co5.a(n.u("deferred")), null);
                break;
            default:
                throw new xt5(hj1.S("Unexpected type: ", i));
        }
        bVar.m = str;
        bVar.l = zt5;
        bVar.k = n.u("group").i();
        bVar.f2244a = n.u("limit").e(1);
        bVar.f = n.u("priority").e(0);
        bVar.o = n.u("campaigns");
        bVar.n = e(jsonValue);
        bVar.g = TimeUnit.DAYS.toMillis(n.u("edit_grace_period").g(0));
        bVar.b(n.u("interval").g(0), TimeUnit.SECONDS);
        bVar.b = j(n.u(AnalyticsConstants.START).i());
        bVar.c = j(n.u(AnalyticsConstants.END).i());
        bVar.p = g(n.u("frequency_constraint_ids").m());
        Iterator<JsonValue> it = n.u("triggers").m().iterator();
        while (it.hasNext()) {
            bVar.d.add(Trigger.c(it.next()));
        }
        if (n.f.containsKey("delay")) {
            bVar.e = ScheduleDelay.a(n.u("delay"));
        }
        try {
            return bVar.a();
        } catch (IllegalArgumentException e) {
            throw new xt5("Invalid schedule", e);
        }
    }

    public static long j(String str) throws xt5 {
        if (str == null) {
            return -1;
        }
        try {
            return ly5.b(str);
        } catch (ParseException e) {
            throw new xt5(hj1.S("Invalid timestamp: ", str), e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0098 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(defpackage.ln5<? extends defpackage.mn5> r6, long r7) {
        /*
        // Method dump skipped, instructions count: 153
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jn5.b(ln5, long):boolean");
    }

    public final zt5 c() {
        return this.f1959a.d("com.urbanairship.iam.data.LAST_PAYLOAD_METADATA").n();
    }

    public boolean d(ln5<? extends mn5> ln5) {
        if (ln5.b.f.containsKey("com.urbanairship.iaa.REMOTE_DATA_METADATA")) {
            return true;
        }
        if ("in_app_message".equals(ln5.o)) {
            return "remote-data".equals(((InAppMessage) ln5.a()).m);
        }
        return false;
    }

    public final go5 f(zt5 zt5) throws xt5 {
        go5.b bVar = new go5.b(null);
        bVar.f1291a = zt5.u("id").i();
        boolean z = false;
        bVar.c = zt5.u("boundary").e(0);
        long g = zt5.u("range").g(0);
        String o = zt5.u("period").o();
        o.hashCode();
        char c2 = 65535;
        switch (o.hashCode()) {
            case -1068487181:
                if (o.equals("months")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3076183:
                if (o.equals("days")) {
                    c2 = 1;
                    break;
                }
                break;
            case 99469071:
                if (o.equals("hours")) {
                    c2 = 2;
                    break;
                }
                break;
            case 113008383:
                if (o.equals("weeks")) {
                    c2 = 3;
                    break;
                }
                break;
            case 114851798:
                if (o.equals("years")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1064901855:
                if (o.equals("minutes")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1970096767:
                if (o.equals("seconds")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                bVar.a(TimeUnit.DAYS, g * 30);
                break;
            case 1:
                bVar.a(TimeUnit.DAYS, g);
                break;
            case 2:
                bVar.a(TimeUnit.HOURS, g);
                break;
            case 3:
                bVar.a(TimeUnit.DAYS, g * 7);
                break;
            case 4:
                bVar.a(TimeUnit.DAYS, g * 365);
                break;
            case 5:
                bVar.a(TimeUnit.MINUTES, g);
                break;
            case 6:
                bVar.a(TimeUnit.SECONDS, g);
                break;
            default:
                throw new xt5(hj1.S("Invalid period: ", o));
        }
        try {
            hd3.E(bVar.f1291a, "missing id");
            hd3.D(bVar.b > 0, "missing range");
            if (bVar.c > 0) {
                z = true;
            }
            hd3.D(z, "missing count");
            return new go5(bVar, null);
        } catch (IllegalArgumentException e) {
            throw new xt5(hj1.Q("Invalid constraint: ", zt5), e);
        }
    }

    public nx5 k(Looper looper, c cVar) {
        wx5 wx5 = this.b;
        Objects.requireNonNull(wx5);
        sw5<R> d2 = wx5.l(Collections.singleton("in_app_messages")).d(new xx5(wx5));
        return d2.d(new ex5(d2, new b())).f(new jx5(looper)).h(new jx5(looper)).g(new a(cVar));
    }
}
